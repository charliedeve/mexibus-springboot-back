package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;

import java.util.List;
import java.util.Optional;

public interface EstacionService {

    List<Estacion> buscarEstacion(Optional<String> pBusqueda);

    List<Estacion> buscaEstacionByLinea(Long pLinea, Optional<String> pBusqueda);

    Estacion obtenerEstacionById(Long id);

    Estacion crearEstacion(Estacion estacion);

    void eliminarEstacion(Long id);
}
