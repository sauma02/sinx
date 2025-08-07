/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import snix.snixtennis.DTOs.ProductoDTO;
import snix.snixtennis.entidades.Producto;

/**
 *
 * @author sauma
 */
@Service
public class DTOServicio {
    
    
    
    public ProductoDTO productoToDTO(Producto producto){
        ProductoDTO dto = new ProductoDTO();
       dto.setId(producto.getId());
       dto.setNombre(producto.getNombre());
       dto.setPrecio(producto.getPrecio());
       dto.setRating(producto.getRating());
       dto.setCategoria(producto.getCategoria());
       dto.setImageUrl(producto.getImagenes());
       dto.setMarca(producto.getMarca());
       
       return dto;
    }
    public List<ProductoDTO> listaDto(List<Producto> productos){
        
        
        try {
            List<ProductoDTO> listaDTOS = new ArrayList<>();
            for (Producto producto : productos) {
                ProductoDTO pro = this.productoToDTO(producto);
                listaDTOS.add(pro);
                
            }
            return listaDTOS;
        } catch (Exception e) {
            return null;
        }
 
    }
    
    
}
