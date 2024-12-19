package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

public interface EstacionService {

    List<Estacion> buscarEstacion(Optional<String> pBusqueda);

    Estacion obtenerEstacionById(Long id);

    Estacion crearEstacion(Estacion estacion);

    void eliminarEstacion(Long id);
}
