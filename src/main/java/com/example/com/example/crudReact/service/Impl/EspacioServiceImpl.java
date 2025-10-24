package com.example.com.example.crudReact.service.Impl;


import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.repository.EspacioRepository;
import com.example.com.example.crudReact.service.EspacioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioServiceImpl implements EspacioService {

    private final EspacioRepository espacioRepository;

    public EspacioServiceImpl(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

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
    public Espacio updateEspacio(Long idEspacio, Espacio espacio) {
        Espacio espacioExistente = espacioRepository.findById(idEspacio).orElse(null);
        espacioExistente.setNombre(espacio.getNombre());
        espacioExistente.setDimensiones(espacio.getDimensiones());
        espacioExistente.setPrecio(espacio.getPrecio());
        espacioExistente.setEstado(espacio.getEstado());

        return espacioRepository.save(espacioExistente);
    }

    @Override
    public void eliminarEspacio(Long idEspacio) {
        espacioRepository.deleteById(idEspacio);
    }
}
