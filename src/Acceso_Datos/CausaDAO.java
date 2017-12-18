/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Causa;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class CausaDAO {
    public Acceso_BD fachadaBD;
    
    public CausaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Causa causa){
        String sql_insert;
        int numFilas=0;
        sql_insert="INSERT INTO causa (nom_causa, descrip_causa) VALUES ('"+
        causa.getNombre()+ "', '" + causa.getDescripcion() + "')";
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
    
    public Causa consultar(int cod_causa){
        Causa causa = new Causa();
        String sql_select;
        sql_select="SELECT cod_causa, nom_causa, descrip_causa FROM causa WHERE cod_causa ="+cod_causa+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                causa.setCodigo(tabla.getInt(1));
                causa.setNombre(tabla.getString(2));
                causa.setDescripcion(tabla.getString(3));            
            }         
            return causa;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int consultarxNombre(String nombre){
        Causa causa = new Causa();
        String sql_select;
        sql_select="SELECT cod_causa, nom_causa, descrip_causa FROM causa WHERE upper(nom_causa) = upper('"+nombre+"')";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                causa.setCodigo(tabla.getInt(1));
                causa.setNombre(tabla.getString(2));
                causa.setDescripcion(tabla.getString(3));            
            }         
            return causa.getCodigo();
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return 0;
    }
    
    public Vector<Causa> listar(){
        Vector<Causa> causas = new Vector<Causa>();
        String sql_select;
        sql_select="SELECT cod_causa, nom_causa, descrip_causa FROM causa";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Causa c = new Causa();
                c.setCodigo(tabla.getInt(1));
                c.setNombre(tabla.getString(2));
                c.setDescripcion(tabla.getString(3));
                causas.addElement(c);
            }         
            return causas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return causas;
    }
}
