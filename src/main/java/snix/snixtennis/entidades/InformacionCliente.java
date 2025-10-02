/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
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
    private String id;
    @NotEmpty(message = "esta vacio")
    private String nombre;
    @NotEmpty(message = "esta vacio")
    private String direccion;
    @NotEmpty(message = "esta vacio")
    private String contacto;
    @NotEmpty(message = "esta vacio")
    private String email;
    @NotEmpty(message = "esta vacio")
    private String ciudad;
    @NotEmpty(message = "esta vacio")
    private String depto;
    @NotEmpty(message = "esta vacio")
    private String autorizacion;

    public InformacionCliente(String id, String nombre, String direccion, String contacto, String email, String ciudad, String depto, String autorizacion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.email = email;
        this.ciudad = ciudad;
        this.depto = depto;
        this.autorizacion = autorizacion;
    }

    

    
    
    
}
