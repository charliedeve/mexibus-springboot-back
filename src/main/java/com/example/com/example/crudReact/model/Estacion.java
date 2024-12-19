package com.example.com.example.crudReact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "estacion_mexi")
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacion")
    private Long idEstacion;

    @Column(name = "nom_estacion")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "linea_padre", nullable = false)
    @JsonIgnore
    private Linea lineaPadre;

    @OneToMany(mappedBy = "estacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Espacio> espacios;
}
