/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Asignacion_Camas;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class Asignacion_CamasDAO {
    private Acceso_BD fachadaBD;
    
    public Asignacion_CamasDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Asignacion_Camas asignacion){
        String sql_insert;
        int numFilas=0;
        sql_insert="INSERT INTO asignacion_camas (id_paciente, num_cama, fecha_asignacion) VALUES ("+
        asignacion.getPaciente()+ ", " + asignacion.getCama() + "'"+ asignacion.getFechaAsignacion()+"')";
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
    
    public Asignacion_Camas consultar(int id_paciente, String fecha){
        Asignacion_Camas asigna = new Asignacion_Camas();
        String sql_select;
        sql_select="SELECT id_paciente, num_cama, fecha_asignacion, fecha_salida FROM asignacion_camas WHERE id_paciente ="+id_paciente+" AND fecha_asignacion ='"+fecha+"'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            if (!tabla.isBeforeFirst() ) 
                return null;
            
            while(tabla.next()){
                asigna.setPaciente(tabla.getInt(1));
                asigna.setCama(tabla.getInt(2));
                asigna.setFechaAsignacion(tabla.getString(3));
                asigna.setFechaSalida(tabla.getString(4));             
            }         
            return asigna;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Asignacion_Camas asignacion){
        String sql_update;
        int numFilas=0;
        sql_update="UPDATE asignacion_camas SET fecha_salida = '" + asignacion.getFechaSalida() +  "' WHERE id_paciente ="+asignacion.getPaciente()+""
                + "AND num_cama = "+asignacion.getCama()+"";
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
}
