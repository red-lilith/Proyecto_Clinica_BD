/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.MedicamentoDAO;
import Logica.Medicamento;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Medicamento_Control {
    MedicamentoDAO medicamentoDAO;
    
    public Medicamento_Control(){
        medicamentoDAO = new MedicamentoDAO();
    }
    public int  insertarMedicamento( String nom, String descrip, int costo){
        Medicamento medic = new Medicamento();        

        
        medic.setNomMedicamento(nom);
        medic.setDescripMedicamento(descrip);
        medic.setCostoMedicamento(costo);
        
        int result = medicamentoDAO.insertar(medic);
        
        return result;
    }  
    
    public int  insertarMedicamento(int cod, String nom, String descrip, int costo){
        Medicamento medic = new Medicamento();        

        medic.setCodigoMedicamento(cod);
        medic.setNomMedicamento(nom);
        medic.setDescripMedicamento(descrip);
        medic.setCostoMedicamento(costo);
        
        int result = medicamentoDAO.insertar(medic);
        
        return result;
    }  

    public Medicamento consultarMedicamento(int cod){
        Medicamento medic = new Medicamento();
        
        medic = medicamentoDAO.consultar(cod);
      
       return medic;
    }
    
    public int consultarxNombre(String nom){
        int result = medicamentoDAO.consultarxNombre(nom);
      
       return result;
    }     
    
    public Vector <Medicamento> buscarxNombre(String nom){
         Vector <Medicamento> meds = new Vector <Medicamento>();
        
        return meds= medicamentoDAO.buscarxNombre(nom);
    }
    
    public int modificarMedicamento(int cod, String nom, String descrip, int costo){
        Medicamento medic = new Medicamento();
        medic.setNomMedicamento(nom);
        medic.setDescripMedicamento(descrip);
        medic.setCostoMedicamento(costo);
                
        int result = medicamentoDAO.modificar(medic, cod);
        
        return result;
    }   
    
    public int eliminarMedicamento(int cod){
        int result = medicamentoDAO.eliminar(cod);
      
       return result;
    } 
    
    public Vector<Medicamento> listarMedicamentos(){
        Vector<Medicamento> medics = new Vector<Medicamento>();
        
        medics = medicamentoDAO.listar();
      
       return medics;
    }    
}
