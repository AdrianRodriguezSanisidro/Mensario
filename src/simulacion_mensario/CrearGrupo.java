/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_mensario;

import com.sun.glass.events.KeyEvent;
import static java.awt.event.KeyEvent.VK_SPACE;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static simulacion_mensario.Envios.*;

/**
 *
 * @author adrys
 */
public class CrearGrupo extends javax.swing.JFrame {

    public static String cValidos = "abcdefghijklmnñopkrstuvwxyz ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    /**
     * Creates new form CrearGrupo
     */
    public CrearGrupo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public static void crearGruposT() {
        try {
            conectar();
            String sql = "CREATE TABLE grupos "
                    + "(nGrupo TEXT PRIMARY KEY NOT NULL,"
                    + "nLicencia TEXT);";
            String sql2 = "INSERT INTO grupos VALUES('Todos','SYSTEM');";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.executeUpdate(sql2);
            c.commit();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Envios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void crearNuevoGrupo(String nombreG) {
            try {
                conectar();
                String sql = "CREATE TABLE " + quitarEspacios(nombreG) + "(Movil TEXT PRIMARY KEY NOT NULL)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO grupos VALUES('" + nombreG + "','" + lblNombreUsr.getText() + "');";
                stmt.executeUpdate(sql);
                c.commit();
                desconectar();
                mostrarGruposCombo();
            } catch (SQLException ex) {
                Logger.getLogger(Envios.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    public static boolean comprobarNombreG(String nombreG) {
        char[] charArray = nombreG.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (cValidos.indexOf(charArray[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static String quitarEspacios(String nombreG) {
        String sinEspacios = nombreG.replaceAll(" ", "_");
        return sinEspacios;
    }

    public static void mostrarGruposCombo() {
        try {
            conectar();
            String sql = "SELECT * FROM grupos;";
            rs = stmt.executeQuery(sql);
            comboElegirGrupo.removeAllItems();
            comboAñadirAlGrupo.removeAllItems();
            comboElegirGrupo.addItem("Todos");
            comboAñadirAlGrupo.addItem("Todos");
            while (rs.next()) {
                comboElegirGrupo.addItem(rs.getString("nGrupo"));
                comboAñadirAlGrupo.addItem(rs.getString("nGrupo"));
            }
            c.commit();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void mostarTodo() {
        try {
            conectar();
            String sql2 = "SELECT * FROM contactos;";

            String sql = "SELECT * FROM contactos WHERE Movil=(SELECT * FROM familia WHERE contactos.Movil=familia.Movil);";
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            c.commit();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void borrarT(String tabla) {
        try {
            desconectar();
            String sql = "Delete from grupos where nGrupo='" + tabla + "';";
            String sql2 = "Drop table " + tabla;
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            System.out.println("Borrado " + tabla);
            c.commit();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificarTodos() {
        try {
            conectar();
            String sql = "INSERT INTO grupos VALUES('Todos','" + lblNombreUsr.getText() + "');";
            stmt.executeUpdate(sql);
            System.out.println("AÑADIDO todos");
            c.commit();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static void cambiosEnLasTablas() {
        try {
            conectar();
            String sql1 = "DROP TABLE grupos;";
            String sql2 = "DROP TABLE contactos;";
            stmt.executeUpdate(sql1);
            System.out.println("Borrada grupos");
            stmt.executeUpdate(sql2);
            System.out.println("Borrada contactos");
            c.commit();
            desconectar();
            crearTablaContactos();
            crearGruposT();

        } catch (SQLException ex) {
            System.err.println("AQUI");
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

        panelCrearGrupo = new javax.swing.JPanel();
        lblNuevoGrupo = new javax.swing.JLabel();
        txtNuevoGrupo = new javax.swing.JTextField();
        btnAceptarNuevoGrupo = new javax.swing.JButton();
        btnCancelarNuevoGrupo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear grupo");

        panelCrearGrupo.setBackground(new java.awt.Color(204, 204, 204));

        lblNuevoGrupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNuevoGrupo.setText("Nombre del nuevo grupo:");
        lblNuevoGrupo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));

        txtNuevoGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoGrupoKeyTyped(evt);
            }
        });

        btnAceptarNuevoGrupo.setForeground(new java.awt.Color(0, 153, 0));
        btnAceptarNuevoGrupo.setIcon(new javax.swing.ImageIcon("C:\\Users\\adrys\\Documents\\NetBeansProjects\\Simulacion_Mensario\\iconos\\rsz_check.jpg")); // NOI18N
        btnAceptarNuevoGrupo.setText("Aceptar");
        btnAceptarNuevoGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarNuevoGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarNuevoGrupoMouseClicked(evt);
            }
        });

        btnCancelarNuevoGrupo.setForeground(new java.awt.Color(204, 0, 0));
        btnCancelarNuevoGrupo.setIcon(new javax.swing.ImageIcon("C:\\Users\\adrys\\Documents\\NetBeansProjects\\Simulacion_Mensario\\iconos\\cancel.png")); // NOI18N
        btnCancelarNuevoGrupo.setText("Cancelar");
        btnCancelarNuevoGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarNuevoGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarNuevoGrupoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCrearGrupoLayout = new javax.swing.GroupLayout(panelCrearGrupo);
        panelCrearGrupo.setLayout(panelCrearGrupoLayout);
        panelCrearGrupoLayout.setHorizontalGroup(
            panelCrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearGrupoLayout.createSequentialGroup()
                        .addGroup(panelCrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNuevoGrupo)
                            .addComponent(txtNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(panelCrearGrupoLayout.createSequentialGroup()
                        .addComponent(btnAceptarNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCrearGrupoLayout.setVerticalGroup(
            panelCrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearGrupoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelCrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelarNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptarNuevoGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrearGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrearGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNuevoGrupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoGrupoKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isAlphabetic(c) || c == KeyEvent.VK_DELETE || Character.isDigit(c))) {
            evt.consume();
        }

    }//GEN-LAST:event_txtNuevoGrupoKeyTyped

    private void btnAceptarNuevoGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarNuevoGrupoMouseClicked
        boolean auxOK = true;
        if(!txtNuevoGrupo.getText().equals("")){
            if(empiezaPorLetra(txtNuevoGrupo.getText())==true){
                for (int i = 0; i < comboElegirGrupo.getItemCount(); i++) {
                    if (quitarEspacios(comboElegirGrupo.getItemAt(i)).equals(quitarEspacios(txtNuevoGrupo.getText()))) {
                        auxOK = false;
                    }
                }
                if (auxOK == true) {
                    crearNuevoGrupo(txtNuevoGrupo.getText());
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "El grupo ya existe");
                }
            }else{
                JOptionPane.showMessageDialog(null,"El grupo nó puede empezar por un número","¡ATENCIÓN!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"El nombre del grupo nó puede estar vacío","¡ATENCIÓN!",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAceptarNuevoGrupoMouseClicked

    private void btnCancelarNuevoGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarNuevoGrupoMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarNuevoGrupoMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> {
            new CrearGrupo().setVisible(true);
        });
    }
    public static boolean empiezaPorLetra(String palabraAComprobar){
        char[]alfabetoArray=Envios.alfabeto.toCharArray();
        char[]aux=palabraAComprobar.toCharArray();
        for(int i=0;i<alfabetoArray.length;i++){
            if(alfabetoArray[i]==aux[0]){
                return true;
            }
        }
        return false;
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarNuevoGrupo;
    private javax.swing.JButton btnCancelarNuevoGrupo;
    private javax.swing.JLabel lblNuevoGrupo;
    private javax.swing.JPanel panelCrearGrupo;
    public static javax.swing.JTextField txtNuevoGrupo;
    // End of variables declaration//GEN-END:variables
}
