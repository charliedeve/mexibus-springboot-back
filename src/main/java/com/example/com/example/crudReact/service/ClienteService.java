package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> obtenerClientes();

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Long id, Cliente cliente);

    void eliminarCliente(Long id);
}
