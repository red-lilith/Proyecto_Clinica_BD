/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.PersonaDAO;
import Logica.Persona;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Persona_Control {
    PersonaDAO personaDAO;
    
    public Persona_Control(){
        personaDAO = new PersonaDAO();
    }
    
    public int  insertarPersona(int id, String nom, String dir, String tel){
        Persona persona = new Persona();        

        persona.setId(id);
        persona.setNombre(nom);
        persona.setDireccion(dir);
        persona.setTelefono(tel);
        
        int result = personaDAO.insertar(persona);
        
        return result;
    }  

    public Persona consultarPersona(int id){
        Persona persona = new Persona();
        
        persona = personaDAO.consultar(id);
      
       return persona;
    }
    
    public int modificarPersona(int id, String nom, String dir, String tel){
        Persona persona = new Persona();
        persona.setNombre(nom);
        persona.setDireccion(dir);
        persona.setTelefono(tel);
                
        int result = personaDAO.modificar(persona, id);
        
        return result;
    }   
    
    public int eliminarPersona(int id){
       
        int result = personaDAO.eliminar(id);
      
       return result;
    }
    
    public Vector<String> listarMedicos(){
        Vector<String> medicos = new Vector<String>();
        
        medicos = personaDAO.listarMedicos();
      
       return medicos;
    }
    
    public int idMedico(String nombre){
       
        int result = personaDAO.idMedico(nombre);
      
       return result;
    }    
    
    public Vector<Persona> listarPersonas(){
        Vector<Persona> listaPersonas = new Vector<Persona>();
        
        listaPersonas = personaDAO.listar();
        
        return listaPersonas;
    }
           
}
