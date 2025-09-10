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
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message ="esta vacio")
    private String id;
    @NotEmpty(message ="esta vacio")
    private String nombre;
    @Min(0)
    @Max(1000000000)
    private Integer stock;
    @NotEmpty(message ="esta vacio")
    private String categoria;
    @NotEmpty(message ="esta vacio")
    private String talla;
    @NotEmpty(message ="esta vacio")
    private String detalles;
    @NotEmpty(message ="esta vacio")
    private String color;
    @NotEmpty(message ="esta vacio")
    private String marca;
    @DecimalMin("0.0")
    @DecimalMax("100000000.0")
    private Double rating;

    @OneToMany(mappedBy="producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Archivo> imagenes;
    
    @DecimalMin("0.0")
    @DecimalMax("100000000.0")
    private Double precio;

    public Producto(String id, String nombre,Double rating, Integer stock, String marca, List<Archivo> imagenes, String detalles, Double precio, String categoria, String talla, String color) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.color = color;
        this.talla = talla;
        this.marca = marca;
        this.imagenes = imagenes;
        this.precio = precio;
        this.categoria = categoria;
        this.rating = rating;
        this.detalles = detalles;
    }
    

   
    
    
}
