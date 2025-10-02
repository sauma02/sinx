/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.entidades.InformacionCliente;
import snix.snixtennis.entidades.ItemCarrito;
import snix.snixtennis.entidades.Pedido;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.repositorios.PedidoRepositorio;

/**
 *
 * @author sauma
 */
@Service
public class PedidoServicio {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    
    public Pedido crearPedido(List<ItemCarrito> carrito, InformacionCliente cliente){
        Pedido pedido = new Pedido();
        pedido.setNombre("Pedido: " + cliente.getNombre());
      
        pedido.setCliente(cliente);
        Double suma = 0.0;
        for(Integer i = 0; i< carrito.size(); i++){
            ItemCarrito item= carrito.get(i);
            suma += item.getSubTotal();
            
        }
        pedido.setTotal(suma);
        pedidoRepositorio.save(pedido);
        
        return pedido;
        
    }
    public Pedido crearPedidoUnItem(Producto pro, InformacionCliente cliente){
        Pedido pedido = new Pedido();
        pedido.setNombre(cliente.getNombre());
        
        pedido.setCliente(cliente);
        pedido.setTotal(pro.getPrecio());
        pedidoRepositorio.save(pedido);
        return pedido;
    }
    public List<Pedido> listarPedidos(){
        return pedidoRepositorio.findAll();
    }
}
