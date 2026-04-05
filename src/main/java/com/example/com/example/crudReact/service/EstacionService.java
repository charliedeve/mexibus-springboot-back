package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;

import java.util.List;
import java.util.Optional;

public interface EstacionService {

    List<EstacionDTO> buscarEstacion(String pBusqueda);

    List<EstacionDTO> buscaEstacionByLinea(Long pLinea, String pBusqueda);

    EstacionDTO obtenerEstacionById(Long id);

    EstacionDTO crearEstacion(Estacion estacion);

    void eliminarEstacion(Long id);
}
