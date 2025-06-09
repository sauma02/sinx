/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snix.snixtennis.entidades.Carrito;
import snix.snixtennis.repositorios.CarritoRepositorio;

/**
 *
 * @author sauma
 */
@Service
public class CarritoServicio {
    
    @Autowired
    private CarritoRepositorio carritoRepositorio;
    
    public Carrito crearCarro(Carrito carro){
        carritoRepositorio.save(carro);
        return carro;
    }
    
}
