package com.example.com.example.crudReact.controller;


import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.service.EspacioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/espacio")
public class EspacioController {


    @Autowired
    EspacioService espacioService;

    @GetMapping("/buscaEspacio")
    public ResponseEntity<List<Espacio>> buscaEspacio() {
        List<Espacio> espacios = espacioService.buscarEspacios();
        return ResponseEntity.ok(espacios);
    }

    @GetMapping("/obtenerEspacioById/{id}")
    public ResponseEntity<Espacio> obtenerEspacioById(@PathVariable Long id){
        Espacio espacio = espacioService.obtenerEspacioById(id);
        if (espacio != null) {
            return ResponseEntity.ok(espacio);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/agregarEspacio")
    public ResponseEntity<Espacio> crearEspacio(@RequestBody Espacio espacio){
        return ResponseEntity.ok(espacioService.crearEspacio(espacio));
    }

    @PutMapping("/actualizarEspacio/{pIdEspacio}")
    public ResponseEntity<String> actualizarEspacio(@PathVariable("pIdEspacio") Long idEspacio,
                                                    @RequestBody Map<String, Object> requestBody){

        int affectedRows = espacioService.updateEspacio(idEspacio, (String)requestBody.get("nombre"),
                (String)requestBody.get("dimensiones"), ((Number)requestBody.get("precio")).doubleValue(),
                (String)requestBody.get("estado"));

        if(affectedRows > 0) {
            return ResponseEntity.ok("Espacio actualizado correctamente");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el espacio");

        }

    }

    @DeleteMapping("/eliminarEspacio/{idEspacio}")
    public void eliminarEspacio(@PathVariable Long idEspacio){
        espacioService.eliminarEspacio(idEspacio);
    }
}
