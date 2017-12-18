/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.CamaDAO;
import Logica.Cama;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Cama_Control {
    CamaDAO camaDAO;
    
    public Cama_Control(){
        camaDAO = new CamaDAO();
    }
    
    public int  insertarCama(int num, String descrip, int cod, String estado){
        Cama cama = new Cama();        

        cama.setNumero(num);
        cama.setDescripcion(descrip);
        cama.setArea(cod);
        cama.setEstado(estado);
        
        int result = camaDAO.insertar(cama);
        
        return result;
    }  

    public Cama consultarCama(int num){
        Cama cama = new Cama();
        
        cama = camaDAO.consultar(num);
      
       return cama;
    }
    
    public int modificarCama(int num, String descrip, int cod, String estado){
        Cama cama = new Cama();
        cama.setDescripcion(descrip);
        cama.setArea(cod);
        cama.setEstado(estado);
                
        int result = camaDAO.modificar(cama, num);
        
        return result;
    }   
    
    public int eliminarCama(int num){
        Cama cama = new Cama();
        
        int result = camaDAO.eliminar(num);
      
       return result;
    }
    
    public Vector<Cama> filtrarCama(String filtro){
        Vector <Cama> camas = new Vector<Cama>();
        
        camas = camaDAO.filtrar(filtro);
      
       return camas;
    } 
    
    public Vector<Cama> listarCamas(){
        Vector<Cama> camas = new Vector<Cama>();
        
        camas = camaDAO.listar();
      
       return camas;
    }    
}
