package Models;

import java.time.LocalDate;

public class Jugador {
    // Atributos ---------------------------------------------------------------
    private String nombre;
    private String apellidos;
    private String email;
    private LocalDate fechaNacimiento;
    private String lugarResidencia;
    private String sobrenombre;

    // Constructor -------------------------------------------------------------  
    public Jugador(String nombre, String apellidos, String email, LocalDate fechaNacimiento, String lugarResidencia, String sobrenombre) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarResidencia = lugarResidencia;
        this.sobrenombre = sobrenombre;
    }    
    
    // Getters y setters -------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getSobrenombre() {
        return sobrenombre;
    }

    public void setSobrenombre(String sobrenombre) {
        this.sobrenombre = sobrenombre;
    }

    
    
}
