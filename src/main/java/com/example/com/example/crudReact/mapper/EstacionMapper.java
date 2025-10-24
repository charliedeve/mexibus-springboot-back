package com.example.com.example.crudReact.mapper;

import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EstacionMapper {

    private final ModelMapper modelMapper;

    public EstacionMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Estacion toEntity(EstacionDTO estacionDTO){
        return modelMapper.map(estacionDTO, Estacion.class);
    }

    public void toEntity(EstacionDTO estacionDTO, Estacion estacionExistente){
        modelMapper.map(estacionDTO, Estacion.class);
    }

    public EstacionDTO toDTO(Estacion estacion){
        return modelMapper.map(estacion, EstacionDTO.class);
    }
}
