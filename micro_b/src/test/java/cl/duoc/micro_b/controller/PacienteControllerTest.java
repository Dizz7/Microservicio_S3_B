package cl.duoc.micro_b.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.test.web.servlet.ResultHandler;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import tools.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import cl.duoc.micro_b.model.Paciente;
import cl.duoc.micro_b.service.PacienteService;


@WebMvcTest(PacienteController.class)
class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PacienteService service;

    private Paciente paciente1;

    @BeforeEach 
    void setUp() {
        paciente1 = new Paciente();
        paciente1.setId(1L);
        paciente1.setNombre("Paciente 1");
        paciente1.setRut("12345678-9");
        paciente1.setHistorialMedico("Gastritis aguda");
        paciente1.setUltimaAtencion("Revisión de exámenes de sangre");
    }

    @Test 
    void testGetAllPacientes() throws Exception {
        when(service.getAllPacientes()).thenReturn(Arrays.asList(paciente1));

        mockMvc.perform(get("/pacientes"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(paciente1))));
    }

    @Test 
    void testGetPacienteById() throws Exception {
        when(service.getPacienteById(1L)).thenReturn(Optional.of(paciente1));
        mockMvc.perform(get("/pacientes/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(paciente1)));
    }

    @Test
    void testCreatePaciente() throws Exception {
        when(service.createPaciente(any(Paciente.class)))
                .thenReturn(paciente1);

        mockMvc.perform(post("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paciente1)))
                .andDo(print())
                .andDo(mostrarCausaDelError())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        objectMapper.writeValueAsString(paciente1)));

        verify(service).createPaciente(any(Paciente.class));
    }

    @Test
    void testUpdatePaciente() throws Exception {
        when(service.updatePaciente(eq(1L), any(Paciente.class)))
                .thenReturn(paciente1);

        mockMvc.perform(put("/pacientes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paciente1)))
                .andDo(print())
                .andDo(mostrarCausaDelError())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(paciente1)));
    }

    @Test 
    void testDeletePaciente() throws Exception {
        doNothing().when(service).deletePaciente(1L);

        mockMvc.perform(delete("/pacientes/1"))
                .andExpect(status().isOk());
                verify(service).deletePaciente(1L);
    }


    private ResultHandler mostrarCausaDelError() {
            return result -> {
                Exception exception = result.getResolvedException();

                if (exception != null) {
                    throw new AssertionError(
                            "La petición falló: " + exception.getMessage(),
                            exception
                    );
                }
            };
        }

}


