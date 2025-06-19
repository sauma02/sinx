/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snix.snixtennis.entidades.Archivo;
import snix.snixtennis.repositorios.ArchivoRepositorio;

/**
 *
 * @author sauma
 */
@Service
public class ArchivoServicio {
    @Autowired
    private ArchivoRepositorio archivoRepositorio;
    
    public Archivo crearArchivo(Archivo archivo){
        return archivoRepositorio.save(archivo);
    }
    
}
