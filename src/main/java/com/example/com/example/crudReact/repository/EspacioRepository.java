package com.example.com.example.crudReact.repository;

import com.example.com.example.crudReact.model.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspacioRepository extends JpaRepository<Espacio, Long> {

    List<Espacio> findByEstacionId(Long id);
}
