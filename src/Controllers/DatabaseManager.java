package Controllers;

import Models.ListaDoblementeEnlazada;
import Models.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Random;

public class DatabaseManager {

    // Método para agregar un nuevo participante
    public static int agregarParticipante(Participante participante) {
        Random random = new Random();
        int codigo = 1000 + random.nextInt(9000); 
        participante.setCodigo(codigo);
        
        String sql = "INSERT INTO participantes (nombre, apellidos, email, fechaNacimiento, lugarResidencia, sobrenombre, codigo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Main.url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
        return codigo;
    }

    public static ListaDoblementeEnlazada obtenerParticipantes() {
        String sql = "SELECT * FROM participantes";
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        try (Connection conn = DriverManager.getConnection(Main.url); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                LocalDate fechaNac = LocalDate.parse(rs.getString("fechaNacimiento"));
                Participante participante = new Participante(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        null,
                        rs.getString("email"),
                        rs.getString("lugarResidencia"),
                        rs.getString("sobrenombre"),
                        fechaNac,
                        rs.getInt("codigo")
                );
                lista.agregar(participante);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
