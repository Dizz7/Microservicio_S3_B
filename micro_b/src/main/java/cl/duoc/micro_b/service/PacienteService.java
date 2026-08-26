package cl.duoc.micro_b.service;

import org.springframework.stereotype.Service;
import cl.duoc.micro_b.model.Paciente;
import java.util.ArrayList;
import java.util.List;

// Lógica del negocio relacionada con los pacientes

@Service
public class PacienteService {
    
    private List<Paciente> pacientes = new ArrayList<>();

    public PacienteService() {
        // Se agregan pacientes de ejemplo al servicio
        pacientes.add(new Paciente(1, "Juan Pérez", "12.345.678-9", "Hipertensión crónica", "Control general de presión"));
        pacientes.add(new Paciente(2, "María Gómez", "13.456.789-K", "Asma alérgica", "Crisis obstructiva leve"));
        pacientes.add(new Paciente(3, "Carlos Soto", "14.567.890-1", "Sano / Sin antecedentes", "Certificado médico laboral"));
        pacientes.add(new Paciente(4, "Ana Torres", "15.678.901-2", "Diabetes Tipo 2", "Ajuste de dosis de insulina"));
        pacientes.add(new Paciente(5, "Pedro Rojas", "16.789.012-3", "Artritis reumatoide", "Revisión de exámenes de sangre"));
        pacientes.add(new Paciente(6, "Sofía Valdés", "17.890.123-4", "Migraña crónica", "Receta retenida para tratamiento"));
        pacientes.add(new Paciente(7, "Luis Morales", "18.901.234-5", "Gastritis aguda", "Endoscopia de control"));
        pacientes.add(new Paciente(8, "Carmen Riquelme", "19.012.345-6", "Sana", "Examen preventivo de medicina (EMP)"));
    }

    // Métodos para acceder a los pacientes
    public List<Paciente> getAllPacientes() {
        return pacientes;
    }

    // Método para obtener un paciente por su ID
    public Paciente getPacienteById(int id) {
        return pacientes.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}