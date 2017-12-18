/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Habilidades_Enfermera;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Sebastianaf
 */
public class Habilidades_EnfermeraDAO {
    public Acceso_BD fachadaBD;
    
    public Habilidades_EnfermeraDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Habilidades_Enfermera habilidad){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO habilidades_enfermera VALUES ('" + habilidad.getHabilidad() + "',"  + habilidad.getId() + ")";
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
    
    public Vector <Habilidades_Enfermera> consultar(int id_enfermera){
        Vector<Habilidades_Enfermera> habs = new Vector<Habilidades_Enfermera>();
        String sql_select;
        sql_select="SELECT habilidad, id_enfermera FROM habilidades_enfermera WHERE id_enfermera ="+id_enfermera+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Habilidades_Enfermera hab = new Habilidades_Enfermera(); 
               hab.setId(tabla.getInt(2));
               hab.setHabilidad(tabla.getString(1));
               habs.addElement(hab);
            }         
            return habs;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Habilidades_Enfermera habilidad, int id){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE habilidades_enfermera SET habilidad = '" + habilidad.getHabilidad() + " WHERE id_enfermera ="+id+"";
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
    
    public int eliminar(int id){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM habilidades_enfermera WHERE id_enfermera = "+
                id+ "";
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
}
