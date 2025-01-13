package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.model.Espacio;

import java.util.List;

public interface EspacioService {

    List<Espacio> buscarEspacios();

    Espacio obtenerEspacioById(Long id);

    Espacio crearEspacio(Espacio espacio);

    int updateEspacio(Long idEspacio, String nombre, String dimensiones, Double precio, String estado);

    void eliminarEspacio(Long idEspacio);
}
