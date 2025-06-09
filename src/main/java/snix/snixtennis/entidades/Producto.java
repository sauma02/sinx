/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sauma
 */
@Entity
@NoArgsConstructor
@Getter
@Setter

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombre;
    private String imageUrl;
    private Double precio;
    @ManyToMany
    private List<Pedido> pedidos;

    public Producto(String id, String nombre, String imageUrl, Double precio, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.imageUrl = imageUrl;
        this.precio = precio;
        this.pedidos = pedidos;
    }
    
    
}
