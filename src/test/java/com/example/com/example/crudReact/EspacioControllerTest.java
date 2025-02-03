package com.example.com.example.crudReact;

import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.repository.EspacioRepository;
import com.example.com.example.crudReact.service.EspacioService;
import com.example.com.example.crudReact.service.Impl.EspacioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EspacioControllerTest {

    @Mock
    private EspacioRepository espacioRepository;

    @InjectMocks
    private EspacioServiceImpl espacioServiceImpl;


    @Test
    void obtenerEspacioByIdTest(){

        Espacio espacioMock = new Espacio(1L, "Espacio 2", "1x1", 1000, "Disponible", new Estacion());

        when(espacioRepository.findById(1L)).thenReturn(Optional.of(espacioMock));

        Espacio resultado = espacioServiceImpl.obtenerEspacioById(1L);

        assertNotNull(resultado);
        assertEquals("Espacio 1", resultado.getNombre());
    }
}
