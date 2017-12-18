/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Historia_Clinica;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class Historia_ClinicaDAO {
    public Acceso_BD fachadaBD;
    
    public Historia_ClinicaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Historia_Clinica historia){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO historia_clinica (id_paciente, fecha_apertura) VALUES ("+
                historia.getPaciente()+ ", '" + historia.getFechaApertura() +  "')";
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
    
    public Historia_Clinica consultar(int id_paciente){
        Historia_Clinica historia = new Historia_Clinica();
        String sql_select;
        sql_select="SELECT serial_hist_clin, id_paciente, fecha_apertura FROM historia_clinica WHERE id_paciente ="+id_paciente+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               historia.setSerial(tabla.getInt(1));
               historia.setPaciente(tabla.getInt(2));
               historia.setFechaApertura(tabla.getString(3)); 
            }         
            return historia;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int eliminar(int id_paciente){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM historia_clinica WHERE id_paciente = "+
                id_paciente+ "";
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
