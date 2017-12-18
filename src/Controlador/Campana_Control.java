/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.Campana_PrevencionDAO;
import Logica.Campana_Prevencion;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Campana_Control {
    Campana_PrevencionDAO campanaDAO;
    
    public Campana_Control(){
        campanaDAO = new Campana_PrevencionDAO();
    }
    
    public int  insertarCampana(int cod, String nom, String obje, String fecha, int id_med){
        Campana_Prevencion campana = new Campana_Prevencion();        

        campana.setCodCampana(cod);
        campana.setNomCampana(nom);
        campana.setObjetCampana(obje);
        campana.setFechaCampana(fecha);
        campana.setMedicoEncargado(id_med);
        
        int result = campanaDAO.insertar(campana);
        
        return result;
    }    
    
    public Campana_Prevencion consultarCampana(int cod){
        Campana_Prevencion campana = new Campana_Prevencion();
        
        campana = campanaDAO.consultar(cod);
      
       return campana;
    }
    
    public Campana_Prevencion consultarxNombre(String nom){
        Campana_Prevencion campana = new Campana_Prevencion();
        
        campana = campanaDAO.consultarxNombre(nom);
      
       return campana;
    }
    
    public Vector<Campana_Prevencion> listarCampanas(){
        Vector<Campana_Prevencion> campanas = new Vector<Campana_Prevencion>();
        
        campanas = campanaDAO.listar();
      
       return campanas;
    }
         
}
