package controller;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

//@WebMvcTest()
public class EspacioControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EspacioService espacioService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Linea linea;
//
//    private Estacion estacion;
//
//    private Espacio espacio;
//
//    @BeforeEach
//    void setup(){
//        linea = new Linea(1L);
//        estacion = new Estacion();
//        estacion.setLineaPadre(linea);
//        espacio = Espacio.builder()
//                .idEspacio(1L)
//                .nombre("Espacio 1")
//                .dimensiones("1x1")
//                .precio(20000)
//                .estado("Available")
//                .estacion(estacion)
//                .build();
//    }
//
//    @DisplayName("Guardar espacio test")
//    @Test
//    public void guardarEspacioTest() throws Exception {
//
//        //given
//        given(espacioService.crearEspacio(any(Espacio.class))).willAnswer((invocation) ->
//                invocation.getArgument(0));
//
//        //when
//        ResultActions response = mockMvc.perform(post("/mexibus/espacio")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(espacio)));
//
//        //then
//        response.andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.nombre", is(espacio.getNombre())))
//                .andExpect(jsonPath("$.dimensiones", is(espacio.getDimensiones())))
//                .andExpect(jsonPath("$.precio", is(espacio.getPrecio())))
//                .andExpect(jsonPath("$.estado", is(espacio.getEstado())));
//
//    }
}
