/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.MedicoDAO;
import Logica.Medico;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Medico_Control {
    MedicoDAO medicoDAO;
    
    public Medico_Control(){
        medicoDAO = new MedicoDAO();
    }
    
    public int insertarMedico(int id, String espec, String licen, String uni){
        Medico medico = new Medico();        

        medico.setId(id);
        medico.setEspecialidad(espec);
        medico.setNumLicencia(licen);
        medico.setUniversidad(uni);
 
        int result = medicoDAO.insertar(medico);
        
        return result;
    }  

    public Medico consultarMedico(int id){
        Medico medico = new Medico();
        
        medico = medicoDAO.consultar(id);
      
       return medico;
    }
    
    public int modificarMedico(int id, String espec, String licen, String uni){
        Medico medico = new Medico();
        medico.setEspecialidad(espec);
        medico.setNumLicencia(licen);
        medico.setUniversidad(uni);
                
        int result = medicoDAO.modificar(medico, id);
        
        return result;
    }   
    
    public int eliminarMedico(int id){
         
        int result = medicoDAO.eliminar(id);
      
       return result;
    }     
    
    public Vector<Medico> filtrarMedico(String filtro){
        Vector<Medico> medicos = new Vector<Medico>();
        medicos = medicoDAO.filtrar(filtro);
        
        return medicos;
    }
      
}
