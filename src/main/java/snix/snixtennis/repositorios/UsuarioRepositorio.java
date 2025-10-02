/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package snix.snixtennis.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import snix.snixtennis.entidades.Usuario;

/**
 *
 * @author sauma
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    
}
