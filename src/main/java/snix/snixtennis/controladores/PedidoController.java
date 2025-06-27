/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.controladores;


import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import snix.snixtennis.DTOs.ProductoDTO;
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.entidades.InformacionCliente;
import snix.snixtennis.entidades.ItemCarrito;
import snix.snixtennis.entidades.Pedido;
import snix.snixtennis.entidades.Producto;

import snix.snixtennis.servicios.PedidoServicio;

/**
 *
 * @author sauma
 */
@RestController
@CrossOrigin
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoServicio pedidoServicio;
   
    @GetMapping("/hacerPedido/{carrito}")
    @ResponseBody
    public ResponseEntity<?> pedidoInfo(@PathVariable("carrito") Carrito carrito, HttpSession session){
        Map<String, Object> response = new HashMap<>();
        try {
        session.setAttribute("carrito", carrito);
        response.put("carrito", carrito);
        return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: "+e.getMessage());
        }
    }
    
    @PostMapping("/hacerPedido")
    @ResponseBody
    public ResponseEntity<?> hacerPedido(@Valid InformacionCliente cliente, HttpSession session){
        Map<String, Object> response = new HashMap<>();
        try {
            List<ItemCarrito> carrito = (List<ItemCarrito>)session.getAttribute("carrito");
            if(carrito == null || carrito.isEmpty()){
                response.put("clase", "error");
                response.put("mensaje", "El carrito esta vacio");
                return ResponseEntity.badRequest().body(response);
            }
            if(cliente == null || cliente.getNombre() == null|| cliente.getEmail()==null|| cliente.getDireccion()==null || cliente.getContacto() == null){
                response.put("clase", "error");
                response.put("mensaje", "Porfavor complete todos los campos de informacion");
                return ResponseEntity.badRequest().body(response);
            }
            Pedido pedido = pedidoServicio.crearPedido(carrito, cliente);
            response.put("mensaje", "Exito al crear Pedido");
            response.put("pedido", pedido.getId());
            response.put("clase", "success");
            StringBuilder sb = new StringBuilder();
            sb.append("Pedido: ").append(pedido.getId()).append("\n");
            sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
            
            sb.append("Precio total: ").append(pedido.getTotal().toString()).append("\n");
            
            
            for(ItemCarrito p : carrito){
                sb.append("Producto: ").append(p.getDto().getNombre()).append("\n");
                sb.append("Precio Unitario: ").append(p.getDto().getPrecio()).append("\n");
                sb.append("Cantidad producto unitario: ").append(p.getCantidad()).append("\n");
                
            }
            String numero = "3242780208";
            String mensajeCodificado = URLEncoder.encode(sb.toString(), StandardCharsets.UTF_8);
            String url  = "https://wa.me/+57"+numero+"?text="+mensajeCodificado;
            response.put("whatsapp", mensajeCodificado);
            return ResponseEntity.ok().body(response);
            
            
            
        } catch (Exception e) {
            response.put("Error: ", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            
        }
    }
    
    
    
    
}
