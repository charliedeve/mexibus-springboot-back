package com.example.com.example.crudReact.service.Impl;

import com.example.com.example.crudReact.model.Cliente;
import com.example.com.example.crudReact.repository.ClienteRepository;
import com.example.com.example.crudReact.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente){
            clienteRepository.findById(id).map(indice -> {
            indice.setNombre_cliente(cliente.getNombre_cliente());
            indice.setTelefono(cliente.getTelefono());
            indice.setCorreo(cliente.getCorreo());

            return clienteRepository.save(indice);
        });
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }



}
