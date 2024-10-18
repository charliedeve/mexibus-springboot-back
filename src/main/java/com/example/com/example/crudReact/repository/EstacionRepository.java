package com.example.com.example.crudReact.repository;

import com.example.com.example.crudReact.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {
}
