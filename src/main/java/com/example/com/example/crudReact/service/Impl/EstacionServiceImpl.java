package com.example.com.example.crudReact.service.Impl;


import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.repository.EstacionRepository;
import com.example.com.example.crudReact.service.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionServiceImpl implements EstacionService {

    @Autowired
    EstacionRepository estacionRepository;

    public List<Estacion> buscarEstaciones(){
        return estacionRepository.findAll();
    }

    public Estacion obtenerEstacionById(Long id){
        return estacionRepository.findById(id).orElse(null);
    }

    @Override
    public Estacion crearEstacion(Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    @Override
    public void eliminarEstacion(Long id) {
        estacionRepository.deleteById(id);
    }

}
