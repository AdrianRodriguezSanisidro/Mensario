/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_mensario;

import java.util.logging.Level;
import java.util.logging.Logger;
import static simulacion_mensario.CrearGrupo.adaptarNombreG;
import static simulacion_mensario.Envios.*;

/**
 *
 * @author adrys
 */
public class Hilo extends Thread {
    
    int x = 2;
    int numAux = 1;
    

    public void run() {
            while (x == 2) {
                //validarTelefonos();
                lblNumCaracteres.setText("" + txtAreaMensaje.getText().length());
                comprobarCheck();
                lblMovilesInsertados.setText(comprobarTelefonos());
                comprobarNumMensajes();
                comprobarCambioDeGrupo();
                comprobarMovilPais(calcularLargoTelf(comboPais.getSelectedItem().toString()));
            }
    }

    public void comprobarNumMensajes() {
        if (txtAreaMensaje.getText().length() <= 160) {
            lblNumMensajes.setText("1");
        } else {
            int cantCar = txtAreaMensaje.getText().length() - 161;
            int resultado = (cantCar / 153);
            lblNumMensajes.setText("" + (resultado + 2));
        }
    }

    public static String comprobarTelefonos() {
        String[] contador = txtAreaMoviles.getText().split(",");
        String cantMoviles="0";
        if (contador.length > 1) {
            cantMoviles=""+contador.length;
        } else {
            if (!"".equals(txtAreaMoviles.getText())) {
                cantMoviles="1";
            } else {
                cantMoviles="0";
            }
        }
        return cantMoviles;
    }

    public void validarTelefonos() {
        String[] contador = txtAreaMoviles.getText().split(",");
        Boolean[] comprobador = new Boolean[contador.length];
        for (int i = 0; i < contador.length; i++) {
            if ((contador[i].startsWith("6") || contador[i].startsWith("7")) && (contador[i].length() >= 9)) {
                comprobador[i] = true;
            } else {
                comprobador[i] = false;
            }
        }
        if (comprobarBooleans(comprobador) == true) {
            btnEnviar.setEnabled(true);
        } else {
            btnEnviar.setEnabled(false);
        }
    }
    public static void comprobarMovilPais(int[]numeros){
        String auxM=txtMovilContacto.getText();
        if((auxM.startsWith(""+numeros[2])||auxM.startsWith(""+numeros[3])||auxM.startsWith(""+numeros[4]))&&
                (auxM.length()>=numeros[0]&&auxM.length()<=numeros[1])){
            btnAñadirContacto.setEnabled(true);
        }else{
            btnAñadirContacto.setEnabled(false);
        }
    }
    public static void comprobarCambioDeGrupo(){
        
        try{
            String aux=comboElegirGrupo.getSelectedItem().toString();
            String aux2=Envios.auxComprobarGrupo;
            if(aux!=null){
                if(Envios.auxComprobarGrupo==null){
                    Envios.auxComprobarGrupo="Todos";
                }else{
                    if(Envios.auxComprobarGrupo!=comboElegirGrupo.getSelectedItem().toString()){
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        mostrarDatosTContactos(adaptarNombreG(comboElegirGrupo.getSelectedItem().toString()), lblNombreUsr.getText());
                        Envios.auxComprobarGrupo=comboElegirGrupo.getSelectedItem().toString();
                    }
                }
            }
        }catch(NullPointerException ex){

        }
    }
    
    public boolean comprobarBooleans(Boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

}
