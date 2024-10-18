package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.service.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EspacioController {

    @Autowired
    EspacioService espacioService;

    @GetMapping
    public List<Espacio> obtenerEspacios(){
        return espacioService.buscarEspacios();
    }

    @PostMapping("/agregarEspacio")
    public Espacio crearEspacio(Espacio espacio){
        return espacioService.crearEspacio(espacio);
    }

    @PutMapping("/actualizarEspacio/{id}")
    public Espacio actualizarEspacio(Long id, Espacio espacio){
        return espacioService.actualizarEspacio(id, espacio);
    }

    @DeleteMapping("/eliminarEspacio/{id}")
    public void eliminarEspacio(Long id){
        espacioService.eliminarEspacio(id);
    }
}
