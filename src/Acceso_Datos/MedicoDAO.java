/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Medico;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Sebastianaf
 */
public class MedicoDAO {
    public Acceso_BD fachadaBD;
    
    public MedicoDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Medico medico){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO medico VALUES (" + medico.getId() + ", '"  + medico.getEspecialidad() + "', '"+ medico.getNumLicencia() +"', '"+ medico.getUniversidad()+"')";
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
    
    public Medico consultar(int id_medico){
        Medico medico = new Medico();
        String sql_select;
        sql_select="SELECT medico.id_medico, medico.especial_medico, medico.num_licencia_medico, medico.univ_medico FROM medico WHERE id_medico ="+id_medico+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            if (!tabla.isBeforeFirst() ) 
                return null;
            
            while(tabla.next()){ 
               medico.setId(tabla.getInt(1));
               medico.setEspecialidad(tabla.getString(2));
               medico.setNumLicencia(tabla.getString(3));
               medico.setUniversidad(tabla.getString(4));
            }
            
            return medico;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Medico medico, int id){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE medico SET especial_medico = '" + medico.getEspecialidad() + "', num_licencia_medico ='" +medico.getNumLicencia()+"', univ_medico = '"+medico.getUniversidad()+"' WHERE id_medico ="+id+"";
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
    
    public int eliminar(int id_medico){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM medico WHERE id_medico = "+id_medico+ "";
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
    
    public Vector<Medico> filtrar(String filtro){
        Vector<Medico> medicos = new Vector<Medico>();
        String sql_select;
        sql_select="SELECT medico.id_medico, medico.especial_medico, medico.num_licencia_medico, medico.univ_medico "
                + "FROM medico INNER JOIN empleado ON medico.id_medico=empleado.id_empleado"
                + " INNER JOIN area ON area.cod_area=empleado.cod_area WHERE area.nom_area ='"+filtro+"'";
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Medico med = new Medico(); 
               med.setId(tabla.getInt(1));
               med.setEspecialidad(tabla.getString(2));
               med.setNumLicencia(tabla.getString(3));
               med.setUniversidad(tabla.getString(4));
               medicos.addElement(med);
            }         
            return medicos;
         }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return medicos;
    }
    
}
