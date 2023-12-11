package Controllers;

import Models.ListaDoblementeEnlazada;
import Views.MenuPrincipal;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static String url = "jdbc:sqlite:campeonato_snake_db.sqlite";
    public static Connection connect;

    public static ListaDoblementeEnlazada listaParticipantes = DatabaseManager.obtenerParticipantes();

    public static void main(String[] args) {
        if (conectarBaseDatos()) {
            if (crearBaseDatos()) {
                MenuPrincipal menu = new MenuPrincipal(listaParticipantes);

                menu.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
    }

    public static boolean conectarBaseDatos() {
        try {
            connect = DriverManager.getConnection(url);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static boolean crearBaseDatos() {
        try {
            // Crear tabla de participantes
            String sqlParticipantes = """
                                      CREATE TABLE IF NOT EXISTS participantes (
                                      \tid INTEGER PRIMARY KEY AUTOINCREMENT,
                                      \tnombre TEXT NOT NULL,
                                      \tapellidos TEXT NOT NULL,
                                      \tcedula TEXT NOT NULL,
                                      \temail TEXT NOT NULL,
                                      \tfechaNacimiento TEXT NOT NULL,
                                      \tlugarResidencia TEXT NOT NULL,
                                      \tsobrenombre TEXT NOT NULL,
                                      \tcodigo INTEGER NOT NULL
                                      );""";
            PreparedStatement stmtParticipantes = connect.prepareStatement(sqlParticipantes);
            stmtParticipantes.execute();

            // Crear tabla de juegos
            String sqlJuegos = """
                   CREATE TABLE IF NOT EXISTS juegos (
                   \tid INTEGER PRIMARY KEY AUTOINCREMENT,
                   \tparticipanteCedula TEXT NOT NULL,
                   \tpuntuacion INTEGER NOT NULL,
                   \tfechaHoraInicio TEXT NOT NULL,
                   \tfechaHoraFin TEXT NOT NULL,
                   \tduracionEnSegundos INTEGER NOT NULL,
                   \tFOREIGN KEY(participanteCedula) REFERENCES participantes(cedula)
                   );""";
            PreparedStatement stmtJuegos = connect.prepareStatement(sqlJuegos);
            stmtJuegos.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public ListaDoblementeEnlazada getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(ListaDoblementeEnlazada listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

}
