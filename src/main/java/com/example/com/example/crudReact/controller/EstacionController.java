package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.service.Impl.EstacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estaciones")
public class EstacionController {

    @Autowired
    EstacionServiceImpl estacionServiceImpl;

    @GetMapping
    public List<Estacion> buscarEstaciones(){
        return estacionServiceImpl.buscarEstaciones();
    }

    @PostMapping("/agregarEstacion")
    public Estacion agregarEstacion(Estacion estacion){
        return estacionServiceImpl.crearEstacion(estacion);
    }

    @DeleteMapping("/eliminarEstacion/{id}")
    public void eliminarEstacion(@PathVariable Long id){
        estacionServiceImpl.eliminarEstacion(id);
    }
}
