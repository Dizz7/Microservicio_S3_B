package cl.duoc.micro_b.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
@Table(name = "paciente")
public class Paciente {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "rut")
    private String rut;
    @Column(name = "historialMedico")
    private String historialMedico;
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
