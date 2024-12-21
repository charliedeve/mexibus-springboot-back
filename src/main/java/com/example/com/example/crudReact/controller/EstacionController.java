package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
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
    EstacionServiceImpl estacionServiceImpl;

    @GetMapping("/buscaEstacion/{pBusqueda}")
    public ResponseEntity<List<Estacion>> buscarEstacion(@PathVariable String pBusqueda){
        List<Estacion> lstEstacion = estacionServiceImpl.buscarEstacion(Optional.ofNullable(StringUtils.isEmpty(pBusqueda.trim()) ? null:pBusqueda));
        return ResponseEntity.ok(lstEstacion);
    }

    @GetMapping("/buscaEstacionByLinea/{pLinea}/{pBusqueda}")
    public ResponseEntity<List<Estacion>> buscaEstacionLinea(@PathVariable Long pLinea, @PathVariable String pBusqueda){
        List<Estacion> lstEstacion = estacionServiceImpl.buscaEstacionByLinea(pLinea, Optional.ofNullable(StringUtils.isEmpty(pBusqueda.trim()) ? null:pBusqueda));
        return ResponseEntity.ok(lstEstacion);
    }


    @GetMapping("/obtenerEstacionById/{id}")
    public Estacion obtenerEstacionById(Long id){
        return estacionServiceImpl.obtenerEstacionById(id);
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
