/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.utils;

import java.io.File;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sauma
 */

public class ArchivoUpload {
    
    
    public static String guardarArchivo(MultipartFile file, String url) throws Exception{
        
        if(!ArchivoUpload.verificarMimeType(file.getContentType())){
            return "no";
        }
        String nombreOriginal = file.getOriginalFilename();
        String extension = ArchivoUpload.obtenerExtension(file.getContentType());
        
        
        
        nombreOriginal = nombreOriginal.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
        
        String nombre = nombreOriginal;
        url = url.trim();
        
        if(!url.endsWith(File.separator)){
            url += File.separator;
        }
        
        File directorio = new File(url);
        
        if(!directorio.exists()){
            directorio.mkdirs();
        }
        
        try {
        File imageFile = new File(url + nombre);   
           
        file.transferTo(imageFile);
        
        return nombre;
        } catch (IOException e) {
        e.getStackTrace();
        throw new Exception("Error: "+e.getMessage());
        }
        
        
    }
    
    
    public static boolean verificarMimeType(String mime) throws Exception{
        boolean retorno = false;

        switch (mime) {
            case "image/jpeg":
                retorno = true;
                break;
            case "image/jpg":
                retorno = true;
                break;
            case "image/png":
                retorno = true;
                break;
            
            default:
                retorno = false;
                break;
        }
        return retorno;
    }
    
    public static String obtenerExtension(String mime) throws Exception{
        String retorno = "";
        switch (mime) {
            case "image/jpeg":
                retorno = ".jpg";
                break;
            case "image/jpg":
                retorno = ".jpg";
                break;
            case "image/png":
                retorno = ".png";
                break;
            
            default:
                retorno = "Error, archivo no admitido";
                break;

        }
        return retorno;
    }
}
