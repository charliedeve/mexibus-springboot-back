package com.example.com.example.crudReact.dto;

import lombok.Getter;
import lombok.Setter;

public class EspacioDTO {

    @Getter
    @Setter
    private Long idEspacio;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String dimensiones;

    @Getter
    @Setter
    private int precio;

    @Getter
    @Setter
    private String estado;


    public EspacioDTO(){}

    public EspacioDTO(Long idEspacio, String nombre, String dimensiones, int precio, String estado) {
        this.idEspacio = idEspacio;
        this.nombre = nombre;
        this.dimensiones = dimensiones;
        this.precio = precio;
        this.estado = estado;
    }
}
