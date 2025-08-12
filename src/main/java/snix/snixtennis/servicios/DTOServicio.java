/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import snix.snixtennis.DTOs.ProductoDTO;
import snix.snixtennis.entidades.Archivo;
import snix.snixtennis.entidades.Producto;

/**
 *
 * @author sauma
 */
@Service
public class DTOServicio {
    
    
    public ProductoDTO dtoGenerico(){
        ProductoDTO prueba = new ProductoDTO();
        prueba.setNombre("Hola");
        prueba.setPrecio(20.00);
        return prueba;
        
    }
    public ProductoDTO productoToDTO(Producto producto){
        if(producto == null){
            return null;
        }
        List<String> urls = new ArrayList<>();
        if(producto.getImagenes() != null){
            for (Archivo imagen : producto.getImagenes()) {
                if(imagen.getRuta() != null || imagen != null  ){
                    urls.add("images/"+producto.getNombre()+ "/" + imagen.getFileName());
                }
            
            }
        }
        
       ProductoDTO dto = new ProductoDTO();
       dto.setId(producto.getId());
       dto.setNombre(producto.getNombre());
       dto.setPrecio(producto.getPrecio());
       dto.setRating(producto.getRating());
       dto.setDetalles(producto.getDetalles());
       dto.setCategoria(producto.getCategoria());
       dto.setImageUrl(urls);
       dto.setMarca(producto.getMarca());
       dto.setColor(producto.getColor());
       dto.setTalla(producto.getTalla());
       
       return dto;
    }
    public List<ProductoDTO> listaDto(List<Producto> productos){
        
            if(  productos == null || productos.isEmpty()){
                return Collections.EMPTY_LIST;
            }
    
            List<ProductoDTO> listaDTOS = new ArrayList<>();
            for (Producto producto : productos) {
                listaDTOS.add(this.productoToDTO(producto));
            }
            return listaDTOS;
          
 
    }
    
    
}
