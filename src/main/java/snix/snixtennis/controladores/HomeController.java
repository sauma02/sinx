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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import snix.snixtennis.DTOs.ProductoDTO;
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.servicios.DTOServicio;
import snix.snixtennis.servicios.ProductoServicio;

/**
 *
 * @author sauma
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductoServicio productoServicio;
    
    @Autowired
    private DTOServicio dtoServicio;
    
     @GetMapping
     @ResponseBody
     public ResponseEntity<?> home(HttpSession session){
         Map<String, Object> response = new HashMap<>();
         try {
         List<Producto> productos = productoServicio.listarProductos();
         List<ProductoDTO> productosDto = productos.stream().map(producto -> dtoServicio.productoToDTO(producto)).collect(Collectors.toList());
            List<Carrito> carro = (List<Carrito>)session.getAttribute("carrito");
         if(carro == null){
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
     @PostMapping("/añadirProductoCarrito/id={id}?cantidad={cantidad}")
     @ResponseBody
     public ResponseEntity<?> añadirProducto(@PathVariable("id") String id,@RequestParam("cantidad") Integer cantidad, HttpSession session){
         Map<String, Object> response = new HashMap<>();
         try {
          List<Carrito> carro = (List<Carrito>) session.getAttribute("carrito");
          Producto pro = productoServicio.listarProductoPorId(id);
          ProductoDTO dto = dtoServicio.productoToDTO(pro);
          List<ProductoDTO> productos = new ArrayList<>(); 
          if(pro.getStock() < cantidad){
              response.put("clase", "error");
              response.put("mensaje", "Cantidad mayor al stock("+pro.getStock()+"), porfavor ingrese un valor menor");
          }
         
          session.setAttribute("carrito", carro);
          
 
          response.put("carrito", carro);
        
          response.put("clase", "success");
          response.put("mensaje", "Producto añadido con exito");
          return ResponseEntity.ok().body(response);
             
         } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
         }
     }
}
