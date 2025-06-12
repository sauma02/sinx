/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombre;
    private Double total;
    private Integer cantidad;
    @ManyToOne
    private InformacionCliente cliente;
    private Carrito carro;

    public Pedido(String id, String nombre, InformacionCliente cliente, Carrito carro, Integer cantidad, Double total) {
        this.id = id;
        this.nombre = nombre;
        this.cliente = cliente;
        this.carro = carro;
        this.cantidad = cantidad;
        this.total = total;
    }
    
    
    
    
}
