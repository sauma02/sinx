/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sauma
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Combos {
    @Id
    private String id;
    
    private String id2;
    
    private String productos;
    
    private String precio;
    
    private String url;
    
    private String promo;
    
}
