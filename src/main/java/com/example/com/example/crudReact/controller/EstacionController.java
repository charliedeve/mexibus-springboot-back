package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.dto.EstacionDTO;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.service.EstacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estacion")
public class EstacionController {

    private final EstacionService estacionService;

    public EstacionController(EstacionService estacionService){
        this.estacionService = estacionService;
    }

    @Operation(summary = "Buscar estaciones por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estaciones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron estaciones")
    })
    @GetMapping("/{pBusqueda}")
    public ResponseEntity<List<EstacionDTO>> buscarEstacion(@PathVariable String pBusqueda){
        List<EstacionDTO> lstEstacion = estacionService.buscarEstacion(Optional.ofNullable(pBusqueda.trim().isEmpty() ? null:pBusqueda));
        return ResponseEntity.ok(lstEstacion);
    }

    @Operation(summary = "Buscar estaciones por linea y nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estaciones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron estaciones")
    })
    @GetMapping("/{pLinea}/{pBusqueda}")
    public ResponseEntity<List<EstacionDTO>> buscaEstacionLinea(@PathVariable Long pLinea, @PathVariable String pBusqueda){
        List<EstacionDTO> lstEstacion = estacionService.buscaEstacionByLinea(pLinea, Optional.ofNullable(pBusqueda.trim().isEmpty() ? null:pBusqueda));
        return ResponseEntity.ok(lstEstacion);
    }

    @Operation(summary = "Agregar una nueva estación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estación creada"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity<Estacion> agregarEstacion(@RequestBody Estacion estacion){
        return ResponseEntity.status(HttpStatus.CREATED).body(estacion);
    }

    @Operation(summary = "Eliminar una estación existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estación eliminada"),
            @ApiResponse(responseCode = "404", description = "No se encontró la estación"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstacion(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
