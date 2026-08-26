package cl.duoc.micro_b.model;

/**
 * Clase que representa un paciente en el sistema.
 * Sin @Entity ni @Table porque no se está usando base de datos aún.
 */

public class Paciente {

    private int id; // ID del Paciente
    private String nombre; // Nombre del Paciente
    private String rut; // RUT del Paciente
    private String historialMedico; // Historial médico del Paciente
    private String ultimaAtencion; // Fecha de la última atención del Paciente

    // Constructor
    public Paciente(int id, String nombre, String rut, String historialMedico, String ultimaAtencion) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.historialMedico = historialMedico;
        this.ultimaAtencion = ultimaAtencion;
    }

    
    // Getters and Setters
    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public String getUltimaAtencion() {
        return ultimaAtencion;
    }

    public void setUltimaAtencion(String ultimaAtencion) {
        this.ultimaAtencion = ultimaAtencion;
    }

}
