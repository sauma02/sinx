/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import snix.snixtennis.DTOs.ProductoDTO;

/**
 *
 * @author sauma
 */
@NoArgsConstructor
@Getter
@Setter
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private List<ItemCarrito> item;
}
