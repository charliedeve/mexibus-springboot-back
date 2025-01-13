package com.example.com.example.crudReact.repository;

import com.example.com.example.crudReact.dto.EspacioDTO;
import com.example.com.example.crudReact.model.Espacio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EspacioRepository extends JpaRepository<Espacio, Long> {

    @Modifying
    @Transactional
    @Query(
            "UPDATE Espacio e " +
                    "SET e.nombre = :nombre, " +
                    "e.dimensiones = :dimensiones, " +
                    "e.precio = :precio, " +
                    "e.estado = :estado " +
                    "WHERE e.id = :idEspacio"
    )
    int updateEspacioById(@Param("idEspacio") Long idEspacio, @Param("nombre") String nombre,
                          @Param("dimensiones") String dimensiones, @Param("precio") Double precio,
                          @Param("estado") String estado
    );
}
