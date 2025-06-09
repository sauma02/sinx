/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class InformacionCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    
    private String nombre;
    private String direccion;
    private String contacto;
    private String email;
    private String autorizacion;

    public InformacionCliente(String nombre, String direccion, String contacto, String email, String autorizacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.email = email;
        this.autorizacion = autorizacion;
    }

    
    
    
}
