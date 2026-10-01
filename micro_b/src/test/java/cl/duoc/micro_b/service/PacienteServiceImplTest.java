package cl.duoc.micro_b.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.micro_b.model.Paciente;
import cl.duoc.micro_b.repository.PacienteRepository;


@ExtendWith (MockitoExtension.class)

class PacienteServiceImplTest {
    @Mock 
    private PacienteRepository pacienteRepository;

    @InjectMocks 
    private PacienteServiceImpl service;

    private Paciente paciente1;
    private Paciente paciente2;
    

    @BeforeEach 
    void setUp() {
        paciente1 = new Paciente();
        paciente1.setId(1L);
        paciente1.setNombre("Paciente 1");
        paciente1.setRut("12345678-9");
        paciente1.setHistorialMedico("Gastritis aguda");
        paciente1.setUltimaAtencion("Revisión de exámenes de sangre");

        paciente2 = new Paciente();
        paciente2.setId(2L);
        paciente2.setNombre("Paciente 2");
        paciente2.setRut("12345678-9");
        paciente2.setHistorialMedico("Hipertensión");
        paciente2.setUltimaAtencion("Control de presión arterial");


    }

    @Test 
    void testGetAllPacientes() {
        when(pacienteRepository.findAll()).thenReturn(Arrays.asList(paciente1, paciente2));

        List<Paciente> pacientes = service.getAllPacientes();

        assertEquals(2, pacientes.size());
        verify(pacienteRepository, times(1)).findAll();
    }

    @Test 
    void testGetPacienteById() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente1));

        Optional<Paciente> paciente = service.getPacienteById(1L);

        assertTrue(paciente.isPresent());
        assertEquals("Paciente 1", paciente.get().getNombre());
        verify(pacienteRepository, times(1)).findById(1L);
    }

    @Test 
    void testCreatePaciente() {
        when(pacienteRepository.save(paciente1)).thenReturn(paciente1);

        Paciente createdPaciente = service.createPaciente(paciente1);

        assertEquals("Paciente 1", createdPaciente.getNombre());
        verify(pacienteRepository, times(1)).save(paciente1);
    }

    @Test 
    void testUpdatePacienteExists() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente1));   
        when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente1);

        Paciente updatedPaciente = new Paciente();
        updatedPaciente.setNombre("Paterno Actualizado");
        updatedPaciente.setRut("98765432-1");
        updatedPaciente.setHistorialMedico("Gastritis crónica");
        updatedPaciente.setUltimaAtencion("Revisión de exámenes de sangre");

        Paciente result = service.updatePaciente(1L, updatedPaciente);

        assertEquals("Paterno Actualizado", result.getNombre());
        assertEquals("98765432-1", result.getRut());
        assertEquals("Gastritis crónica", result.getHistorialMedico());
        assertEquals("Revisión de exámenes de sangre", result.getUltimaAtencion());
        verify(pacienteRepository, times(1)).findById(1L);
        verify(pacienteRepository, times(1)).save(any(Paciente.class));
    }


    @Test
    void testUpdatePacienteNotExists() {
        Long id = 1L;
        Paciente paciente = new Paciente();

        when(pacienteRepository.findById(id))
            .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> service.updatePaciente(id, paciente)
        );

        assertEquals("ID de Paciente no encontrado: 1", exception.getMessage());


        
    }


    @Test 
    void testDeletePaciente() {
        doNothing().when(pacienteRepository).deleteById(1L);

        service.deletePaciente(1L);

        verify(pacienteRepository, times(1)).deleteById(1L);
    }


    @AfterEach
    void tearDown() {
        paciente1 = null;
        paciente2 = null;
    }


}


