/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.controladores;


import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import snix.snixtennis.DTOs.ProductoDTO;
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.entidades.InformacionCliente;
import snix.snixtennis.entidades.Pedido;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.servicios.CarritoServicio;
import snix.snixtennis.servicios.PedidoServicio;

/**
 *
 * @author sauma
 */
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoServicio pedidoServicio;
    @Autowired
    private CarritoServicio carroServicio;
    @GetMapping("/hacerPedido/{carrito}")
    public String pedidoInfo(@PathVariable("carrito") Carrito carrito, Model model, HttpSession session){
        
        model.addAttribute("carrito", carrito);
        
        return "hacerPedido";
        
    }
    @GetMapping("/hacerPedido")
    @ResponseBody
    public ResponseEntity<Map<?, ?>> hacerPedido(@Valid InformacionCliente cliente, HttpSession session){
        Map<String, String> response = new HashMap<>();
        try {
            Carrito carro = (Carrito) session.getAttribute("carrito");
            if(carro == null || carro.getProductos().isEmpty()){
                response.put("mensaje", "El carrito esta vacio");
                return ResponseEntity.badRequest().body(response);
            }
            if(cliente == null || cliente.getNombre() == null|| cliente.getEmail()==null|| cliente.getDireccion()==null || cliente.getContacto() == null){
                response.put("mensaje", "Porfavor complete todos los campos de informacion");
                return ResponseEntity.badRequest().body(response);
            }
            Pedido pedido = pedidoServicio.crearPedido(carro, cliente);
            response.put("mensaje", "Exito al crear Pedido");
            response.put("pedido", pedido.getId());
            response.put("clase", "success");
            StringBuilder sb = new StringBuilder();
            sb.append("Pedido: ").append(pedido.getId()).append("\n");
            sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
            sb.append("Cantidad: ").append(pedido.getCantidad()).append("\n");
            sb.append("Precio total: ").append(pedido.getTotal().toString()).append("\n");
            
            
            for(ProductoDTO p : carro.getProductos()){
                sb.append("Producto: ").append(p.getNombre()).append("\n");
                sb.append("Precio Unitario: ").append(p.getPrecio()).append("\n");
                
            }
            String numero = "3242780208";
            String mensajeCodificado = URLEncoder.encode(sb.toString(), StandardCharsets.UTF_8);
            String url  = "https://wa.me/+57"+numero+"?text="+mensajeCodificado;
            response.put("whatsapp", mensajeCodificado);
            return ResponseEntity.ok().body(response);
            
            
            
        } catch (Exception e) {
            response.put("Error: ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
            
        }
    }
    @PostMapping("/carrito/procederPedido")
    public String cerrarCarrito(@Valid Carrito carro, Model model){
        
        try {
           carroServicio.crearCarro(carro);
           return "redirect:/hacerPedido/"+carro;
        } catch (Exception e) {
            System.err.println("Error: "+  e.getMessage());
            return "redirect:/";
        
        }
        
    }
    
    
}
