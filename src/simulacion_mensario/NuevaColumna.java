/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_mensario;

/**
 *
 * @author adrys
 */
public class NuevaColumna extends javax.swing.JFrame {

    /**
     * Creates new form NuevaColumna
     */
    public NuevaColumna() {
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

        panelNuevaColumna = new javax.swing.JPanel();
        lblNombreNuevaColumna = new javax.swing.JLabel();
        txtNombreNuevaColumna = new javax.swing.JTextField();
        btnAceptarNuevaColumna = new javax.swing.JButton();
        btnCancelarNuevaColumna = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelNuevaColumna.setBackground(new java.awt.Color(204, 204, 204));

        lblNombreNuevaColumna.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombreNuevaColumna.setText("Nombre de la nueva columna:");

        btnAceptarNuevaColumna.setForeground(new java.awt.Color(0, 153, 0));
        btnAceptarNuevaColumna.setIcon(new javax.swing.ImageIcon("C:\\Users\\adrys\\Documents\\NetBeansProjects\\Simulacion_Mensario\\iconos\\rsz_check.jpg")); // NOI18N
        btnAceptarNuevaColumna.setText("Aceptar");
        btnAceptarNuevaColumna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarNuevaColumnaMouseClicked(evt);
            }
        });

        btnCancelarNuevaColumna.setForeground(new java.awt.Color(204, 0, 0));
        btnCancelarNuevaColumna.setIcon(new javax.swing.ImageIcon("C:\\Users\\adrys\\Documents\\NetBeansProjects\\Simulacion_Mensario\\iconos\\cancel.png")); // NOI18N
        btnCancelarNuevaColumna.setText("Cancelar");
        btnCancelarNuevaColumna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarNuevaColumnaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelNuevaColumnaLayout = new javax.swing.GroupLayout(panelNuevaColumna);
        panelNuevaColumna.setLayout(panelNuevaColumnaLayout);
        panelNuevaColumnaLayout.setHorizontalGroup(
            panelNuevaColumnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaColumnaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNuevaColumnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreNuevaColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreNuevaColumna))
                .addContainerGap())
            .addGroup(panelNuevaColumnaLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(btnAceptarNuevaColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(btnCancelarNuevaColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        panelNuevaColumnaLayout.setVerticalGroup(
            panelNuevaColumnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaColumnaLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lblNombreNuevaColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombreNuevaColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelNuevaColumnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAceptarNuevaColumna, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(btnCancelarNuevaColumna, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNuevaColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNuevaColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarNuevaColumnaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarNuevaColumnaMouseClicked
        Envios.añadirColumna(txtNombreNuevaColumna.getText());
        Envios.mostrarDatosTContactos();
        this.dispose();
    }//GEN-LAST:event_btnAceptarNuevaColumnaMouseClicked

    private void btnCancelarNuevaColumnaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarNuevaColumnaMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarNuevaColumnaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevaColumna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaColumna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaColumna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaColumna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaColumna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarNuevaColumna;
    private javax.swing.JButton btnCancelarNuevaColumna;
    private javax.swing.JLabel lblNombreNuevaColumna;
    private javax.swing.JPanel panelNuevaColumna;
    private javax.swing.JTextField txtNombreNuevaColumna;
    // End of variables declaration//GEN-END:variables
}
