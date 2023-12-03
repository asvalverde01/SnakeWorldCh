package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Resultado {

    private final Participante participante;
    private final int puntuacion;
    private final LocalDateTime fechaHora;

    public Resultado(Participante participante, int puntuacion, LocalDateTime fechaHora) {
        this.participante = participante;
        this.puntuacion = puntuacion;
        this.fechaHora = fechaHora;
    }

    

    // Getters y setters
    public Participante getParticipante() {
        return participante;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

}
