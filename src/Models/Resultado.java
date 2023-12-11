package Models;

import static Controllers.DatabaseManager.obtenerParticipantePorCedula;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Resultado {

    private final Participante participante;
    private final int puntuacion;
    private final LocalDateTime fechaHoraInicio;
    private final LocalDateTime fechaHoraFin;
    private long duracionEnSegundos = 0;
    private String participanteCedula = null;

    public Resultado(Participante participante, int puntuacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.participante = participante;
        this.puntuacion = puntuacion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }

    public Resultado(String participanteCedula, int puntuacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, long duracionEnSegundos) {
        // Obtener el participante asociado a la cédula
        this.participante = obtenerParticipantePorCedula(participanteCedula);
        this.puntuacion = puntuacion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.duracionEnSegundos = duracionEnSegundos;
        this.participanteCedula = participanteCedula;  // Corregido
    }

    // Método para calcular la duración en segundos
    public long getDuracionEnSegundos() {
        Duration duration = Duration.between(fechaHoraInicio, fechaHoraFin);
        return duration.getSeconds();
    }

    // Getters y setters
    public Participante getParticipante() {
        return participante;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    @Override
    public String toString() {
        return "Resultado{" + "participante=" + participante + ", puntuacion=" + puntuacion + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + '}';
    }

}
