/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Empleado;
import Logica.Persona;
import Logica.Medico;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Sebastianaf
 */
public class PersonaDAO {
    public Acceso_BD fachadaBD;
    
    public PersonaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Persona persona){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO persona VALUES ("+
                persona.getId()+ ", '" + persona.getNombre() +  "', '" +
                persona.getDireccion() + "', '" + persona.getTelefono() +  "')";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_insert);            
            return numFilas;          
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return 0;
    }
   

    public Persona consultar(int id_persona){
        Persona persona = new Persona();
        String sql_select;
        sql_select="SELECT id_persona, nom_persona, dir_persona, tel_persona FROM persona WHERE id_persona ="+id_persona+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               persona.setId(tabla.getInt(1));
               persona.setNombre(tabla.getString(2));
               persona.setDireccion(tabla.getString(3));
               persona.setTelefono(tabla.getString(4));  
            }         
            return persona;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Persona persona, int id){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE persona SET nom_persona = '" + persona.getNombre() +  "', dir_persona = '" +
                persona.getDireccion() + "', tel_persona = '" + persona.getTelefono() + "' WHERE id_persona ="+id+"";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_update);            
            return numFilas;          
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return 0;
    }
        
    public int eliminar(int id_persona){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM persona WHERE id_persona = "+
                id_persona+ "";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_delete);            
            return numFilas;          
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return 0;
    }
    
    public Vector<String> listarMedicos(){
        Vector<String> medicos = new Vector<String>();
        String sql_select;
        sql_select="SELECT persona.nom_persona FROM medico INNER JOIN persona ON persona.id_persona=medico.id_medico";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               String nombre; 
               nombre = tabla.getString(1); 
               medicos.addElement(nombre);
            }         
            return medicos;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return medicos;
    }
    
        public int idMedico(String nombre){
        int id = 0;
        String sql_select;
        sql_select="SELECT medico.id_medico FROM medico INNER JOIN persona ON persona.id_persona=medico.id_medico WHERE UPPER(persona.nom_persona)= UPPER('"+nombre+"')";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               id = tabla.getInt(1); 
             }  
            return id;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return id;
    }
        
        public int idPaciente(String nombre){
        int id = 0;
        String sql_select;
        sql_select="SELECT paciente.id_paciente FROM medico INNER JOIN persona ON persona.id_persona=medico.id_medico WHERE persona.nom_persona='"+nombre+"'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               id = tabla.getInt(1); 
            }         
            return id;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return id;
    }
        
        public Vector<Persona> listar(){
        Vector <Persona> listaPersonas = new Vector<Persona>();
        String sql_select;
        sql_select="SELECT id_persona, nom_persona, dir_persona, tel_persona FROM persona";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Persona persona = new Persona(); 
               persona.setId(tabla.getInt(1));
               persona.setNombre(tabla.getString(2));
               persona.setDireccion(tabla.getString(3));
               persona.setTelefono(tabla.getString(4));

               
               
               listaPersonas.addElement(persona);
            }         
            return listaPersonas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return listaPersonas;
    }
    


}
