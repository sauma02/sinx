/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.controladores;

import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import snix.snixtennis.entidades.Archivo;
import snix.snixtennis.entidades.Pedido;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.servicios.ArchivoServicio;
import snix.snixtennis.servicios.PedidoServicio;
import snix.snixtennis.servicios.ProductoServicio;
import snix.snixtennis.utils.ArchivoUpload;

/**
 *
 * @author sauma
 */
@Controller
@RequestMapping("/admin")
@ResponseBody

public class AdminController {

    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private ArchivoServicio archivoServicio;
    @Autowired
    private PedidoServicio pedidoServicio;



    @Value("${valor.ruta}")
    private String ruta;

    //SECCION PRODUCTO ADMIN
    @GetMapping("/listaProductos")
    @ResponseBody
    public ResponseEntity<?> admin(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        List<Producto> listarProductos = productoServicio.listarProductos();
        try {
            if (listarProductos.isEmpty()) {
                List<Producto> lista = new ArrayList<>();
                session.setAttribute("productos", lista);
                response.put("productos", lista);
                response.put("mensaje", "La lista esta vacia");
                return ResponseEntity.ok().body(response);
            }
            session.setAttribute("productos", listarProductos);
            response.put("productos", listarProductos);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/registrarProducto")
    @ResponseBody
    public ResponseEntity<?> registrarProducto(@RequestPart Producto producto, @RequestParam("archivos") MultipartFile[] files, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        List<Archivo> imagenes = new ArrayList<>();
        Path rutaFinal = Paths.get(ruta + producto.getNombre().trim() + "/".trim());
        try {

            if (files.length == 0) {
                producto.setImagenes(imagenes);
                productoServicio.crearProducto(producto);
                Files.createDirectories(rutaFinal);
                response.put("clase", "warning");
                response.put("mensaje", "Se creo el producto sin imagenes");
                return ResponseEntity.ok().body(response);
            }
            productoServicio.crearProducto(producto);
            Files.createDirectories(rutaFinal);
           
            for (MultipartFile file : files) {
                String nombreArchivo = ArchivoUpload.guardarArchivo(file, this.ruta + producto.getNombre() + "/");
                
                if(nombreArchivo.equals("no")){
                    response.put("clase", "error");
                    response.put("mensaje", "error, el archivo no es del formato esperado, solo utilice jpg, jpeg o png");
                    return ResponseEntity.badRequest().body(response);
                }
                
                
                if (nombreArchivo != null) {
                    Archivo imagen = new Archivo();
                    imagen.setFileName(nombreArchivo);
                    imagen.setFileType(file.getContentType());
                    imagen.setProducto(producto);
                    imagen.setRuta(this.ruta);
                    
                    archivoServicio.crearArchivo(imagen);
                    imagenes.add(imagen);
                }

            }
            producto.setImagenes(imagenes);
            productoServicio.editarProducto(producto);
            response.put("clase", "success");
            response.put("mensaje", "Exito al guardar producto");
            session.setAttribute("producto", producto);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            System.err.print(e.getStackTrace());
            response.put("clase", "error");
            response.put("mensaje", "Error inesperado encontrado " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }

    @GetMapping("/editarProducto/{id}")
    @ResponseBody
    public ResponseEntity<?> editarProducto(@PathVariable("id") String id, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Producto pro = productoServicio.listarProductoPorId(id);
        session.getAttribute("producto");
        response.put("producto", pro);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/editarProducto")
    @ResponseBody
    public ResponseEntity<?> editarProductoForm(@RequestBody Producto producto, @RequestParam("archivos") MultipartFile[] files) {
        Map<String, Object> response = new HashMap<>();

        try {
            if (producto.getImagenes() == null || producto.getImagenes().isEmpty()) {
                List<Archivo> imagenes = new ArrayList<>();
                for (MultipartFile file : files) {
                   String nombreArchivo = ArchivoUpload.guardarArchivo(file, this.ruta + producto.getNombre() + "/");
                
                if(nombreArchivo.equals("no")){
                    response.put("clase", "error");
                    response.put("mensaje", "error, el archivo no es del formato esperado, solo utilice jpg, jpeg o png");
                    return ResponseEntity.badRequest().body(response);
                }
                
                
                if (nombreArchivo != null) {
                    Archivo imagen = new Archivo();
                    imagen.setFileName(nombreArchivo);
                    imagen.setFileType(file.getContentType());
                    imagen.setProducto(producto);
                    imagen.setRuta(this.ruta);
                    
                    archivoServicio.crearArchivo(imagen);
                    imagenes.add(imagen);
                }
                }
                producto.setImagenes(imagenes);
                productoServicio.editarProducto(producto);
                response.put("clase", "success");
                response.put("mensaje", "Exito al editar producto");
                return ResponseEntity.ok().body(response);
            } else {
                List<Archivo> imagenes = producto.getImagenes();

                for (MultipartFile file : files) {
                   String nombreArchivo = ArchivoUpload.guardarArchivo(file, this.ruta + producto.getNombre() + "/");
                    System.out.println(nombreArchivo);

                if("no".equals(nombreArchivo)){
                    
                    response.put("clase", "error");
                    response.put("mensaje", "error, el archivo no es del formato esperado, solo utilice jpg, jpeg o png");
                    return ResponseEntity.badRequest().body(response);
                }
                
                
                if (nombreArchivo != null) {
                    Archivo imagen = new Archivo();
                    imagen.setFileName(nombreArchivo);
                    imagen.setFileType(file.getContentType());
                    imagen.setProducto(producto);
                    imagen.setRuta(this.ruta);
                    
                    archivoServicio.crearArchivo(imagen);
                    imagenes.add(imagen);
                }

                }
                producto.setImagenes(imagenes);
                productoServicio.editarProducto(producto);
                response.put("clase", "success");
                response.put("mensaje", "Exito al editar producto");
                return ResponseEntity.ok().body(response);
            }

        } catch (Exception e) {
            response.put("clase", "error");
            response.put("mensaje", "Error inesperado" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/eliminarProducto/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminarProducto(@PathVariable("id") String id, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            Producto pro = productoServicio.listarProductoPorId(id);
            if(pro.getImagenes().isEmpty()){
            productoServicio.eliminarProducto(id);
            response.put("clase", "success");
            response.put("mensaje", "Producto eliminado con exito");
            return ResponseEntity.ok().body(response);
            }else{
                
             for(Archivo imagen : pro.getImagenes()){
                 archivoServicio.eliminarArchivo(imagen);
             }
             pro.setImagenes(null);
             productoServicio.editarProducto(pro);
             productoServicio.eliminarProducto(id);
             response.put("clase", "success");
             response.put("mensaje", "Exito al eliminar producto");
             return ResponseEntity.ok().body(response);
            }
           

        } catch (Exception e) {
            response.put("clase", "error");
            response.put("mensaje", "Error inesperado " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }

    @GetMapping("/historialPedidos")
    @ResponseBody
    public ResponseEntity<?> historialPedidos(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Pedido> pedido = pedidoServicio.listarPedidos();
            if (pedido.isEmpty()) {
                response.put("clase", "error");
                response.put("mensaje", "No hay pedidos registrados");
                return ResponseEntity.badRequest().body(response);

            }
            session.setAttribute("listaPedidos", pedido);

            response.put("listaPedido", pedido);
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

}
