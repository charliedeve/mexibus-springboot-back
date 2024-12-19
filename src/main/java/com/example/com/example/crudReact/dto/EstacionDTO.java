package com.example.com.example.crudReact.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;



public class EstacionDTO {

    private Long idEstacion;

    @NotEmpty(message = "Nombre de estacion requerido")
    @Size(max = 100, message = "Nombre de estacion excedido (max: 100)")
    private String nombre;

    private String lineaPadre;


    public EstacionDTO(){}

    public EstacionDTO(Long idEstacion, String nombre, String lineaPadre){
        this.idEstacion = idEstacion;
        this.nombre = nombre;
        this.lineaPadre = lineaPadre;
    }

    public Long getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(Long idEstacion) {
        this.idEstacion = idEstacion;
    }

    public @NotEmpty(message = "Nombre de estacion requerido") @Size(max = 100, message = "Nombre de estacion excedido (max: 100)") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty(message = "Nombre de estacion requerido") @Size(max = 100, message = "Nombre de estacion excedido (max: 100)") String nombre) {
        this.nombre = nombre;
    }

    public String getLineaPadre() {
        return lineaPadre;
    }

    public void setLineaPadre(String lineaPadre) {
        this.lineaPadre = lineaPadre;
    }

}
