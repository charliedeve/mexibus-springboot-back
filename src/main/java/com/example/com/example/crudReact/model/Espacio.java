package com.example.com.example.crudReact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "espacio_public")
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

    public Long getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Long idEspacio) {
        this.idEspacio = idEspacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
}
