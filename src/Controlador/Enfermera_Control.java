/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.EnfermeraDAO;
import Logica.Enfermera;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Enfermera_Control {
    EnfermeraDAO enfermeraDAO;
    
    public Enfermera_Control(){
        enfermeraDAO = new EnfermeraDAO();
    }
    
    public int  insertarEnfermera(int id, int exp){
        Enfermera enfermera = new Enfermera();        

        enfermera.setId(id);
        enfermera.setExperiencia(exp);
 
        int result = enfermeraDAO.insertar(enfermera);
        
        return result;
    }  

    public Enfermera consultarEnfermera(int id){
        Enfermera enfermera = new Enfermera();
        
        enfermera = enfermeraDAO.consultar(id);
      
       return enfermera;
    }
    
    public int modificarEnfermera(int id, int exp){
        Enfermera enfermera = new Enfermera();
        enfermera.setExperiencia(exp);
                
        int result = enfermeraDAO.modificar(enfermera, id);
        
        return result;
    }   
    
    public int eliminarEnfermera(int id){
         
        int result = enfermeraDAO.eliminar(id);
      
       return result;
    }     
    
    public Vector<Enfermera> filtrarEnfermera(String filtro){
        Vector<Enfermera> enfermeras = new Vector<Enfermera>();
        enfermeras = enfermeraDAO.filtrar(filtro);
        
        return enfermeras;
    }
    
}
