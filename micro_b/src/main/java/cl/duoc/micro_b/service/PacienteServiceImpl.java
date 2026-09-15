package cl.duoc.micro_b.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import cl.duoc.micro_b.model.Paciente;
import cl.duoc.micro_b.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
    
        private final PacienteRepository pacienteRepository;

        PacienteServiceImpl(PacienteRepository pacienteRepository) {
                this.pacienteRepository = pacienteRepository;
        }

        @Override
        public List<Paciente> getAllPacientes() {
            return pacienteRepository.findAll();
        }
   
        @Override
        public Optional<Paciente> getPacienteById(Long id) {
            return pacienteRepository.findById(id);
        }
   

        // Lógica del CRUD para crear, actualizar y eliminar pacientes
        @Override
        public Paciente createPaciente(Paciente paciente) {
            return pacienteRepository.save(paciente);
        }

        @Override
        public Paciente updatePaciente(Long id, Paciente paciente) {
            Optional<Paciente> existingPaciente = pacienteRepository.findById(id);
            if (existingPaciente.isPresent()) {
                Paciente updatedPaciente = existingPaciente.get();
                updatedPaciente.setNombre(paciente.getNombre());
                updatedPaciente.setRut(paciente.getRut());
                updatedPaciente.setHistorialMedico(paciente.getHistorialMedico());
                updatedPaciente.setUltimaAtencion(paciente.getUltimaAtencion());

                return pacienteRepository.save(updatedPaciente);
            } else {
                throw new RuntimeException("ID de Paciente no encontrado: " + id);
            }

        }
              
                
        @Override
        public void deletePaciente(Long id) {
             pacienteRepository.deleteById(id);
            }
}







