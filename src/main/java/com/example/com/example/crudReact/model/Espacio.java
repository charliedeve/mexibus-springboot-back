package com.example.com.example.crudReact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "espacio_public")
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_espacio")
    private Long id;

    @Basic(optional = false)
    private String dimensiones;

    @Basic(optional = false)
    private int precio;

    @Basic(optional = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "estacion_padre", nullable = false)
    @JsonIgnore
    private Estacion estacion;
}
