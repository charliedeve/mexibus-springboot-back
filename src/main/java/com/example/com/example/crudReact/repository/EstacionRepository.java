package com.example.com.example.crudReact.repository;


import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {


    @Query(
//            value = "Select "+
//            " estacion_mexi.id_estacion, " +
//            " estacion_mexi.nom_estacion, " +
//            " estacion_mexi.linea_padre " +
//            " FROM estacion_mexi WHERE " +
//            " :pBusqueda IS NULL " +
//            " OR ( " +
//            " LOWER(nom_estacion) LIKE CONCAT('%', LOWER(:pBusqueda), '%')" +
//            " OR LOWER(linea_padre) LIKE CONCAT('%', LOWER(:pBusqueda), '%')" +
//            " )", nativeQuery = true

//            "SELECT new com.example.com.example.crudReact.dto.EstacionDTO( \" +\n" +
//                    "       \"  e.idEstacion, e.nombre, l.idLinea, \" +\n" +
//                    "       \"  (SELECT new com.example.com.example.crudReact.dto.EspacioDTO(es.idEspacio, es.nombre, es.dimensiones, es.precio, es.estado) \" +\n" +
//                    "       \"   FROM Espacio es WHERE es.estacion.idEstacion = e.idEstacion) \" +\n" +
//                    "       \") \" +\n" +
//                    "       \"FROM Estacion e \" +\n" +
//                    "       \"LEFT JOIN e.lineaPadre l \" +\n" +
//                    "       \"WHERE :pBusqueda IS NULL OR LOWER(e.nombre) LIKE LOWER(CONCAT('%', :pBusqueda, '%'))"

            "SELECT e FROM Estacion e " +
                    " LEFT JOIN FETCH e.espacios esp " +
                    " WHERE :pBusqueda IS NULL OR LOWER(e.nombre) LIKE LOWER(CONCAT('%', :pBusqueda, '%'))"
    )
    List<Estacion> selectByExample(@Param("pBusqueda") String pBusqueda);


    @Query(value = "SELECT " +
            " estacion_mexi.id_estacion, " +
            " estacion_mexi.nom_estacion, " +
            " estacion_mexi.linea_padre " +
            " FROM estacion_mexi" +
            " WHERE estacion_mexi.linea_padre = :pLinea " +
            " AND (" +
            " :pBusqueda IS NULL OR " +
            " LOWER (estacion_mexi.nom_estacion) LIKE CONCAT('%', LOWER(:pBusqueda), '%'))"
            , nativeQuery = true
    )
    List<Estacion> selectByLineaPadre(@Param("pLinea") Long pLinea, @Param("pBusqueda") String pBusqueda);
}
