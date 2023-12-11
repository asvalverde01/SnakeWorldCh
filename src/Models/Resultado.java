package Models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Resultado {

    private final Participante participante;
    private final int puntuacion;
    private final LocalDateTime fechaHoraInicio;
    private final LocalDateTime fechaHoraFin;

    public Resultado(Participante participante, int puntuacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.participante = participante;
        this.puntuacion = puntuacion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
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
    
    
}
