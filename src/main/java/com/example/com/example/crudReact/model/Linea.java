package com.example.com.example.crudReact.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "linea_mexi")
public class Linea {

    @Id
    @Column(name = "id_linea")
    private Long idLinea;

    @OneToMany(mappedBy = "lineaPadre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Estacion> estaciones;
}
