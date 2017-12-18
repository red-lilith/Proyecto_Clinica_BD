/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.Asignacion_CamasDAO;
import Logica.Asignacion_Camas;

/**
 *
 * @author ennuikibun
 */
public class AsignaCama_Control {
    Asignacion_CamasDAO asignaDAO;
    
    public AsignaCama_Control(){
        asignaDAO = new Asignacion_CamasDAO();
    }

    public int  insertarAsignacion(int pac, int cama, String fecha){
        Asignacion_Camas asigna = new Asignacion_Camas();        

        asigna.setPaciente(pac);
        asigna.setCama(cama);
        asigna.setFechaAsignacion(fecha);
        asigna.setFechaSalida("");
        
        int result = asignaDAO.insertar(asigna);
        
        return result;
    }
    
    public Asignacion_Camas consultarAsignacion(int id_paciente, String fecha){
        Asignacion_Camas asigna = new Asignacion_Camas(); 
        
        asigna = asignaDAO.consultar(id_paciente, fecha);
      
       return asigna;
    }

    public int modificarAsignacion(int idPac, int numCama, String salida){
        Asignacion_Camas asigna = new Asignacion_Camas(); 
        asigna.setPaciente(idPac);
        asigna.setCama(numCama);
        asigna.setFechaSalida(salida);
                
        int result = asignaDAO.modificar(asigna);
        
        return result;
    }
       
}
