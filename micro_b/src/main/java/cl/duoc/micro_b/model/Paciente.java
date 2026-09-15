package cl.duoc.micro_b.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "paciente")
public class Paciente {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    //Validaciones de los campos de la tabla paciente


    @NotBlank(message = "El nombre del paciente no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre del paciente debe tener entre 3 y 100 caracteres")
    @Pattern(regexp = "^[\\p{L}]+(?: [\\p{L}]+)*$", message = "El nombre del paciente solo puede contener letras y espacios entre palabras")
    @Column(name = "nombre")
    private String nombre;
    
    // RUT
    @NotBlank(message = "El RUT no puede estar vacío")
    @Pattern( regexp = "^(?:[0-9]{7,8}|[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3})-[0-9kK]$",
    message = "El RUT debe tener formato 12.345.678-5 o 12345678-5")
    
    @Column(name = "rut")
    private String rut;


    // Historial médico
    @Size(max = 2000,
      message = "El historial médico no puede superar los 2000 caracteres")
    @Column(name = "historialMedico")
    
    private String historialMedico;


    // Última atención
    @Size(max = 2000,
      message = "la última atención no puede superar los 2000 caracteres")
    @Column(name = "ultimaAtencion")
    private String ultimaAtencion;




    // Constructor vacío requerido por JPA
    public Paciente() {
    }



    // Constructor
    public Paciente(Long id, String nombre, String rut, String historialMedico, String ultimaAtencion) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.historialMedico = historialMedico;
        this.ultimaAtencion = ultimaAtencion;
    }


    // Getters y Setters
    
    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}

    public String getNombre() { return nombre;}
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRut() { return rut;}
    public void setRut(String rut) { this.rut = rut;}

    public String getHistorialMedico() { return historialMedico;}
    public void setHistorialMedico(String historialMedico) { this.historialMedico = historialMedico;}

    public String getUltimaAtencion() { return ultimaAtencion;}
    public void setUltimaAtencion(String ultimaAtencion) { this.ultimaAtencion = ultimaAtencion;}




}
