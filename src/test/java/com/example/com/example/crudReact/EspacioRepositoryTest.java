package com.example.com.example.crudReact;

import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.model.Linea;
import com.example.com.example.crudReact.repository.EspacioRepository;
import com.example.com.example.crudReact.repository.EstacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EspacioRepositoryTest {

    @Autowired
    private EspacioRepository espacioRepository;

    @Autowired
    private EstacionRepository estacionRepository;

    private Linea linea;

    private Estacion estacion;

    private Espacio espacio2;

    @BeforeEach
    void setup(){
//        linea = new Linea(1L);
//        estacion = new Estacion();
//        estacion.setLineaPadre(linea);
//        estacionRepository.save(estacion);
//         espacio2 = Espacio.builder()
//                 .nombre("Espacio 2")
//                 .dimensiones("2x2")
//                 .precio(2000)
//                 .estado("Disponible")
//                 .estacion(estacion)
//                 .build();
    }

    @DisplayName("Guardar espacio test")
    @Test
    public void guardarEspacioTest(){

        estacion.setLineaPadre(linea);
        estacionRepository.save(estacion);
        Espacio espacio1 = Espacio.builder()
                .nombre("Espacio 1")
                .dimensiones("1x1")
                .precio(1000)
                .estado("Disponible")
                .estacion(estacion)
                .build();
        Espacio espacioGuardado = espacioRepository.save(espacio1);

        System.out.println("NO null -> " +assertThat(espacioGuardado).isNotNull());
        System.out.println("Mayor a cero -> " +assertThat(espacioGuardado.getIdEspacio()).isGreaterThan(0));
    }

    @DisplayName("Test para listar espacios")
    @Test
    public void listarEspaciosTest(){
        //given
        linea = new Linea(1L);
        estacion = new Estacion();
        estacion.setLineaPadre(linea);
//        Espacio espacio3 = Espacio.builder()
//                .nombre("Espacio 3")
//                .dimensiones("3x3")
//                .precio(3000)
//                .estado("Disponible")
//                .estacion(estacion)
//                .build();
//        espacioRepository.save(espacio3);
//        espacioRepository.save(espacio2);

        //when
        List<Estacion> lstEspacios = estacionRepository.findAll();

        //then
        assertThat(lstEspacios.size()).isNotNull();
        assertThat(lstEspacios.size()).isEqualTo(22);
    }
}