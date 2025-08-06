package com.example.com.example.crudReact.repository;

import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.model.Linea;
import com.example.com.example.crudReact.repository.EspacioRepository;
import com.example.com.example.crudReact.repository.EstacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableTransactionManagement
public class EspacioRepositoryTest {

    @Autowired
    private EspacioRepository espacioRepository;

    @Autowired
    private EstacionRepository estacionRepository;

    private Linea linea;

    private Estacion estacion;

    private Espacio espacio;

    @Disabled
    @BeforeEach
    void setup() {
        linea = new Linea(1L);
        estacion = new Estacion();
        estacion.setLineaPadre(linea);
        estacionRepository.save(estacion);
        espacio = Espacio.builder()
                .nombre("Espacio 2")
                .dimensiones("2x2")
                .precio(2000)
                .estado("Disponible")
                .estacion(estacion)
                .build();
    }

    @Disabled
    @DisplayName("Guardar espacio test")
    @Test
    public void guardarEspacioTest() {

        Espacio espacioGuardado = espacioRepository.save(espacio);

        assertThat(espacioGuardado).isNotNull();
        assertThat(espacioGuardado.getIdEspacio()).isGreaterThan(0);
    }

    @Disabled
    @DisplayName("Test para listar espacios")
    @Test
    public void listarEspaciosTest() {
        //given

        //when
        List<Espacio> lstEspacios = espacioRepository.findAll();

        //then
        assertThat(lstEspacios.size()).isNotNull();
        assertThat(lstEspacios.size()).isEqualTo(17);
    }

    @Disabled
    @DisplayName("Obtener espacio por ID")
    @Test
    public void obtenerEspacioByIdTest() {

        espacioRepository.save(espacio);
        Espacio espacioEncontrar = espacioRepository.findById(espacio.getIdEspacio()).get();

        assertThat(espacioEncontrar).isNotNull();

    }

    @Disabled
    @DisplayName("Actualizar un espacio")
    @Test
    public void actualizarEspacioTest() {

        espacioRepository.save(espacio);

        Espacio espacioGuardado = espacioRepository.findById(espacio.getIdEspacio()).get();
        espacioGuardado.setNombre("Espacio testeado");
        espacioGuardado.setDimensiones("Dimension testeada");
        espacioGuardado.setPrecio(8888);
        espacioGuardado.setEstado("Estado testeado");
        Espacio espacioUpdated = espacioRepository.save(espacioGuardado);

        assertThat(espacioUpdated).isNotNull();
        assertThat(espacioUpdated.getNombre()).isEqualTo("Espacio testeado");
        assertThat(espacioUpdated.getDimensiones()).isEqualTo("Dimension testeada");

    }
}