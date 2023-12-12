package Views;

import Controllers.DatabaseManager;
import Controllers.Main;
import Models.Participante;
import Models.Resultado;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import javax.swing.*;

public class PanelDelJuego extends JPanel implements ActionListener {

    private Participante participanteActual;
    private LocalDateTime fechaHoraInicio;

    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 700;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 100;
    static final Color COLOR_MANZANA = Color.WHITE;
    static final Color COLOR_CABEZA = Color.GREEN;
    static final Color COLOR_CUERPO = new Color(45, 180, 0);
    static final Font FUENTE_PUNTAJE = new Font("RVV", Font.BOLD, 40);
    static final Font FUENTE_FIN_JUEGO = new Font("Ink Free", Font.BOLD, 75);

    public void setParticipanteActual(Participante participante) {
        this.participanteActual = participante;
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 3;
    int manzanasComidas;
    int manzanasX;
    int manzanasY;
    Direction direction = Direction.RIGHT;
    boolean running = false;
    Timer timer;
    Random random;

    PanelDelJuego() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        inicioJuego();
    }

    public void inicioJuego() {
        nuevaManzana();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
        fechaHoraInicio = LocalDateTime.now();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujo(g);
    }

    public void dibujo(Graphics g) {
        if (running) {
            dibujarManzana(g);
            dibujarSerpiente(g);
            dibujarPuntaje(g);
        } else {
            finJuego(g);
        }
    }

    private void dibujarManzana(Graphics g) {
        g.setColor(COLOR_MANZANA);
        g.fillOval(manzanasX, manzanasY, UNIT_SIZE, UNIT_SIZE);
    }

    private void dibujarSerpiente(Graphics g) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(COLOR_CABEZA);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(COLOR_CUERPO);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    private void dibujarPuntaje(Graphics g) {
        g.setColor(Color.red);
        g.setFont(FUENTE_PUNTAJE);
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Puntaje:" + manzanasComidas, (SCREEN_WIDTH - metrics.stringWidth("Puntaje: " + manzanasComidas)) / 2, g.getFont().getSize());
    }

    public void nuevaManzana() {
        manzanasX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        manzanasY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void movimientos() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case UP:
                y[0] = y[0] - UNIT_SIZE;
                break;
            case DOWN:
                y[0] = y[0] + UNIT_SIZE;
                break;
            case LEFT:
                x[0] = x[0] - UNIT_SIZE;
                break;
            case RIGHT:
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkManzanas() {
        if ((x[0] == manzanasX) && (y[0] == manzanasY)) {
            bodyParts++;
            manzanasComidas++;
            nuevaManzana();
        }
    }

    public void checkColisiones() {
        // Chequea si la cabeza choca con el cuerpo
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }

        // Chequea si la cabeza toca el borde izquierdo
        if (x[0] < 0) {
            running = false;
        }

        // Chequea si la cabeza toca el borde derecho
        if (x[0] >= SCREEN_WIDTH) {
            running = false;
        }

        // Chequea si la cabeza toca el borde superior
        if (y[0] < 0) {
            running = false;
        }

        // Chequea si la cabeza toca el borde inferior
        if (y[0] >= SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void finJuego(Graphics g) {
        dibujarPuntaje(g);

        g.setColor(Color.white);
        g.setFont(FUENTE_FIN_JUEGO);
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Usted ha perdido :-(", (SCREEN_WIDTH - metrics2.stringWidth("Usted ha perdido :-(")) / 2, SCREEN_HEIGHT / 2);

        if (!running) {
            LocalDateTime fechaHoraFin = LocalDateTime.now(); // Fecha y hora actuales al finalizar el juego

            Resultado resultado = new Resultado(participanteActual, manzanasComidas, fechaHoraInicio, fechaHoraFin);

            // Guardar en base de datos
            DatabaseManager.guardarResultado(resultado);
            Main.listaResultados.agregar(resultado);

            // Mostrar JOptionPane con resultados
            mostrarResultados(resultado);
            

            // Cerrar la ventana del juego
            Window window = SwingUtilities.getWindowAncestor(this);
            window.dispose();
        }
    }

    private void mostrarResultados(Resultado resultado) {
        String mensaje = "Resultados del juego:\n"
                + "Puntuación: " + resultado.getPuntuacion() + "\n"
                + "Duración: " + resultado.getDuracionEnSegundos() + " segundos";

        JOptionPane.showMessageDialog(this, mensaje, "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            movimientos();
            checkManzanas();
            checkColisiones();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != Direction.RIGHT) {
                        direction = Direction.LEFT;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != Direction.LEFT) {
                        direction = Direction.RIGHT;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != Direction.DOWN) {
                        direction = Direction.UP;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != Direction.UP) {
                        direction = Direction.DOWN;
                    }
                    break;
            }
        }
    }
}
