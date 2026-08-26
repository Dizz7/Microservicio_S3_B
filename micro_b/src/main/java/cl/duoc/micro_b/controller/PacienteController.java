package cl.duoc.micro_b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.duoc.micro_b.model.Paciente;
import cl.duoc.micro_b.service.PacienteService;
import java.util.List;

// Controlador para manejar las solicitudes relacionadas con los pacientes

@RestController
@RequestMapping("/pacientes") // Ruta base para las solicitudes de pacientes
public class PacienteController {

     // Inyección de dependencias del servicio de pacientes
    private final PacienteService pacienteService;

     // Constructor para la inyección de dependencias
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Endpoint GET para obtener todos los pacientes
    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.getAllPacientes();
    }

    // Endpoint GET para buscar un paciente por su ID
    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable int id) {
        return pacienteService.getPacienteById(id);
    }
}