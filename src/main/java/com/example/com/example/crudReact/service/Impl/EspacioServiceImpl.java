package com.example.com.example.crudReact.service.Impl;


import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.repository.EspacioRepository;
import com.example.com.example.crudReact.service.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioServiceImpl implements EspacioService {

    @Autowired
    EspacioRepository espacioRepository;


    @Override
    public List<Espacio> buscarEspacios() {
        return espacioRepository.findAll();
    }

    @Override
    public Espacio obtenerEspacioById(Long id) {
        return espacioRepository.findById(id).orElse(null);
    }

    @Override
    public Espacio crearEspacio(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    @Override
    public int updateEspacio(Long idEspacio, String nombre, String dimensiones, Double precio, String estado) {
        return espacioRepository.updateEspacioById(idEspacio, nombre, dimensiones, precio, estado);
    }

    @Override
    public void eliminarEspacio(Long idEspacio) {
        espacioRepository.deleteById(idEspacio);
    }
}
