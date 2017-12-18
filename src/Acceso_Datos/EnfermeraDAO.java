/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Enfermera;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author Sebastianaf
 */
public class EnfermeraDAO {
     public Acceso_BD fachadaBD;
    
    public EnfermeraDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Enfermera enfermera){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO enfermera VALUES (" + enfermera.getId() + ","  + enfermera.getExperiencia() + ")";
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
    
    public Enfermera consultar(int id_enfermera){
        Enfermera enfermera = new Enfermera();
        String sql_select;
        sql_select="SELECT id_enfermera, experiencia FROM enfermera WHERE id_enfermera ="+id_enfermera+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               enfermera.setId(tabla.getInt(1));
               enfermera.setExperiencia(tabla.getInt(2));
            }         
            return enfermera;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Enfermera enfermera, int id){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE enfermera SET experiencia = '" + enfermera.getExperiencia() + " WHERE id_enfermera ="+id+"";
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
    
    public int eliminar(int id_enfermera){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM enfermera WHERE id_enfermera = "+
                id_enfermera+ "";
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
    
    public Vector<Enfermera> filtrar(String filtro){
        Vector<Enfermera> enfermeras = new Vector<Enfermera>();
        String sql_select;
        sql_select="SELECT enfermera.id_enfermera, enfermera.experiencia "
                + "FROM enfermera INNER JOIN empleado ON enfermera.id_enfermera=empleado.id_empleado"
                + " INNER JOIN area ON area.cod_area=empleado.cod_area WHERE area.nom_area ='"+filtro+"'";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Enfermera enfer = new Enfermera(); 
               enfer.setId(tabla.getInt(1));
               enfer.setExperiencia(tabla.getInt(2));
               enfermeras.addElement(enfer);
            }         
            return enfermeras;
         }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return enfermeras;
    }
}
