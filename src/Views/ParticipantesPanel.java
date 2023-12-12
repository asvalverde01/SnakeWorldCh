package Views;

import Controllers.CorreoManager;
import Controllers.PanelRegresoListener;
import Models.ListaDoblementeEnlazada;
import Models.Participante;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ParticipantesPanel extends javax.swing.JPanel {

    private Participante participanteSeleccionado;

    private PanelRegresoListener listener;
    private ListaDoblementeEnlazada listaParticipantes;

    /**
     * Creates new form ParticipantesFrame
     *
     * @param listaParticipantes
     */
    public ParticipantesPanel(ListaDoblementeEnlazada listaParticipantes) {
        initComponents();
        this.listaParticipantes = listaParticipantes;
        initComponents();
        actualizarListaParticipantes();

        regresarBtn.addActionListener((ActionEvent e) -> {
            if (listener != null) {
                listener.onRegreso(); // Llamar al método onRegreso de la interfaz
            }
        });
    }

    // Método para establecer el listener
    public void setRegresoListener(PanelRegresoListener listener) {
        this.listener = listener;
    }

    private void actualizarListaParticipantes() {
        DefaultListModel<Participante> modelo = new DefaultListModel<>();
        for (Object participante : this.listaParticipantes.getLista()) {
            modelo.addElement((Participante) participante);
        }
        participantesJList.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regresarBtn = new javax.swing.JButton();
        RegistrarParticipanteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        participantesJList = new javax.swing.JList<>();
        jugarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1112, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regresarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regresarBtn.setText("Regresar a menú");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 560, 170, 40));

        RegistrarParticipanteBtn.setText("Registrar participante");
        RegistrarParticipanteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarParticipanteBtnActionPerformed(evt);
            }
        });
        add(RegistrarParticipanteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 180, 40));

        jScrollPane1.setViewportView(participantesJList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 700, -1));

        jugarBtn.setText("Iniciar Juego");
        jugarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarBtnActionPerformed(evt);
            }
        });
        add(jugarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Resources/SnakeBackground.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1150, 810));
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void RegistrarParticipanteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarParticipanteBtnActionPerformed
        // Registro
        RegistrarParticipanteFrame registrar = new RegistrarParticipanteFrame();
        registrar.setVisible(true);

        // Esperar a que se complete el registro antes de actualizar la lista
        registrar.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Obtener el participante registrado
                Participante participanteRegistrado = registrar.getParticipante();

                // Actualizar la lista de participantes después de que se cierre la ventana de registro
                actualizarListaParticipantes();

                // Enviar correo electrónico al participante registrado
                enviarCorreo(participanteRegistrado);
            }
        });
    }//GEN-LAST:event_RegistrarParticipanteBtnActionPerformed

    private void enviarCorreo(Participante participante) {
        String destinatario = participante.getEmail();
        String asunto = "Registro Exitoso";
        String contenido = "¡Gracias por registrarte! Aquí está tu información:\n\n"
                + "Nombre: " + participante.getNombre() + "\n"
                + "Apellidos: " + participante.getApellidos() + "\n"
                + "Cédula: " + participante.getCedula() + "\n"
                + "Código: " + participante.getCodigo() + "\n" +
                "\n\n¡Esperamos que disfrutes del juego!";

        CorreoManager.enviarCorreo(destinatario, asunto, contenido);
    }


    private void jugarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarBtnActionPerformed
        participanteSeleccionado = participantesJList.getSelectedValue();
        if (participanteSeleccionado != null) {
            FrameJuego juego = new FrameJuego(participanteSeleccionado);
            juego.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un participante", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jugarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegistrarParticipanteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jugarBtn;
    private javax.swing.JList<Participante> participantesJList;
    private javax.swing.JButton regresarBtn;
    // End of variables declaration//GEN-END:variables
}
