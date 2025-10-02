/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Archivo {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;
   private String fileName;
   private String fileType;
   private String ruta;
   @ManyToOne
   @JoinColumn(name="producto")
   private Producto producto;

    public Archivo(String id, String fileName, String fileType, String ruta, Producto producto) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.ruta = ruta;
        this.producto = producto;
    }
   
   
}
