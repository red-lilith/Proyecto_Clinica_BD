/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Asistencia_Campana;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Sebastianaf
 */
public class Asistencia_CampanaDAO {
    
    public Acceso_BD fachadaBD;
    
    public Asistencia_CampanaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Asistencia_Campana asistencia){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO asistencia_campanas VALUES ("+
                asistencia.getCampana()+ ", " + asistencia.getPaciente() + ")";
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
    
    public Vector<Asistencia_Campana> listar(int id_paciente){
        Vector<Asistencia_Campana> asistencias = new Vector<Asistencia_Campana>();
        String sql_select;
        sql_select="SELECT cod_campana, id_paciente FROM asistencia_campanas WHERE id_paciente ="+id_paciente+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Asistencia_Campana asis = new Asistencia_Campana();
                asis.setCampana(tabla.getInt(1));
                asis.setPaciente(tabla.getInt(2));  
                asistencias.addElement(asis);
            }         
            return asistencias;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return asistencias;
    }
    
    public Vector<Asistencia_Campana> filtrar(int cod_cam){
        Vector<Asistencia_Campana> asistencias = new Vector<Asistencia_Campana>();
        String sql_select;
        sql_select="SELECT cod_campana, id_paciente FROM asistencia_campanas WHERE cod_campana ="+cod_cam+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Asistencia_Campana asis = new Asistencia_Campana();
                asis.setCampana(tabla.getInt(1));
                asis.setPaciente(tabla.getInt(2));  
                asistencias.addElement(asis);
            }         
            return asistencias;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return asistencias;
    }
    
}
