/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_mensario;

import static simulacion_mensario.CrearGrupo.crearGruposT;
import static simulacion_mensario.Envios.crearTablaContactos;

/**
 *
 * @author adrys
 */
public class Simulacion_Mensario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Envios.crearTablaContactos();
        //Envios.borrarT();
        //Envios.soutTabla("Prueba");
        Envios objEnv = new Envios();
        objEnv.setVisible(true);

    }

}
