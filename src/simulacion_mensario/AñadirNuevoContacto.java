/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_mensario;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static simulacion_mensario.Envios.c;
import static simulacion_mensario.Envios.cambioMovilElegido;
import static simulacion_mensario.Envios.colorAzul;
import static simulacion_mensario.Envios.conectar;
import static simulacion_mensario.Envios.desconectar;
import static simulacion_mensario.Envios.rs;
import static simulacion_mensario.Envios.stmt;
import static simulacion_mensario.Envios.tablaContactos;
import static simulacion_mensario.Envios.tablaLicencias;
import static simulacion_mensario.Envios.colorNegro;

/**
 *
 * @author Adrián Rodríguez Sanisidro
 */
public class AñadirNuevoContacto extends javax.swing.JFrame {

    public static int eleccion;//Su valor depende si se pulsó el botón añadir nuevo contacto(0) o modificar contacto(1).

    /**
     * Creates new form AñadirNuevoContacto
     * @param eleccion
     */
    public AñadirNuevoContacto(int eleccion) {
        initComponents();
        AñadirNuevoContacto.eleccion = eleccion;
        this.setLocationRelativeTo(null);//Centra la ventana.
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));//Añade un icono a la ventana
        mostrarTablaARellenar();
        tablaNuevoContacto.getTableHeader().setReorderingAllowed(false);//Impide que se puedan reordenar las columnas.
        tablaNuevoContacto.getTableHeader().setBackground(colorAzul);//Cambia el color de fondo.
        tablaNuevoContacto.getTableHeader().setForeground(colorNegro);//Cambia el color de las letras.
        tablaNuevoContacto.getTableHeader().setFont(new Font("Tahoma",1,11));//Cambia la fuente.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAñadirNuevoContacto = new javax.swing.JPanel();
        scrollAñadirNuevoContacto = new javax.swing.JScrollPane();
        tablaNuevoContacto = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnAceptarNuevoContacto = new javax.swing.JButton();
        btnCancelarNuevoContacto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 204));

        panelAñadirNuevoContacto.setBackground(new java.awt.Color(153, 255, 255));
        panelAñadirNuevoContacto.setForeground(new java.awt.Color(255, 102, 0));

        tablaNuevoContacto.setBackground(new java.awt.Color(153, 255, 255));
        tablaNuevoContacto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablaNuevoContacto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaNuevoContacto.setGridColor(new java.awt.Color(0, 102, 204));
        tablaNuevoContacto.setSelectionBackground(new java.awt.Color(255, 102, 0));
        scrollAñadirNuevoContacto.setViewportView(tablaNuevoContacto);

        lblTitulo.setBackground(new java.awt.Color(153, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo.setText("Quieres añadir datos al resto de los campos o dejarlos vacíos? ");

        btnAceptarNuevoContacto.setBackground(new java.awt.Color(153, 255, 255));
        btnAceptarNuevoContacto.setForeground(new java.awt.Color(0, 153, 0));
        btnAceptarNuevoContacto.setIcon(new javax.swing.ImageIcon("C:\\Users\\adrys\\Documents\\NetBeansProjects\\Simulacion_Mensario\\iconos\\rsz_check.png")); // NOI18N
        btnAceptarNuevoContacto.setText("Aceptar");
        btnAceptarNuevoContacto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarNuevoContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarNuevoContactoMouseClicked(evt);
            }
        });

        btnCancelarNuevoContacto.setBackground(new java.awt.Color(153, 255, 255));
        btnCancelarNuevoContacto.setForeground(new java.awt.Color(255, 0, 0));
        btnCancelarNuevoContacto.setIcon(new javax.swing.ImageIcon("C:\\Users\\adrys\\Documents\\NetBeansProjects\\Simulacion_Mensario\\iconos\\cancel.png")); // NOI18N
        btnCancelarNuevoContacto.setText("Cancelar");
        btnCancelarNuevoContacto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarNuevoContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarNuevoContactoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAñadirNuevoContactoLayout = new javax.swing.GroupLayout(panelAñadirNuevoContacto);
        panelAñadirNuevoContacto.setLayout(panelAñadirNuevoContactoLayout);
        panelAñadirNuevoContactoLayout.setHorizontalGroup(
            panelAñadirNuevoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollAñadirNuevoContacto)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
            .addGroup(panelAñadirNuevoContactoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarNuevoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarNuevoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAñadirNuevoContactoLayout.setVerticalGroup(
            panelAñadirNuevoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAñadirNuevoContactoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollAñadirNuevoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAñadirNuevoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptarNuevoContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(btnCancelarNuevoContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAñadirNuevoContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAñadirNuevoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    Si eleccion es igual a 0 añadirá el nuevo contacto a la base de datos.
    Si eleccion es igual a 1 borrara de la base el contacto elegido y añadira el contacto con los cambios realizados.
    */
    private void btnAceptarNuevoContactoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarNuevoContactoMouseClicked
        if(eleccion==0){
            añadirContacto();
            Envios.txtNombreContacto.setText("");
            Envios.txtMovilContacto.setText("");
        }else{
            guardarCambiosContacto((String) tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0));
            Envios.txtNombreContacto.setText("");
            Envios.txtMovilContacto.setText("");
        }
        Envios.mostrarDatosTContactos();
        this.dispose();
    }//GEN-LAST:event_btnAceptarNuevoContactoMouseClicked
    /*
    Cirra la ventana
    */
    private void btnCancelarNuevoContactoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarNuevoContactoMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarNuevoContactoMouseClicked

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
            java.util.logging.Logger.getLogger(AñadirNuevoContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirNuevoContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirNuevoContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirNuevoContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirNuevoContacto(eleccion).setVisible(true);
            }
        });
    }
    /*
    Muestra la tabla,si eleccion es igual a 0 la muestra con los datos rellenados y permite cambiarlos
    o añadir nuevos si hay creadas mas columnaas de las predeterminadas,si eleccion es igual a 1 muestra
    la tabla con el contacto seleccionado para modificar.
    */
    public static void mostrarTablaARellenar(){
        try {
            conectar();
            String sql="Select * from contactos;";
            rs=stmt.executeQuery(sql);
            tablaNuevoContacto.setModel(Envios.resultSetToTableModel(rs));
            desconectar();
            Envios.sustituirNull(tablaNuevoContacto);
        } catch (SQLException ex) {
            Logger.getLogger(AñadirNuevoContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel modelo=(DefaultTableModel) tablaNuevoContacto.getModel();
        
        for(int i=0;i<tablaNuevoContacto.getRowCount();i++){
            modelo.removeRow(i);
                i -= 1;
        }
        Object[] linea = new Object[tablaContactos.getRowCount()];
        ArrayList<String>aux=new ArrayList<>();
        if(eleccion==0){
            aux.add(CrearGrupo.quitarEspacios(Envios.txtMovilContacto.getText()));
            aux.add(CrearGrupo.quitarEspacios(Envios.txtNombreContacto.getText()));
            aux.add(CrearGrupo.quitarEspacios(Envios.comboPais.getSelectedItem().toString()));
            for(int i=3;i<tablaContactos.getRowCount();i++){
                aux.add("");
            }
            linea=aux.toArray();
            modelo.addRow(linea);
            tablaNuevoContacto.setModel(modelo);
        }else{
            try {
                conectar();
                String eso=(String) tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0);
                String sql="Select * from contactos WHERE "+tablaContactos.getColumnName(0)+"='"+tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0)+"';";
                rs=stmt.executeQuery(sql);
                tablaNuevoContacto.setModel(Envios.resultSetToTableModel(rs));
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(AñadirNuevoContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
 
    }
    /*
    Añade el contacto a la base de datos
    */
    public static void añadirContacto() {
        try {
            conectar();
            String sql="INSERT INTO contactos VALUES "+añadirSinSaberLargo()+";";
            stmt.execute(sql);
            c.commit();
            desconectar();          
        } catch (SQLException ex) {
            Logger.getLogger(AñadirNuevoContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Crea un String con los valores de la tabla sin importar el número de columnas que tenga
    para despues poder hacer una consulta con el o añadirlo a la base de datos.
    */
    public static String añadirSinSaberLargo(){
        String aux="";
        for(int i=0;i<tablaNuevoContacto.getColumnCount();i++){
            if(i==(tablaNuevoContacto.getColumnCount()-1)) {
                aux=aux+(String)tablaNuevoContacto.getValueAt(0, i)+"');";
            }else if(i==0){
                aux="('"+(String)tablaNuevoContacto.getValueAt(0, i)+"','";
            }else{
                aux=aux+(String)tablaNuevoContacto.getValueAt(0, i)+"','";
            }
        }
        return aux;
    }
    /*
    Borra el contacto y lo añade con los cambios que se le han hecho
    */
    public static void guardarCambiosContacto(String movil){
        try {
            conectar();
            String sql="DELETE FROM contactos WHERE "+tablaNuevoContacto.getColumnName(0)+"='"+movil+"';";
            String auxNT=tablaNuevoContacto.getColumnName(0);
            String auxMovil=movil;
            String sql2="INSERT INTO contactos VALUES "+añadirSinSaberLargo();
            stmt.executeUpdate(sql);
            c.commit();
            stmt.executeUpdate(sql2);
            c.commit();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AñadirNuevoContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarNuevoContacto;
    private javax.swing.JButton btnCancelarNuevoContacto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelAñadirNuevoContacto;
    private javax.swing.JScrollPane scrollAñadirNuevoContacto;
    public static javax.swing.JTable tablaNuevoContacto;
    // End of variables declaration//GEN-END:variables
}
