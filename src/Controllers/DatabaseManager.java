package Controllers;

import Models.ListaDoblementeEnlazada;
import Models.Participante;
import Models.Resultado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class DatabaseManager {

    // Método para agregar un nuevo participante
    public static int agregarParticipante(Participante participante) {
        Random random = new Random();
        int codigo = 1000 + random.nextInt(9000);
        participante.setCodigo(codigo);

        // Incluye la cédula en la consulta SQL
        String sql = "INSERT INTO participantes (nombre, apellidos, cedula, email, fechaNacimiento, lugarResidencia, sobrenombre, codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(Main.url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, participante.getNombre());
            pstmt.setString(2, participante.getApellidos());
            pstmt.setString(3, participante.getCedula());
            pstmt.setString(4, participante.getEmail());
            pstmt.setString(5, participante.getFechaNacimiento().toString());
            pstmt.setString(6, participante.getLugarResidencia());
            pstmt.setString(7, participante.getSobrenombre());
            pstmt.setInt(8, participante.getCodigo());
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
                        rs.getString("cedula"),
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

    public static void guardarResultado(Resultado resultado) {
        String sql = "INSERT INTO juegos (participanteCedula, puntuacion, fechaHoraInicio, fechaHoraFin, duracionEnSegundos) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(Main.url); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, resultado.getParticipante().getCedula());
            pstmt.setInt(2, resultado.getPuntuacion());
            pstmt.setString(3, resultado.getFechaHoraInicio().toString());
            pstmt.setString(4, resultado.getFechaHoraFin().toString());
            pstmt.setLong(5, resultado.getDuracionEnSegundos());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ListaDoblementeEnlazada<Resultado> obtenerResultados() {
        String sql = "SELECT * FROM juegos";
        ListaDoblementeEnlazada<Resultado> lista = new ListaDoblementeEnlazada<>();

        try (Connection conn = DriverManager.getConnection(Main.url); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                LocalDateTime fechaHoraInicio = LocalDateTime.parse(rs.getString("fechaHoraInicio"));
                LocalDateTime fechaHoraFin = LocalDateTime.parse(rs.getString("fechaHoraFin"));

                Resultado resultado;
                resultado = new Resultado(
                        rs.getString("participanteCedula"),
                        rs.getInt("puntuacion"),
                        fechaHoraInicio,
                        fechaHoraFin,
                        rs.getLong("duracionEnSegundos")
                );
                lista.agregar(resultado);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static Participante obtenerParticipantePorCedula(String cedula) {
        String sql = "SELECT * FROM participantes WHERE cedula = ?";
        Participante participante = null;

        try (Connection conn = DriverManager.getConnection(Main.url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cedula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                LocalDate fechaNac = LocalDate.parse(rs.getString("fechaNacimiento"));
                participante = new Participante(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("cedula"),
                        rs.getString("email"),
                        rs.getString("lugarResidencia"),
                        rs.getString("sobrenombre"),
                        fechaNac,
                        rs.getInt("codigo")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return participante;
    }

    public static void desvincularParticipante(int codigo) {
        String sql = "UPDATE participantes SET sobrenombre = sobrenombre || ' (Desvinculado)' WHERE codigo = ?";

        try (Connection conn = DriverManager.getConnection(Main.url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
