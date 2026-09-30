package cl.duoc.micro_b.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class PacienteModelTest {


    @Test
    void testGettersAndSetters() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombre("Paciente Prueba");
        paciente.setRut("12345678-9");
        paciente.setHistorialMedico("Gastritis aguda");
        paciente.setUltimaAtencion("Revisión de exámenes de sangre");    
        

        assertEquals(1, paciente.getId());
        assertEquals("Paciente Prueba", paciente.getNombre());
        assertEquals("12345678-9", paciente.getRut());
        assertEquals("Gastritis aguda", paciente.getHistorialMedico());
        assertEquals("Revisión de exámenes de sangre", paciente.getUltimaAtencion());
    }
    
    

}
