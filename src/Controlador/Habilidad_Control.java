/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.Habilidades_EnfermeraDAO;
import Logica.Habilidades_Enfermera;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Habilidad_Control {
    Habilidades_EnfermeraDAO habilidadesDAO;
    
    public Habilidad_Control(){
        habilidadesDAO = new Habilidades_EnfermeraDAO();
    }
    
    public int insertarHabilidad(String hab, int id){
        Habilidades_Enfermera habilidad = new Habilidades_Enfermera();        

        habilidad.setId(id);
        habilidad.setHabilidad(hab);
 
        int result = habilidadesDAO.insertar(habilidad);
        
        return result;
    }  

    public Vector <Habilidades_Enfermera> consultarHabilidad(int id){
        Vector <Habilidades_Enfermera> habilidades = new Vector <Habilidades_Enfermera>();
        
        habilidades = habilidadesDAO.consultar(id);
      
       return habilidades;
    }
    
    public int modificarHabilidad(String hab, int id){
        Habilidades_Enfermera habilidad = new Habilidades_Enfermera();
        habilidad.setHabilidad(hab);
                
        int result = habilidadesDAO.modificar(habilidad, id);
        
        return result;
    }   
    
    public int eliminarHabilidades(int id){       
        int result = habilidadesDAO.eliminar(id);
      
       return result;
    }     
}
