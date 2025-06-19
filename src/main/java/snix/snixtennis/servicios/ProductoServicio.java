/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.repositorios.ProductoRepositorio;

/**
 *
 * @author sauma
 */
@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }
    public Producto listarProductoPorId(String id){
        Optional<Producto> res = productoRepositorio.findById(id);
        if(res.isPresent()){
            Producto producto = res.get();
            return producto;
        }else{
            return null;
        }
        
    }
    public Producto crearProducto(Producto producto){
           return productoRepositorio.save(producto);
    }
    

    
}
