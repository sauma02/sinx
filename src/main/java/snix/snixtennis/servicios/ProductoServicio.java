/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snix.snixtennis.entidades.Archivo;
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
    @Autowired
    private ArchivoServicio archivoServicio;

    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    public Producto listarProductoPorId(String id) {
        Optional<Producto> res = productoRepositorio.findById(id);
        if (res.isPresent()) {
            Producto producto = res.get();
            return producto;
        } else {
            return null;
        }

    }

    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public Producto editarProducto(Producto producto) {
        Optional<Producto> res = productoRepositorio.findById(producto.getId());
      
        if (res.isPresent()) {
            if (producto.getImagenes() == res.get().getImagenes()) {
                Producto pro = res.get();
                pro.setMarca(producto.getMarca());
                pro.setNombre(producto.getNombre());
                pro.setPrecio(producto.getPrecio());
                pro.setStock(producto.getStock());
                pro.setTalla(producto.getTalla());
                pro.setCategoria(producto.getCategoria());
                pro.setColor(producto.getColor());
                pro.setRating(producto.getRating());
                productoRepositorio.save(pro);
                return pro;
            }
            Producto pro = res.get();
            
            pro.setImagenes(producto.getImagenes());
            pro.setMarca(producto.getMarca());
            pro.setNombre(producto.getNombre());
            pro.setPrecio(producto.getPrecio());
            pro.setStock(producto.getStock());
            pro.setTalla(producto.getTalla());
            pro.setCategoria(producto.getCategoria());
            pro.setColor(producto.getColor());
            pro.setRating(producto.getRating());
            productoRepositorio.save(pro);
            return pro;
        } else {
            return null;
        }
    }

    public void eliminarProducto(Producto pro) {
        productoRepositorio.delete(pro);
    }

}
