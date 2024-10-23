package com.example.com.example.crudReact.model;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre_cliente;

    @Basic(optional = false)
    private int telefono;

    @Basic(optional = false)
    private String correo;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "domicilio", columnDefinition = "json")
    private JsonNode domicilio;

}
