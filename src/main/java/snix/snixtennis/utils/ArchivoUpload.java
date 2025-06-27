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
    
    
    public String guardarArchivo(MultipartFile file, String url) throws Exception{
        if(!ArchivoUpload.verificarMimeType(file.getContentType())){
            return "ErrorMimeType";
        }
        String nombreOriginal = file.getOriginalFilename();
        String extension = ArchivoUpload.obtenerExtension(file.getContentType());
        
        if(nombreOriginal != null && nombreOriginal.endsWith(extension)){
            return "";
        }
        
        nombreOriginal = nombreOriginal.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
        
        String nombre = nombreOriginal + extension.trim();
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
        return switch (mime) {
            case "image/jpeg" -> true;
            case "image/png" -> true;
            case "image/jpg" -> true;
            default -> false;
        };
    }
    
    public static String obtenerExtension(String mime) throws Exception{
        switch (mime) {
            case "image/jpg" -> {
                return ".jpg";
            }
            case "image/jpeg" -> {
                return ".jpeg";
            }
            case "image/png" -> {
                return ".png";
            }
                        
                
            default -> throw new Exception("Error, tipo de archivo no reconocido");
        }
    }
}
