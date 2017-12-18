/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Campana_Prevencion;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class Campana_PrevencionDAO {
    public Acceso_BD fachadaBD;
    
    public Campana_PrevencionDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Campana_Prevencion campana){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO campana_prevencion VALUES ("+
                campana.getCodCampana()+ ", '" + campana.getNomCampana() +  "', '" +
                campana.getObjetCampana() + "', '" + campana.getFechaCampana() +  "', "+ campana.getMedicoEncargado()+")";
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
    
    public Campana_Prevencion consultar(int cod_campana){
        Campana_Prevencion campana = new Campana_Prevencion();
        String sql_select;
        sql_select="SELECT cod_campana, nom_campana, objet_campana, fecha_campana, id_medico FROM campana_prevencion WHERE cod_campana ="+cod_campana+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                campana.setCodCampana(tabla.getInt(1));
                campana.setNomCampana(tabla.getString(2));
                campana.setObjetCampana(tabla.getString(3)); 
                campana.setFechaCampana(tabla.getString(4)); 
                campana.setMedicoEncargado(tabla.getInt(5));          
            }         
            return campana;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public Campana_Prevencion consultarxNombre(String nom){
        Campana_Prevencion campana = new Campana_Prevencion();
        String sql_select;
        sql_select="SELECT cod_campana, nom_campana, objet_campana, fecha_campana, id_medico FROM campana_prevencion WHERE nom_campana = '"+nom+"'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                campana.setCodCampana(tabla.getInt(1));
                campana.setNomCampana(tabla.getString(2));
                campana.setObjetCampana(tabla.getString(3)); 
                campana.setFechaCampana(tabla.getString(4)); 
                campana.setMedicoEncargado(tabla.getInt(5));          
            }         
            return campana;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public Vector<Campana_Prevencion> listar(){
        Vector<Campana_Prevencion> campanas = new Vector<Campana_Prevencion>();
        String sql_select;
        sql_select="SELECT cod_campana, nom_campana, objet_campana, fecha_campana, id_medico FROM campana_prevencion";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Campana_Prevencion campana = new Campana_Prevencion();
                campana.setCodCampana(tabla.getInt(1));
                campana.setNomCampana(tabla.getString(2));
                campana.setObjetCampana(tabla.getString(3)); 
                campana.setFechaCampana(tabla.getString(4)); 
                campana.setMedicoEncargado(tabla.getInt(5));   
                campanas.addElement(campana);
            }         
            return campanas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return campanas;
    }
}
