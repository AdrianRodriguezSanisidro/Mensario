/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_mensario;

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
            comprobarTelefonos();
            validarTelefonos();
            lblNumCaracteres.setText("" + txtAreaMensaje.getText().length());
            comprobarCheck();
            comprobarNumMensajes();
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

    public void comprobarTelefonos() {
        String[] contador = txtAreaMoviles.getText().split(",");
        if (contador.length > 1) {
            lblMovilesInsertados.setText("" + contador.length);
        } else {
            if (!"".equals(txtAreaMoviles.getText())) {
                lblMovilesInsertados.setText("1");
            } else {
                lblMovilesInsertados.setText("0");
            }
        }
        
    }
    public void validarTelefonos(){
        String[] contador = txtAreaMoviles.getText().split(",");
        Boolean[] comprobador=new Boolean[contador.length];
        for(int i=0;i<contador.length;i++){
            if((contador[i].startsWith("6")||contador[i].startsWith("7"))&&contador[i].length()==9){
                comprobador[i]=true;
            }else{
                comprobador[i]=false;
            }
        }
        if(comprobarBooleans(comprobador)==true){
            btnEnviar.setEnabled(true);
        }else{
            btnEnviar.setEnabled(false);
        }
    }
    public boolean comprobarBooleans(Boolean[] array){
    for(boolean b : array) if(!b) return false;
    return true;
}
    
}
