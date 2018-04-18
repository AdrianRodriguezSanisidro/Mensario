/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_mensario;

import com.sun.glass.events.KeyEvent;
import static java.awt.event.KeyEvent.VK_SPACE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static simulacion_mensario.Envios.alfabetoRemitente;

/**
 *
 * @author adrys
 */
public class CrearGrupo extends javax.swing.JFrame {
    public static String cValidos="abcdefghijklmnñopkrstuvwxyz ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    /**
     * Creates new form CrearGrupo
     */
    public CrearGrupo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public static void crearGruposT() {
        try {
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:jmensario.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE grupos "
                    + "(nGrupo TEXT PRIMARY KEY NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Envios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Envios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void crearNuevoGrupo(String nombreG) {
        if(comprobarNombreG(nombreG)==true){
            try {
                Connection c = null;
                Statement stmt = null;
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:jmensario.db");
                c.setAutoCommit(false);
                stmt = c.createStatement();
                String sql = "CREATE TABLE "+adaptarNombreG(nombreG)+"(movilc TEXT PRIMARY KEY NOT NULL)";
                stmt.executeUpdate(sql);
                sql="INSERT INTO grupos VALUES('"+txtNuevoGrupo.getText()+"');";
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
                mostrarGruposCombo();
            } catch (SQLException ex) {
                Logger.getLogger(Envios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Envios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"El nombre del grupo es incorrecto.\nEl nombre solo admite caracteres de la A a la Z y espacios");
        }
    }
    public static boolean comprobarNombreG(String nombreG){
        char[] charArray = nombreG.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (cValidos.indexOf(charArray[i]) < 0) {
                return false;
            }
        }
        return true;
    }
    public static String adaptarNombreG(String nombreG){
        String nMinuscula=nombreG.toLowerCase();
        String sinEspacios=nMinuscula.replaceAll(" ", "_");
        return sinEspacios;
    }
    public static void mostrarGruposCombo(){
        Connection c=null;
        Statement stmt=null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:jmensario.db");
            c.setAutoCommit(false);
            stmt=c.createStatement();
            String sql="SELECT * FROM grupos;";
            ResultSet rs=stmt.executeQuery(sql);
            Envios.comboElegirGrupo.removeAllItems();
            while(rs.next()){
                Envios.comboElegirGrupo.addItem(rs.getString("nGrupo"));
            }
        } catch (Exception ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        lblNuevoGrupo = new javax.swing.JLabel();
        txtNuevoGrupo = new javax.swing.JTextField();
        btnAceptarNuevoGrupo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblNuevoGrupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNuevoGrupo.setText("Nombre del nuevo grupo:");
        lblNuevoGrupo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));

        txtNuevoGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoGrupoKeyTyped(evt);
            }
        });

        btnAceptarNuevoGrupo.setText("Crear");
        btnAceptarNuevoGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarNuevoGrupoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNuevoGrupo)
                    .addComponent(txtNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnAceptarNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptarNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNuevoGrupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoGrupoKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isAlphabetic(c) || (c == VK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }

    }//GEN-LAST:event_txtNuevoGrupoKeyTyped

    private void btnAceptarNuevoGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarNuevoGrupoMouseClicked
        crearNuevoGrupo(txtNuevoGrupo.getText());
        this.dispose();
    }//GEN-LAST:event_btnAceptarNuevoGrupoMouseClicked

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
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarNuevoGrupo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNuevoGrupo;
    public static javax.swing.JTextField txtNuevoGrupo;
    // End of variables declaration//GEN-END:variables
}