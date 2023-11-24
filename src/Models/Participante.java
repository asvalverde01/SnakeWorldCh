package Models;

import java.time.LocalDate;

public class Participante {

    // Atributos ---------------------------------------------------------------
    private String nombre;
    private String apellidos;
    private String cedula;
    private String email;
    private LocalDate fechaNacimiento;
    private String lugarResidencia;
    private String sobrenombre;
    private int codigo;

    // Constructor -------------------------------------------------------------  
    public Participante(String nombre, String apellidos, String cedula, String email, String lugarResidencia, String sobrenombre, LocalDate fechaNacimiento, int codigo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarResidencia = lugarResidencia;
        this.sobrenombre = sobrenombre;
        this.codigo = codigo;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaNacimientoAsString() {
        return fechaNacimiento.toString(); // Convierte LocalDate a String
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + sobrenombre;
    }
}
