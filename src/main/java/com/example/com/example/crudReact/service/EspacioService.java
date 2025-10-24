package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.model.Espacio;

import java.util.List;

public interface EspacioService {

    List<Espacio> buscarEspacios();

    Espacio obtenerEspacioById(Long id);

    Espacio crearEspacio(Espacio espacio);

    Espacio updateEspacio(Long idEspacio, Espacio espacio);

    void eliminarEspacio(Long idEspacio);
}
