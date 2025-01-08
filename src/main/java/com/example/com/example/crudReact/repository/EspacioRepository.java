package com.example.com.example.crudReact.repository;

import com.example.com.example.crudReact.dto.EspacioDTO;
import com.example.com.example.crudReact.model.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EspacioRepository extends JpaRepository<Espacio, Long> {

    @Query("SELECT new com.example.com.example.crudReact.dto.EspacioDTO(es.idEspacio, es.nombre, es.dimensiones, es.precio, es.estado) " +
            "FROM Espacio es " +
            "WHERE es.estacion.idEstacion = :idEstacion")
    List<EspacioDTO> findEspaciosByEstacionId(@Param("idEstacion") Long idEstacion);

}
