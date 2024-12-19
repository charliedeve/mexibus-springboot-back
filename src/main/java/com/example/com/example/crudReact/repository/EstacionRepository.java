package com.example.com.example.crudReact.repository;


import com.example.com.example.crudReact.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {


    @Query(value = "SELECT" +
            " estacion_mexi.id_estacion, " +
            " estacion_mexi.nom_estacion, " +
            " estacion_mexi.linea_padre " +
            " FROM estacion_mexi WHERE " +
            " :pBusqueda IS NULL " +
            " OR ( " +
            " LOWER(nom_estacion) LIKE CONCAT('%', LOWER(:pBusqueda), '%')" +
            " OR LOWER(linea_padre) LIKE CONCAT('%', LOWER(:pBusqueda), '%')" +
            " )", nativeQuery = true
            )
    List<Estacion> selectByExample(@Param("pBusqueda") String pBusqueda);
}
