/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Registro_Consulta;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class Registro_ConsultaDAO {
    public Acceso_BD fachadaBD;
    
    public Registro_ConsultaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Registro_Consulta registro){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO registro_consulta VALUES ("+
                registro.getCodConsulta()+ ", " + registro.getHistoria() +  ", '" +
                registro.getFechaConsulta() + "', "+registro.getMedico()+", "+registro.getCodFormulaConsulta()+", "+registro.getPrecioConsulta()+")";
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
    
    public int insertarSINFormula(Registro_Consulta registro){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO registro_consulta (cod_consulta, serial_hist_clin, fecha_consulta, id_medico, precio_consulta) VALUES ("+
                registro.getCodConsulta()+ ", " + registro.getHistoria() +  ", '" +
                registro.getFechaConsulta() + "', "+registro.getMedico()+", "+registro.getPrecioConsulta()+")";
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
    
    public Registro_Consulta consultar(int serial, int cod_registro){
        Registro_Consulta registro = new Registro_Consulta();
        String sql_select;
        sql_select="SELECT cod_consulta, serial_hist_clin, fecha_consulta, id_medico, cod_formula, precio_consulta "
                + "FROM registro_consulta "
                + "WHERE serial_hist_clin ="+serial+" AND cod_consulta ="+cod_registro+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               registro.setCodConsulta(tabla.getInt(1));
               registro.setHistoria(tabla.getInt(2));
               registro.setFechaConsulta(tabla.getString(3));
               registro.setMedico(tabla.getInt(4));  
               registro.setCodFormulaConsulta(tabla.getInt(5));  
               registro.setPrecioConsulta(tabla.getInt(6));   
            }         
            return registro;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }

    
    public Vector<Registro_Consulta> consultarxFechas(int serial_historia, String fecha_inicio, String fecha_fin){
        Vector<Registro_Consulta> registros = new Vector<Registro_Consulta>();
        String sql_select;
        sql_select="SELECT cod_consulta, serial_hist_clin, fecha_consulta, id_medico, cod_formula, precio_consulta "
                + "FROM registro_consulta "
                + "WHERE serial_hist_clin ="+serial_historia+" AND fecha_consulta BETWEEN '"+fecha_inicio+"' AND '"+fecha_fin+"'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
               Registro_Consulta registro = new Registro_Consulta();
               registro.setCodConsulta(tabla.getInt(1));
               registro.setHistoria(tabla.getInt(2));
               registro.setFechaConsulta(tabla.getString(3));
               registro.setMedico(tabla.getInt(4));  
               registro.setCodFormulaConsulta(tabla.getInt(5));  
               registro.setPrecioConsulta(tabla.getInt(6));  
               registros.addElement(registro);
            }         
            return registros;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int eliminarTodos(int serial_historia){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM registro_consulta WHERE serial_hist_clin = "+
                serial_historia+ "";
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
    
    public Vector<Registro_Consulta> listar (int serial){
        Vector<Registro_Consulta> registros = new Vector<Registro_Consulta>();
        String sql_select;
        sql_select="SELECT cod_consulta, serial_hist_clin, fecha_consulta, id_medico, cod_formula, precio_consulta "
                + "FROM registro_consulta WHERE serial_hist_clin ="+serial+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Registro_Consulta registro = new Registro_Consulta();
               registro.setCodConsulta(tabla.getInt(1));
               registro.setHistoria(tabla.getInt(2));
               registro.setFechaConsulta(tabla.getString(3));
               registro.setMedico(tabla.getInt(4));  
               registro.setCodFormulaConsulta(tabla.getInt(5));  
               registro.setPrecioConsulta(tabla.getInt(6));  
               registros.addElement(registro);
            }         
            return registros;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return registros;      
    } 
}
