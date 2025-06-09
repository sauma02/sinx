/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package snix.snixtennis.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import snix.snixtennis.entidades.Pedido;

/**
 *
 * @author sauma
 */
@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, String> {
    
}
