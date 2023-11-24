package Views;

import Controllers.PanelRegresoListener;
import java.awt.event.ActionEvent;

public class CreditosPanel extends javax.swing.JPanel {

    private PanelRegresoListener listener; // Referencia a la interfaz

    public CreditosPanel() {
        initComponents();

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regresarBtn = new javax.swing.JButton();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Resources/SnakeBackground.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1150, 810));
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton regresarBtn;
    // End of variables declaration//GEN-END:variables
}
