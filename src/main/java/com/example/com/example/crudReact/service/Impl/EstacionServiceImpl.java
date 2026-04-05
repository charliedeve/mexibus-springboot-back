package com.example.com.example.crudReact.service.Impl;


import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.exceptions.ResourceNotFoundException;
import com.example.com.example.crudReact.mapper.EstacionMapper;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.repository.EstacionRepository;
import com.example.com.example.crudReact.service.EstacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionServiceImpl implements EstacionService {

    private final EstacionRepository estacionRepository;
    private final EstacionMapper estacionMapper;

    public EstacionServiceImpl(EstacionRepository estacionRepository, EstacionMapper estacionMapper) {
        this.estacionRepository = estacionRepository;
        this.estacionMapper = estacionMapper;
    }

    @Override
    public List<EstacionDTO> buscarEstacion(String pBusqueda) {
        List<Estacion> estaciones = estacionRepository.selectByExample(pBusqueda);

        return estaciones.stream().map(estacionMapper::toDTO).toList();
    }

    @Override
    public List<EstacionDTO> buscaEstacionByLinea(Long pLinea, String pBusqueda) {

        if (pLinea > 4 || pLinea < 1) {
            throw new ResourceNotFoundException("No existe la linea " + pLinea);
        }

        List<Estacion> estaciones = estacionRepository.selectByLineaPadre(pLinea, null);

        return estaciones.stream().map(estacionMapper::toDTO).toList();
    }


    public EstacionDTO obtenerEstacionById(Long id){

        Estacion estacionExistente = estacionRepository.findById(id).orElse(null);

        return estacionMapper.toDTO(estacionExistente);
    }

    @Override
    public EstacionDTO crearEstacion(Estacion estacion) {
        Estacion nuevaEstacion =  estacionRepository.save(estacion);
        return estacionMapper.toDTO(nuevaEstacion);
    }

    @Override
    public void eliminarEstacion(Long id) {
        estacionRepository.deleteById(id);
    }

}
