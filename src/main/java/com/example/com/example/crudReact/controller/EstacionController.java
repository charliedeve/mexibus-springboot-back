package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.service.EstacionService;
import com.example.com.example.crudReact.service.Impl.EstacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estacion")
public class EstacionController {


    @Autowired
    EstacionService estacionService;

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola desde Jenkins";
    }

    @GetMapping("/saludo2")
    public String saludo2(){
        return "Hola desde Jenkins"; // Este es un cambio de prueba para ver si Jenkins lo detecta
        // Este es un cambio de prueba para ver si Jenkins lo detecta
    }

    @GetMapping("/buscaEstacion/{pBusqueda}")
    public ResponseEntity<List<Estacion>> buscarEstacion(@PathVariable String pBusqueda){
        List<Estacion> lstEstacion = estacionService.buscarEstacion(Optional.ofNullable(StringUtils.isEmpty(pBusqueda.trim()) ? null:pBusqueda));
        return ResponseEntity.ok(lstEstacion);
    }

    @GetMapping("/buscaEstacionByLinea/{pLinea}/{pBusqueda}")
    public ResponseEntity<List<Estacion>> buscaEstacionLinea(@PathVariable Long pLinea, @PathVariable String pBusqueda){
        List<Estacion> lstEstacion = estacionService.buscaEstacionByLinea(pLinea, Optional.ofNullable(StringUtils.isEmpty(pBusqueda.trim()) ? null:pBusqueda));
        return ResponseEntity.ok(lstEstacion);
    }


    @GetMapping("/obtenerEstacionById/{id}")
    public ResponseEntity<Estacion> obtenerEstacionById(@PathVariable Long id){
        return ResponseEntity.ok(estacionService.obtenerEstacionById(id));
    }

    @PostMapping("/agregarEstacion")
    public ResponseEntity<Estacion> agregarEstacion(@RequestBody Estacion estacion){
        return ResponseEntity.ok(estacionService.crearEstacion(estacion));
    }

    @DeleteMapping("/eliminarEstacion/{id}")
    public void eliminarEstacion(@PathVariable Long id){
        estacionService.eliminarEstacion(id);
    }
}
