package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.model.Estacion;

import java.util.List;

public interface EstacionService {

    List<Estacion> buscarEstaciones();

    Estacion obtenerEstacionById(Long id);

    Estacion crearEstacion(Estacion estacion);

    void eliminarEstacion(Long id);
}
