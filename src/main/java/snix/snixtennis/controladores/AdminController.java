/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.controladores;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

public class AdminController {

    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private ArchivoServicio archivoServicio;
    @Autowired
    private PedidoServicio pedidoServicio;

    @Value("${valor.ruta}")
    private String ruta;

    @GetMapping("/registrarProducto")
    public String registrarProductos(Model model) {
        model.addAttribute("producto", new Producto());
        return "formularios/registrarProducto";
    }

    //SECCION PRODUCTO ADMIN
    @GetMapping("/listaProductos")
    public String listaProductos(Model model) {
        List<Producto> producto = productoServicio.listarProductos();
        if (producto.isEmpty()) {
            model.addAttribute("clase", "error");
            model.addAttribute("mensaje", "la lista esta vacia");

            return "listarProductos";
        }

        model.addAttribute("productos", producto);
        return "listarProductos";
    }

    @PostMapping("/registrarProducto")
    @ResponseBody
    public ResponseEntity<?> registrarProducto(@Valid Producto producto, BindingResult result, @RequestParam("archivos[]") MultipartFile[] files, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        List<Archivo> imagenes = new ArrayList<>();
        Path rutaFinal = Paths.get(ruta + producto.getNombre().trim() + "/".trim());
        try {
            if (result.hasErrors()) {
                StringBuilder errors = new StringBuilder();
                result.getFieldErrors().forEach(error -> {
                    errors.append(error.getField())
                            .append(": ")
                            .append(error.getDefaultMessage())
                            .append("\n");
                });

                response.put("clase", "error");
                response.put("mensaje", errors.toString());
                return ResponseEntity.badRequest().body(response);
            }
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
                if (file == null || file.isEmpty()) {
                    continue;
                }

                String nombreArchivo = ArchivoUpload.guardarArchivo(file, this.ruta + producto.getNombre() + "/");

                if (nombreArchivo.equals("no")) {
                    response.put("clase", "error");
                    response.put("mensaje", "error, el archivo no es del formato esperado, solo utilice jpg, jpeg o png");
                    return ResponseEntity.badRequest().body(response);
                }

                Archivo imagen = new Archivo();
                imagen.setFileName(nombreArchivo);
                imagen.setFileType(file.getContentType());
                imagen.setProducto(producto);
                imagen.setRuta(this.ruta);

                archivoServicio.crearArchivo(imagen);
                imagenes.add(imagen);

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
            response.put("mensaje", "Error inesperado encontrado " + e.getMessage() + e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }

    @GetMapping("/editarProducto/{id}")

    public String editarProducto(@PathVariable("id") String id, HttpSession session, Model model) {

        Producto pro = productoServicio.listarProductoPorId(id);
        session.getAttribute("producto");
        model.addAttribute("producto", pro);
        return "formularios/editarProducto";

    }

    @PostMapping("/editarProducto/{id}")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> editarProductoForm(@PathVariable("id") String id,
            @ModelAttribute Producto productoDatos,
            @RequestParam(value = "archivos", required = false) MultipartFile[] files,
            BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Validate input data
            if (result.hasErrors()) {
                String errorMessage = result.getFieldErrors().stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .collect(Collectors.joining(", "));

                response.put("clase", "error");
                response.put("mensaje", "Errores de validación: " + errorMessage);
                return ResponseEntity.badRequest().body(response);
            }

            // Get the existing product from database (IMPORTANT!)
            Producto productoExistente = productoServicio.listarProductoPorId(id);
            if (productoExistente == null) {
                response.put("clase", "error");
                response.put("mensaje", "Producto no encontrado");
                return ResponseEntity.badRequest().body(response);
            }

            // Update basic product data
            productoExistente.setNombre(productoDatos.getNombre());
            productoExistente.setPrecio(productoDatos.getPrecio());
            productoExistente.setDetalles(productoDatos.getDetalles());
            productoExistente.setCategoria(productoDatos.getCategoria());
            productoExistente.setMarca(productoDatos.getMarca());
            // Add other fields as needed

            // Handle case when no files are uploaded or all files are empty
            if (files == null || files.length == 0
                    || Arrays.stream(files).allMatch(f -> f == null || f.isEmpty() || f.getSize() == 0)) {

                // Just update the product data without touching images
                productoServicio.editarProducto(productoExistente);
                response.put("clase", "warning");
                response.put("mensaje", "No se modificaron las imágenes");
                return ResponseEntity.ok().body(response);
            }

            // Create product directory if it doesn't exist
            Path rutaFinal = Paths.get(ruta, productoExistente.getNombre().trim());
            try {
                if (!Files.exists(rutaFinal)) {
                    Files.createDirectories(rutaFinal);
                }
            } catch (IOException e) {
                response.put("clase", "error");
                response.put("mensaje", "Error creando directorio del producto: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            // Process uploaded files
            List<Archivo> nuevasImagenes = new ArrayList<>();
            for (MultipartFile file : files) {
                // Skip empty files
                if (file == null || file.isEmpty() || file.getSize() == 0) {
                    continue;
                }

                String nombreArchivo = ArchivoUpload.guardarArchivo(file, rutaFinal.toString() + "/");

                if ("no".equals(nombreArchivo)) {
                    response.put("clase", "error");
                    response.put("mensaje", "Formato de archivo no válido. Solo se permiten archivos jpg, jpeg o png");
                    return ResponseEntity.badRequest().body(response);
                }

                if (nombreArchivo != null) {
                    Archivo imagen = new Archivo();
                    imagen.setFileName(nombreArchivo);
                    imagen.setFileType(file.getContentType());
                    imagen.setProducto(productoExistente); // Use existing product
                    imagen.setRuta(this.ruta);

                    // Save the image first
                    archivoServicio.crearArchivo(imagen);
                    nuevasImagenes.add(imagen);
                }
            }

            // Add new images to existing collection (don't replace the collection)
            if (!nuevasImagenes.isEmpty()) {
                List<Archivo> imagenesExistentes = productoExistente.getImagenes();
                if (imagenesExistentes == null) {
                    imagenesExistentes = new ArrayList<>();
                    productoExistente.setImagenes(imagenesExistentes);
                }

                // Add new images to the existing collection
                imagenesExistentes.addAll(nuevasImagenes);
            }

            // Save the updated product
            productoServicio.editarProducto(productoExistente);

            response.put("clase", "success");
            response.put("mensaje", "Producto editado exitosamente");
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {

            System.err.print("Error inesperado al editar producto: " + e);
            response.put("clase", "error");
            response.put("mensaje", "Error interno del servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/eliminarProducto/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminarProducto(@PathVariable("id") String id, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            Producto pro = productoServicio.listarProductoPorId(id);

            if (pro == null) {
                response.put("clase", "success");
                response.put("mensaje", "Producto no encontrado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            if (pro.getImagenes().isEmpty()) {
                productoServicio.eliminarProducto(pro);
                response.put("clase", "success");
                response.put("mensaje", "Producto eliminado con exito");

            } else {

                for (Archivo imagen : pro.getImagenes()) {

                    imagen.setProducto(null);

                }

                pro.getImagenes().clear();
                productoServicio.eliminarProducto(pro);
                response.put("clase", "success");
                response.put("mensaje", "Exito al eliminar producto");

            }
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            e.printStackTrace();
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
