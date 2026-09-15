package cl.duoc.micro_b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// Se importó el modelo Paciente para poder usarlo en el repositorio
import cl.duoc.micro_b.model.Paciente;




// Se extiende de JpaRepository para poder usar los métodos de JPA y poder hacer consultas a la base de datos
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}



