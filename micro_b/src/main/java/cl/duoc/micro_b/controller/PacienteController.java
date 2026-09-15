package cl.duoc.micro_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.micro_b.model.Paciente;
import cl.duoc.micro_b.service.PacienteService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



// Controlador para manejar las solicitudes relacionadas con los pacientes


@RestController
@RequestMapping ("/pacientes")
public class PacienteController {



    @Autowired
    // Inyección de dependencias del servicio de pacientes
    private PacienteService pacienteService;
 
    // Constructor para la inyección de dependencias
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    // Endpoint GET para obtener todos los pacientes
    @GetMapping({"", "/"})
    public List<Paciente> getPacientes() {
        return pacienteService.getAllPacientes();
    }

    // Endpoint GET para buscar un paciente por su ID
    @GetMapping("/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    // Controlador para crear, actualizar y eliminar pacientes
    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }
    
    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.updatePaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }

}
    

    
