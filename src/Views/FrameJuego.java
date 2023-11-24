package Views;

import javax.swing.JFrame;
public class FrameJuego extends JFrame{
    
    PanelDelJuego obj = new PanelDelJuego();
    
    FrameJuego(){
            this.add(obj);
            this.setTitle("Juego de Snake");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
    }
}