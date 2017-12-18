/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.CausaDAO;
import Logica.Causa;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Causa_Control {
    CausaDAO causaDAO;
    
    public Causa_Control(){
        causaDAO = new CausaDAO();
    }
    
    public int  insertarCausa(String nom, String descrip){
        Causa causa = new Causa();        

        causa.setNombre(nom);
        causa.setDescripcion(descrip);
        
        int result = causaDAO.insertar(causa);
        
        return result;
    }  

    public Causa consultarCausa(int cod){
        Causa causa = new Causa();
        
        causa = causaDAO.consultar(cod);
      
       return causa;
    }  
    
    public int validarCausa(String nom){
        int result;
        
        result = causaDAO.consultarxNombre(nom);
      
       return result;
    }  
    
    public Vector<Causa> listarCausa(){
        Vector<Causa> causas = new Vector<Causa>();
        
        causas = causaDAO.listar();
      
       return causas;
    }    
}
