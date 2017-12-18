/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Acceso_Datos.*;
import Logica.*;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Area_Control {
    AreaDAO areaDAO;
    
    public Area_Control(){
        areaDAO = new AreaDAO();
    }
    
    public int  insertarArea(int cod, String nom, String descrip){
        Area area = new Area();        

        area.setCodigo(cod);
        area.setNombre(nom);
        area.setDescripcion(descrip);
        
        int result = areaDAO.insertar(area);
        
        return result;
    }  

    public Area consultarArea(String nom){
        Area area = new Area();
        
        area = areaDAO.consultar(nom);
       return area;
    }
    
    public Area consultarAreaCodigo(int cod){
        Area area = new Area();
        
        area = areaDAO.consultarCodigo(cod);
        return area;
    }
    
    public int modificarArea(int cod, String nom, String descrip){
        Area area = new Area();
        area.setNombre(nom);
        area.setDescripcion(descrip);
                
        int result = areaDAO.modificar(area, cod);
        
        return result;
    }   
    
    public int eliminarArea(int cod){
        Area area = new Area();
        
        int result = areaDAO.eliminar(cod);
      
       return result;
    }
    
    public Vector<Area> filtrarArea(String filtro){
        Vector <Area> areas = new Vector<Area>();
        
        areas = areaDAO.filtrar(filtro);
      
       return areas;
    }
    
    public Vector<Area> listarAreas(){
        Vector <Area> areas = new Vector<Area>();
        
        areas = areaDAO.listar();
      
       return areas;
    }
    
    
    
}
