package com.example.com.example.crudReact.service.Impl;


import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.repository.EspacioRepository;
import com.example.com.example.crudReact.service.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacioServiceImpl implements EspacioService {



    @Autowired
    EspacioRepository espacioRepository;


    @Override
    public List<Espacio> buscarEspacios() {
        return espacioRepository.findAll();
    }


    @Override
    public List<Espacio> selectByExampleEstacion(Optional<String> pBusqueda) {
        return List.of();
    }

    public Espacio obtenerEspacioById(Long id){
        return espacioRepository.findById(id).orElse(null);
    }

    @Override
    public Espacio crearEspacio(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    @Override
    public Espacio actualizarEspacio(Long id, Espacio espacio) {
        espacioRepository.findById(id).map(indice -> {
            indice.setDimensiones(espacio.getDimensiones());
            indice.setPrecio(espacio.getPrecio());
            indice.setEstado(espacio.getEstado());
            indice.setEstacion(espacio.getEstacion());

            return espacioRepository.save(indice);
        });
        return null;
    }

    @Override
    public void eliminarEspacio(Long id) {
        espacioRepository.deleteById(id);
    }
}
