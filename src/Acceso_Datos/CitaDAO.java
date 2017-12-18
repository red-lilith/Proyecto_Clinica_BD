/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Cita;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class CitaDAO {
    public Acceso_BD fachadaBD;
    
    public CitaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Cita cita){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO cita VALUES ("+
                cita.getPaciente()+ ", '" + cita.getFecha() +  "', '" +
                cita.getHora() + "', " + cita.getMedico() +  ", "+ cita.getPrecio()+")";
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
    
    public int eliminar(int pac, int med, String fecha, String hora){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM cita WHERE id_paciente = "+
                pac+ "AND id_medico =med AND fecha_cita ='"+fecha+"' AND hora_cita ='"+hora+"'";
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
    
    public Vector<Cita> consultarxMedico(int medico){
        Vector <Cita> citas = new Vector<Cita>();
        String sql_select;
        sql_select="SELECT cita.id_paciente, cita.fecha_cita, cita.hora_cita, cita.id_medico, cita.precio_cita "
                + "FROM cita INNER JOIN medico ON cita.id_medico=medico.id_medico"
                + " WHERE medico.id_medico ="+medico+"";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Cita c = new Cita(); 
               c.setPaciente(tabla.getInt(1));
               c.setFecha(tabla.getString(2));
               c.setHora(tabla.getString(3));
               c.setMedico(tabla.getInt(4));
               c.setPrecio(tabla.getInt(5));
               citas.addElement(c);
            }         
            return citas;
         }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }      
       
        return citas;
    }
    
    public Vector<Cita> consultarxPaciente(int id_paciente){
        Vector <Cita> citas = new Vector<Cita>();
        String sql_select;
        sql_select="SELECT cita.id_paciente, cita.fecha_cita, cita.hora_cita, cita.id_medico, cita.precio_cita "
                + "FROM cita INNER JOIN paciente ON cita.id_paciente=paciente.id_paciente"
                + " WHERE paciente.id_paciente ="+id_paciente+"";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Cita c = new Cita(); 
               c.setPaciente(tabla.getInt(1));
               c.setFecha(tabla.getString(2));
               c.setHora(tabla.getString(3));
               c.setMedico(tabla.getInt(4));
               c.setPrecio(tabla.getInt(5));
               citas.addElement(c);
            }         
            return citas;
         }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }      
       
        return citas;
    }
    
    public Vector<Cita> consultarxFechas(String f1, String f2){
        Vector <Cita> citas = new Vector<Cita>();
        String sql_select;
        sql_select="SELECT id_paciente, fecha_cita, hora_cita, id_medico, precio_cita "
                + "FROM cita "
                + "WHERE fecha_cita BETWEEN '"+f1+"' AND '"+f2+"'";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Cita c = new Cita(); 
               c.setPaciente(tabla.getInt(1));
               c.setFecha(tabla.getString(2));
               c.setHora(tabla.getString(3));
               c.setMedico(tabla.getInt(4));
               c.setPrecio(tabla.getInt(5));
               citas.addElement(c);
            }         
            return citas;
         }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }      
       
        return citas;
    }
    
    public Vector<Cita> consultarxMes(String fecha1, String fecha2, int id_medico){
        Vector <Cita> citas = new Vector<Cita>();
        String sql_select;
        sql_select="SELECT id_paciente, fecha_cita, hora_cita, id_medico, precio_cita "
                + "FROM cita "
                + "WHERE id_medico ="+id_medico+" AND fecha_cita BETWEEN '"+fecha1+"' AND '"+fecha2+"'";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Cita c = new Cita(); 
               c.setPaciente(tabla.getInt(1));
               c.setFecha(tabla.getString(2));
               c.setHora(tabla.getString(3));
               c.setMedico(tabla.getInt(4));
               c.setPrecio(tabla.getInt(5));
               citas.addElement(c);
            }         
            return citas;
         }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }      
       
        return citas;
    }
    
    public Vector<Cita> listar(){
        Vector<Cita> citas = new Vector<Cita>();
        String sql_select;
        sql_select="SELECT id_paciente, fecha_cita, hora_cita, id_medico, precio_cita FROM cita";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Cita c = new Cita();
                c.setPaciente(tabla.getInt(1));
                c.setFecha(tabla.getString(2));
                c.setHora(tabla.getString(3));
                c.setMedico(tabla.getInt(4));
                c.setPrecio(tabla.getInt(5));
                citas.addElement(c);
            }         
            return citas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return citas;
    }
}
