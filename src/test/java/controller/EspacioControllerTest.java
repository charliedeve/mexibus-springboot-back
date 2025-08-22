package controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.example.com.example.crudReact.CrudSpringbootApplication;
import com.example.com.example.crudReact.controller.EspacioController;
import com.example.com.example.crudReact.model.Espacio;
import com.example.com.example.crudReact.model.Estacion;
import com.example.com.example.crudReact.model.Linea;
import com.example.com.example.crudReact.service.EspacioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

//feature/addtest2
public class EspacioControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
    private EspacioService espacioService;
    private EspacioController espacioController;

    @BeforeEach
    void setUp() {
        espacioService = mock(EspacioService.class); // creas el mock
        espacioController = new EspacioController(); // instancia real del controlador

        // inyectas manualmente el mock (ya que usas @Autowired en tu controlador)
        espacioController.espacioService = espacioService;
    }

    @Test
    @DisplayName("Debe crear un nuevo espacio")
    void testCrearEspacio() {
        Espacio nuevo = new Espacio(1L, "Nuevo Espacio", "5x5", 30000, "Disponible", null);

        when(espacioService.crearEspacio(any(Espacio.class))).thenReturn(nuevo);

        ResponseEntity<Espacio> response = espacioController.crearEspacio(nuevo);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(nuevo);
        verify(espacioService).crearEspacio(nuevo);
    }
}
//prueba de merge jenkins
// Prueba anadir pruebas unitarias Jenkins