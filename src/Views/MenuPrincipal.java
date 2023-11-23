/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

/**
 *
 * @author asval
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ParticipantesBtn = new javax.swing.JButton();
        CreditosBtn = new javax.swing.JButton();
        ParticipantesBtn2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake");
        setBackground(new java.awt.Color(194, 252, 253));
        setForeground(new java.awt.Color(194, 252, 253));
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1112, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(194, 252, 253));
        jPanel1.setPreferredSize(new java.awt.Dimension(1112, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/MenuPrincipal/Snake.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1280, 1166));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 557, 720));

        ParticipantesBtn.setBackground(new java.awt.Color(27, 177, 174));
        ParticipantesBtn.setFont(new java.awt.Font("Georgia", 0, 28)); // NOI18N
        ParticipantesBtn.setForeground(new java.awt.Color(20, 20, 20));
        ParticipantesBtn.setText("Participantes");
        ParticipantesBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ParticipantesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ParticipantesBtn.setFocusable(false);
        ParticipantesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticipantesBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ParticipantesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 330, 60));

        CreditosBtn.setBackground(new java.awt.Color(27, 177, 174));
        CreditosBtn.setFont(new java.awt.Font("Georgia", 0, 28)); // NOI18N
        CreditosBtn.setForeground(new java.awt.Color(20, 20, 20));
        CreditosBtn.setText("Créditos");
        CreditosBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CreditosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreditosBtn.setFocusable(false);
        CreditosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditosBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CreditosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 330, 60));

        ParticipantesBtn2.setBackground(new java.awt.Color(27, 177, 174));
        ParticipantesBtn2.setFont(new java.awt.Font("Georgia", 0, 28)); // NOI18N
        ParticipantesBtn2.setForeground(new java.awt.Color(20, 20, 20));
        ParticipantesBtn2.setText("Salir");
        ParticipantesBtn2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ParticipantesBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ParticipantesBtn2.setFocusable(false);
        ParticipantesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticipantesBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(ParticipantesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 330, 60));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 50)); // NOI18N
        jLabel2.setText("Campeonato Snake");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 41, 510, 58));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(86, 150, 52));
        jLabel3.setText("Campeonato Snake");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 510, 58));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ParticipantesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticipantesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParticipantesBtnActionPerformed

    private void CreditosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditosBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreditosBtnActionPerformed

    private void ParticipantesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticipantesBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParticipantesBtn2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreditosBtn;
    private javax.swing.JButton ParticipantesBtn;
    private javax.swing.JButton ParticipantesBtn2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
