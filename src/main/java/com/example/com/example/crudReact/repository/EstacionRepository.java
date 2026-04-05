package com.example.com.example.crudReact.repository;


import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {


    @Query("SELECT e FROM Estacion e " +
                    " LEFT JOIN FETCH e.espacios " +
                    " LEFT JOIN FETCH e.lineaPadre " +
                    " WHERE :pBusqueda IS NULL OR LOWER(e.nombre) LIKE LOWER(CONCAT('%', :pBusqueda, '%'))"
    )
    List<Estacion> selectByExample(@Param("pBusqueda") String pBusqueda);

    @Query("SELECT e FROM Estacion e " +
                    " LEFT JOIN FETCH e.espacios " +
                    " LEFT JOIN FETCH e.lineaPadre l " +
                    " WHERE l.idLinea = :pLinea AND (:pBusqueda IS NULL OR LOWER(e.nombre) LIKE LOWER(CONCAT('%', :pBusqueda, '%')))"
    )
    List<Estacion> selectByLineaPadre(@Param("pLinea") Long pLinea, @Param("pBusqueda") String pBusqueda);
}
