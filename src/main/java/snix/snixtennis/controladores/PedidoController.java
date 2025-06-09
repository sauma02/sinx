/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.controladores;


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
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.entidades.InformacionCliente;
import snix.snixtennis.entidades.Pedido;
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
    public String pedidoInfo(@PathVariable("carrito") Carrito carrito, Model model){
        
        model.addAttribute("carrito", carrito);
        
        return "hacerPedido";
        
    }
    @PostMapping("/hacerPedido")
    @ResponseBody
    public ResponseEntity<Map<String, String>> hacerPedido(@Valid Carrito carro,@Valid InformacionCliente cliente){
        Map<String, String> response = new HashMap<>();
        try {
            Pedido pedido = pedidoServicio.crearPedido(carro, cliente);
            response.put("mensaje", "Exito al crear Pedido");
            response.put("pedido", pedido.getId());
            response.put("clase", "success");
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
