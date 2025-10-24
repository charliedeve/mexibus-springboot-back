package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.service.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/espacio")
public class EspacioController {

    private final EspacioService espacioService;

    public EspacioController(EspacioService espacioService) {
        this.espacioService = espacioService;
    }

    @GetMapping
    public ResponseEntity<List<Espacio>> buscaEspacio() {
        List<Espacio> espacios = espacioService.buscarEspacios();
        return ResponseEntity.ok(espacios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espacio> obtenerEspacioById(@PathVariable Long id){
        Espacio espacio = espacioService.obtenerEspacioById(id);
        if (espacio != null) {
            return ResponseEntity.ok(espacio);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Espacio> crearEspacio(@RequestBody Espacio espacio){
        return ResponseEntity.ok(espacioService.crearEspacio(espacio));
    }

    @PutMapping("/actualizarEspacio/{pIdEspacio}")
    public ResponseEntity<Espacio> actualizarEspacio(@PathVariable Long idEspacio, @RequestBody Espacio espacio){
        Espacio espacioActualizado = espacioService.updateEspacio(idEspacio, espacio);
        if (espacioActualizado != null) {
            return ResponseEntity.ok(espacioActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{idEspacio}")
    public void eliminarEspacio(@PathVariable Long idEspacio){
        espacioService.eliminarEspacio(idEspacio);
    }
}
