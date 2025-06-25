/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.DTOs;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import snix.snixtennis.entidades.Archivo;

/**
 *
 * @author sauma
 */

@Getter
@Setter
public class ProductoDTO {
    private String id;
    private String nombre;
    private String marca;
    private List<Archivo> imageUrl;
    private Double precio;
}
