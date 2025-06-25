/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import snix.snixtennis.DTOs.ProductoDTO;
import snix.snixtennis.entidades.Producto;

/**
 *
 * @author sauma
 */
public class DTOServicio {
    
    
    
    public ProductoDTO productoToDTO(Producto producto){
        ProductoDTO dto = new ProductoDTO();
       dto.setId(producto.getId());
       dto.setNombre(producto.getNombre());
       dto.setPrecio(producto.getPrecio());
   
       dto.setImageUrl(producto.getImagenes());
       dto.setMarca(producto.getMarca());
       
       return dto;
    }
    
}
