/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.Asistencia_CampanaDAO;
import Logica.Asistencia_Campana;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Asistencia_Control {
    Asistencia_CampanaDAO asistenciaDAO;
    
    public Asistencia_Control(){
        asistenciaDAO = new Asistencia_CampanaDAO();
    }
    
    public int  insertarAsistencia(int cod, int id_pac){
        Asistencia_Campana campana = new Asistencia_Campana();        

        campana.setCampana(cod);
        campana.setPaciente(id_pac);
        
        int result = asistenciaDAO.insertar(campana);
        
        return result;
    }    
    
    public Vector<Asistencia_Campana> filtrarAsistencias(int codCamp){
        Vector <Asistencia_Campana> campanas = new Vector<Asistencia_Campana>();
        
        campanas = asistenciaDAO.filtrar(codCamp);
      
       return campanas;
    }
    
    public Vector<Asistencia_Campana> listarAsistencias(int id_pac){
        Vector<Asistencia_Campana> campanas = new Vector<Asistencia_Campana>();
        
        campanas = asistenciaDAO.listar(id_pac);
      
       return campanas;
    }
         
}
