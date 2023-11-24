package Controllers;

import Views.MenuPrincipal;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static String url = "jdbc:sqlite:campeonato_snake_db.sqlite";
    public static Connection connect;

    public static void main(String[] args) {
        if (conectarBaseDatos()) {
            if (crearBaseDatos()) {
                MenuPrincipal menu = new MenuPrincipal();
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
            String sqlParticipantes = "CREATE TABLE IF NOT EXISTS participantes (\n"
                    + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	nombre TEXT NOT NULL,\n"
                    + "	apellidos TEXT NOT NULL,\n"
                    + "	email TEXT NOT NULL,\n"
                    + "	fechaNacimiento TEXT NOT NULL,\n"
                    + "	lugarResidencia TEXT NOT NULL,\n"
                    + "	sobrenombre TEXT NOT NULL,\n"
                    + "	codigo INTEGER NOT NULL\n"
                    + ");";
            PreparedStatement stmtParticipantes = connect.prepareStatement(sqlParticipantes);
            stmtParticipantes.execute();

            // Crear tabla de juegos (modifica según tus necesidades)
            String sqlJuegos = "CREATE TABLE IF NOT EXISTS juegos (\n"
                    + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	participanteId INTEGER NOT NULL,\n"
                    + "	puntuacion INTEGER NOT NULL,\n"
                    + "	fechaHora TEXT NOT NULL,\n"
                    + "	FOREIGN KEY(participanteId) REFERENCES participantes(id)\n"
                    + ");";
            PreparedStatement stmtJuegos = connect.prepareStatement(sqlJuegos);
            stmtJuegos.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
