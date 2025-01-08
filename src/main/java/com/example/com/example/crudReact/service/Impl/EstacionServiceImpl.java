package com.example.com.example.crudReact.service.Impl;


import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.repository.EstacionRepository;
import com.example.com.example.crudReact.service.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionServiceImpl implements EstacionService {

    @Autowired
    EstacionRepository estacionRepository;

    @Override
    public List<Estacion> buscarEstacion(Optional<String> pBusqueda) {
        return pBusqueda.isPresent() ?
                estacionRepository.selectByExample(String.format("%s%s%s", "%", pBusqueda.get(), "%")):
                estacionRepository.selectByExample(null);
    }

    @Override
    public List<Estacion> buscaEstacionByLinea(Long pLinea, Optional<String> pBusqueda) {
        return pBusqueda.isPresent() ? estacionRepository.selectByLineaPadre
                (pLinea, String.format("%s%s%s", "%", pBusqueda.get(), "%")):
                estacionRepository.selectByLineaPadre(pLinea, null);
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
