package cl.duoc.micro_b.service;

import org.springframework.stereotype.Service;
import cl.duoc.micro_b.model.Paciente;
import java.util.List;
import java.util.Optional;


// Lógica del negocio relacionada con lis pacientes, como obtener la lista de pacientes, buscar por ID, etc.

@Service
public interface PacienteService {
    // Métodos para acceder a los pacientes
        List<Paciente> getAllPacientes();

    // Método para obtener un paciente por su ID
        Optional<Paciente> getPacienteById(Long id);

    // Métodos para Crear, Actualizar y Eliminar pacientes
        Paciente createPaciente(Paciente paciente);
        Paciente updatePaciente(Long id, Paciente paciente);
        void deletePaciente(Long id);

}


