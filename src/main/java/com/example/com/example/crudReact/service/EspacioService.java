package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.model.Espacio;

import java.util.List;
import java.util.Optional;

public interface EspacioService {

    List<Espacio> buscarEspacios();

    List<Espacio> selectByExampleEstacion(Optional<String> pBusqueda);

    Espacio obtenerEspacioById(Long id);

    Espacio crearEspacio(Espacio espacio);

    Espacio actualizarEspacio(Long id, Espacio espacio);

    void eliminarEspacio(Long id);
}
