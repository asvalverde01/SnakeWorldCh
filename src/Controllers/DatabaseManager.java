package Controllers;

import Models.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseManager {

    // Método para agregar un nuevo participante
    public static void agregarParticipante(Participante participante) {
        String sql = "INSERT INTO participantes (nombre, apellidos, email, fechaNacimiento, lugarResidencia, sobrenombre, codigo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Main.url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, participante.getNombre());
            pstmt.setString(2, participante.getApellidos());
            pstmt.setString(3, participante.getEmail());
            pstmt.setString(4, participante.getFechaNacimiento().toString());
            pstmt.setString(5, participante.getLugarResidencia());
            pstmt.setString(6, participante.getSobrenombre());
            pstmt.setInt(7, participante.getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Métodos para leer, actualizar y eliminar
    // ...
}
