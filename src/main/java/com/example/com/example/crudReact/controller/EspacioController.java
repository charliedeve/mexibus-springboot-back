package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.service.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacio")
public class EspacioController {

    @Autowired
    EspacioService espacioService;

    @GetMapping("/obtenerEspacio")
    private List<Espacio> obtenerEspacio(){
        return espacioService.buscarEspacios();
    }

    @GetMapping("/obtenerEspacioById/{id}")
    private ResponseEntity<Espacio> obtenerEspacioById(@PathVariable Long id){
        Espacio espacio = espacioService.obtenerEspacioById(id);
        if (espacio != null) {
            return ResponseEntity.ok(espacio);
        }else{
            return ResponseEntity.notFound().build();
        }
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
