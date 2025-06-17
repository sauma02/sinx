/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

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
public class ItemCarrito {
    private ProductoDTO dto;
    private Integer cantidad;
    private Double subTotal;
}
