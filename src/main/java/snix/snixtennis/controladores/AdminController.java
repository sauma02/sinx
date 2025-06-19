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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.servicios.ProductoServicio;

/**
 *
 * @author sauma
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductoServicio productoServicio;
    
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> admin(HttpSession session){
        Map<String, Object> response = new HashMap<>();
        List<Producto> listarProductos = productoServicio.listarProductos();
        try {
         if(listarProductos.isEmpty()){
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
    
   @PostMapping("/admin/registrarProducto")
   @ResponseBody
   public ResponseEntity<?> registrarProducto(@Valid Producto producto){
       Map<String, Object> response = new HashMap<>();
       try {
           return null;
       } catch (Exception e) {
           return null;
       }
   }
}
