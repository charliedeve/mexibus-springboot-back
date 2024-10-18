package com.example.com.example.crudReact.controller;

import com.example.com.example.crudReact.model.Cliente;
import com.example.com.example.crudReact.service.Impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/obtenerCliente")
    public List<Cliente> obtenerClientes(){
        return clienteServiceImpl.obtenerClientes();
    }

    @PostMapping("/agregaCliente")
    public Cliente crearCliente(Cliente cliente){
        return clienteServiceImpl.crearCliente(cliente);
    }

    @PutMapping("/actualizarCliente/{id}")
    public void actualizarCliente(@PathVariable Long id, Cliente cliente){
        clienteServiceImpl.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public void eliminarCliente(Long id){
        clienteServiceImpl.eliminarCliente(id);
    }

    @PostMapping("/saludar")
    public String saludoJwt(){
        return "Hello since jwt";
    }
}
