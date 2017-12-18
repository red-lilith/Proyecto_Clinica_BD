/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_clinica;
import Controlador.Vista_Control;
import Acceso_Datos.*;
import Gui.Agendamiento;

/**
 *
 * @author ennuikibun
 */
public class Proyecto_Clinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Acceso_BD test = new Acceso_BD();
        Vista_Control vista = new Vista_Control();
        
        Agendamiento agendamiento = new Agendamiento(vista);
        agendamiento.setDefaultCloseOperation(agendamiento.EXIT_ON_CLOSE);
    }
    
}
