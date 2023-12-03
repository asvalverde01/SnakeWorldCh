package Views;

import Models.Participante;
import javax.swing.JFrame;

public class FrameJuego extends JFrame {

    PanelDelJuego obj;

    FrameJuego(Participante participante) {
        obj = new PanelDelJuego();
        obj.setParticipanteActual(participante);
        this.add(obj);
        this.setTitle("Juego de Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
