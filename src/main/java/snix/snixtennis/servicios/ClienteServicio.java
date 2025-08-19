/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snix.snixtennis.entidades.InformacionCliente;
import snix.snixtennis.repositorios.InformacionClienteRepositorio;

/**
 *
 * @author josed
 */
@Service
public class ClienteServicio {
    @Autowired
    private InformacionClienteRepositorio clienteRepo;
    public InformacionCliente crearCliente(InformacionCliente cliente){
        clienteRepo.save(cliente);
        return cliente;
    }
}
