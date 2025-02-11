package com.example.com.example.crudReact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Table(name = "espacio_public")
@Builder
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_espacio")
    private Long idEspacio;

    @Basic(optional = false)
    private String nombre;

    @Basic(optional = false)
    private String dimensiones;

    @Basic(optional = false)
    private int precio;

    @Basic(optional = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "estacion_padre", nullable = false)
    @JsonBackReference
    private Estacion estacion;

    public Espacio(){}

    public Espacio(Long idEspacio, String nombre, String dimensiones, int precio, String estado, Estacion estacion) {
        this.idEspacio = idEspacio;
        this.nombre = nombre;
        this.dimensiones = dimensiones;
        this.precio = precio;
        this.estado = estado;
        this.estacion = estacion;
    }

    public String toString(){
        return "idEspacio: " +idEspacio+ " Nombre: " +nombre+ " Dimensiones: " +dimensiones+ " Precio: " +precio+ " Estado: " +estado;
    }
}
