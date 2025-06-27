/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
    private Integer stock;
    private String categoria;
    private String marca;
    @OneToMany(mappedBy="producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Archivo> imagenes;

    private Double precio;

    public Producto(String id, String nombre, Integer stock, String marca, List<Archivo> imagenes, Double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.marca = marca;
        this.imagenes = imagenes;
        this.precio = precio;
        this.categoria = categoria;
    }
    

   
    
    
}
