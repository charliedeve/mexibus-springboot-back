package com.example.com.example.crudReact.repository;

import com.example.com.example.crudReact.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}