/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.entidades.InformacionCliente;
import snix.snixtennis.entidades.Pedido;
import snix.snixtennis.repositorios.PedidoRepositorio;

/**
 *
 * @author sauma
 */
@Service
public class PedidoServicio {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    
    public Pedido crearPedido(Carrito carrito, InformacionCliente cliente){
        Pedido pedido = new Pedido();
        pedido.setNombre("Pedido: " + cliente.getNombre());
        pedido.setCarro(carrito);
        pedido.setCliente(cliente);
        pedidoRepositorio.save(pedido);
        return pedido;
        
    }
}
