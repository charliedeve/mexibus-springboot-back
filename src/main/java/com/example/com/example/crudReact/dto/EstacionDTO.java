package com.example.com.example.crudReact.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
public class EstacionDTO implements java.io.Serializable{

    private Long idEstacion;

    @NotEmpty(message = "Nombre de estacion requerido")
    @Size(max = 100, message = "Nombre de estacion excedido (max: 100)")
    private String nombre;

    private Long lineaPadre;

    private List<EspacioDTO> espacios;

    public EstacionDTO(){}

    public EstacionDTO(Long idEstacion, String nombre, Long lineaPadre, List<EspacioDTO> espacios) {
        this.idEstacion = idEstacion;
        this.nombre = nombre;
        this.lineaPadre = lineaPadre;
        this.espacios = espacios;
    }

    public Long getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(Long idEstacion) {
        this.idEstacion = idEstacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getLineaPadre() {
        return lineaPadre;
    }

    public void setLineaPadre(Long lineaPadre) {
        this.lineaPadre = lineaPadre;
    }

    public List<EspacioDTO> getEspacios() {
        return espacios;
    }

    public void setEspacios(List<EspacioDTO> espacios) {
        this.espacios = espacios;
    }
}
