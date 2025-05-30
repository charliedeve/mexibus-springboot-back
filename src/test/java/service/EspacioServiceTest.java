package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.model.Linea;
import com.example.com.example.crudReact.repository.EspacioRepository;
import com.example.com.example.crudReact.service.Impl.EspacioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EspacioServiceTest {

    @Mock
    private EspacioRepository espacioRepository;

    @InjectMocks
    private EspacioServiceImpl espacioService;

    private Linea linea;

    private Estacion estacion;

    private Espacio espacio;

    @BeforeEach
    public void setup(){
        linea = new Linea(1L);
        estacion = new Estacion();
        estacion.setLineaPadre(linea);
        espacio = Espacio.builder()
                .idEspacio(1L)
                .nombre("Espacio 1")
                .dimensiones("1x1")
                .precio(20000)
                .estado("Available")
                .estacion(estacion)
                .build();
        espacioRepository.save(espacio);
    }

    @DisplayName("Guardar un espacio")
    @Test
    public void guardarEspacioTest() {

        given(espacioRepository.save(espacio)).willReturn(espacio);

        Espacio espacioSaved = espacioService.crearEspacio(espacio);

        assertThat(espacioSaved).isNotNull();
    }

    @DisplayName("Listar espacios")
    @Test
    public void listarEspacios() {

        //given
        given(espacioService.buscarEspacios()).willReturn(List.of(espacio));

        //when
        List<Espacio> lstEspacio = espacioService.buscarEspacios();

        //then
        assertThat(lstEspacio).isNotNull();
        assertThat(lstEspacio.size()).isGreaterThan(0);

    }

    @DisplayName("Obtener espacio by ID")
    @Test
    public void obtenerEspacioById(){
        //given
        given(espacioRepository.findById(espacio.getIdEspacio())).willReturn(Optional.of(espacio));

        //when
        Espacio espacioFound = espacioService.obtenerEspacioById(espacio.getIdEspacio());

        //then
        assertThat(espacioFound).isNotNull();
        assertThat(espacioFound.getIdEspacio()).isGreaterThan(0);
    }

    @DisplayName("Actualizar espacio")
    @Test
    void updateEspacio(){

        given(espacioRepository.updateEspacioById(espacio.getIdEspacio(), "EspacioUpdated", "9x9",
                9999.0, "Unavailable")).willReturn(1);

        int espacioActualizado = espacioService.updateEspacio(espacio.getIdEspacio(), "EspacioUpdated",
                "9x9", 9999.0, "Unavailable");

        assertThat(espacioActualizado).isNotNull();
        assertThat(espacioActualizado).isGreaterThan(0);
    }

    @DisplayName("Test eliminar espacio")
    @Test
    void eliminarEspacio(){

        //given
        long idEspacio = 1L;
        willDoNothing().given(espacioRepository).deleteById(idEspacio);

        //then
        espacioService.eliminarEspacio(idEspacio);

        //when
        verify(espacioRepository, times(1)).deleteById(idEspacio);
    }
}

