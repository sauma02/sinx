/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;


import jakarta.persistence.Transient;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




/**
 *
 * @author sauma
 */

@NoArgsConstructor
@Getter
@Setter

public class Carrito {
    
    private String id;
    
    private List<ItemCarrito> item;
}
