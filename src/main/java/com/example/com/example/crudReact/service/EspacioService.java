package com.example.com.example.crudReact.service;

import com.example.com.example.crudReact.model.Espacio;

import java.util.List;

public interface EspacioService {

    List<Espacio> buscarEspacios();

    Espacio crearEspacio(Espacio espacio);

    Espacio actualizarEspacio(Long id, Espacio espacio);

    void eliminarEspacio(Long id);
}
