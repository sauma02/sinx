/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.controladores;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import snix.snixtennis.DTOs.ProductoDTO;
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.entidades.ItemCarrito;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.servicios.DTOServicio;
import snix.snixtennis.servicios.ProductoServicio;

/**
 *
 * @author sauma
 */
@Controller
@CrossOrigin(origins = {"http://127.0.0.1:5500/", "http://127.0.0.1:5500/productos.html"})
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private DTOServicio dtoServicio;

    @GetMapping("/productos")
    @ResponseBody
    public ResponseEntity<?> productos(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        List<ItemCarrito> carro =(List<ItemCarrito>) session.getAttribute("carrito");

        try {
            List<Producto> productosOriginal = productoServicio.listarProductos();
            List<ProductoDTO> dtos = dtoServicio.listaDto(productosOriginal);
            response.put("carro", carro);
            response.put("dtos", dtos);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.internalServerError().body(response);

        }

    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> home(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Producto> productos = productoServicio.listarProductos();
            List<ProductoDTO> productosDto = productos.stream().map(producto -> dtoServicio.productoToDTO(producto)).collect(Collectors.toList());
            List<ItemCarrito> carro = (List<ItemCarrito>) session.getAttribute("carrito");
            if (carro == null) {
                Carrito car = new Carrito();
                session.setAttribute("carrito", car);
                response.put("carrito", carro);
                response.put("productos", productosDto);
                return ResponseEntity.ok().body(response);
            }
            response.put("carrito", carro);
            response.put("productos", productosDto);
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @PostMapping("/eliminarProducto/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminarProductoCarrito(@PathVariable("id") String id, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        List<ItemCarrito> carro = (List<ItemCarrito>) session.getAttribute("carrito");

        try {
            if (carro == null || carro.isEmpty()) {
                response.put("clase", "error");
                response.put("mensaje", "El carro no existe o esta vacio");
                return ResponseEntity.badRequest().body(response);
            }
            boolean flag = false;
            for (Integer i = 0; i < carro.size(); i++) {
                ItemCarrito item = carro.get(i);
                if (item.getDto().getId().equals(id)) {
                    carro.remove(i);
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                response.put("clase", "error");
                response.put("mensaje", "El producto no existe");
                return ResponseEntity.badRequest().body(response);
            }

            response.put("carrito", carro);
            response.put("clase", "success");
            response.put("mensaje", "El producto fue eliminado con exito");
            session.setAttribute("carrito", carro);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado:" + e.getMessage());
        }
    }

    @PostMapping("/editarProductoCantidadCarrito/{id}")
    @ResponseBody
    public ResponseEntity<?> editarCarritoCarrito(@PathVariable("id") String id, @RequestParam("cantidad") Integer cantidad, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        List<ItemCarrito> carro = (List<ItemCarrito>) session.getAttribute("carrito");

        try {
            Producto pro = productoServicio.listarProductoPorId(id);
            if (carro == null) {
                response.put("clase", "error");
                response.put("mensaje", "error, no existe ningun carro");
                return ResponseEntity.badRequest().body(response);
            }
            if (cantidad == null || cantidad == 0) {
                response.put("clase", "error");
                response.put("mensaje", "Error, la cantidad no puede ser 0");
                return ResponseEntity.badRequest().body(response);
            }
            if (cantidad > pro.getStock()) {
                response.put("clase", "error");
                response.put("mensaje", "Error, la cantidad no puede exceder a la que hay en stock: " + pro.getStock());
                return ResponseEntity.badRequest().body(response);
            }
            boolean flag = false;
            for (ItemCarrito itemCarrito : carro) {

                if (itemCarrito.getDto().getId().equals(id)) {
                    Double newSubTotal = cantidad * itemCarrito.getDto().getPrecio();
                    itemCarrito.setCantidad(cantidad);
                    itemCarrito.setSubTotal(newSubTotal);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                response.put("clase", "error");
                response.put("mensaje", "El producto no existe");
                return ResponseEntity.badRequest().body(response);
            }

            response.put("carrito", carro);
            session.setAttribute("carrito", carro);
            response.put("clase", "success");
            response.put("mensaje", "Cantidad editada con exito");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
        }
    }

    @PostMapping("/añadirProductoCarrito/id={id}?cantidad={cantidad}")
    @ResponseBody
    public ResponseEntity<?> añadirProductoCarrito(@PathVariable("id") String id, @RequestParam("cantidad") Integer cantidad, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        try {
            List<ItemCarrito> carro = (List<ItemCarrito>) session.getAttribute("carrito");
            ItemCarrito item = new ItemCarrito();

            Producto pro = productoServicio.listarProductoPorId(id);
            ProductoDTO dto = dtoServicio.productoToDTO(pro);
            if (cantidad > pro.getStock()) {
                response.put("clase", "error");
                response.put("mensaje", "Cantidad ingresada supera el stock disponible (" + pro.getStock() + ").");
                return ResponseEntity.badRequest().body(response);
            }

            if (carro == null) {
                List<ItemCarrito> carrito = new ArrayList<>();
                item.setDto(dto);

                item.setCantidad(cantidad);
                item.setSubTotal(dto.getPrecio() * cantidad);
                carrito.add(item);
                response.put("carrito", carrito);
                response.put("clase", "success");
                response.put("mensaje", "Producto añadido correctamente");
                session.setAttribute("carrito", carrito);
                return ResponseEntity.ok().body(response);
            } else {
                boolean encontrado = false;
                if (carro.isEmpty()) {
                    item.setDto(dto);
                    item.setCantidad(cantidad);
                    item.setSubTotal(dto.getPrecio() * cantidad);
                    carro.add(item);
                    response.put("carrito", carro);
                    response.put("clase", "success");
                    response.put("mensaje", "Producto añadido correctamente");
                    session.setAttribute("carrito", carro);
                    return ResponseEntity.ok().body(response);
                } else {
                    for (ItemCarrito itemCarrito : carro) {
                        if (itemCarrito.getDto().getId().equals(dto.getId())) {
                            itemCarrito.setCantidad(itemCarrito.getCantidad() + cantidad);
                            itemCarrito.setSubTotal(itemCarrito.getCantidad() * dto.getPrecio());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        item.setDto(dto);
                        item.setCantidad(cantidad);
                        item.setSubTotal(dto.getPrecio() * cantidad);
                        carro.add(item);
                    }
                    session.setAttribute("carrito", carro);

                    response.put("carrito", carro);

                    response.put("clase", "success");
                    response.put("mensaje", "Producto añadido con exito");
                    return ResponseEntity.ok().body(response);
                }

            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
