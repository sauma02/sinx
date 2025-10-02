/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import snix.snixtennis.entidades.Archivo;
import snix.snixtennis.entidades.Producto;
import snix.snixtennis.repositorios.ArchivoRepositorio;
import snix.snixtennis.utils.ArchivoUpload;

/**
 *
 * @author sauma
 */
@Service
public class ArchivoServicio {
   
    private ArchivoUpload uploader;
    @Autowired
    private ArchivoRepositorio archivoRepositorio;
    
    public Archivo crearArchivo(Archivo archivo) throws Exception{
        
       return archivoRepositorio.save(archivo);
        
        
    }
    public void eliminarArchivos(List<Archivo> lista){
        archivoRepositorio.deleteAll(lista);
    }
    public void eliminarArchivo(Archivo archvio){
        archivoRepositorio.delete(archvio);
    }
    
    
    
}
