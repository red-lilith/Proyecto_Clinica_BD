/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Area;
import java.sql.*;
import java.util.Vector;
/**
 * 
 * @author Sebastianaf
 */
public class AreaDAO {
    private Acceso_BD fachadaBD;
    
    public AreaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Area area){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO area VALUES ("+
                area.getCodigo()+ ", '" + area.getNombre() +  "', '" +
                area.getDescripcion() + "')";
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
    
    public Area consultar(String nombre_Area){
        Area area = new Area();
        String sql_select;
        sql_select="SELECT cod_area, nom_area, descrip_area FROM area WHERE nom_area ='"+nombre_Area+"'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               area.setCodigo(tabla.getInt(1));
               area.setNombre(tabla.getString(2));
               area.setDescripcion(tabla.getString(3));              
            }         
            return area;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Area area, int cod){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE area SET nom_area = '" + area.getNombre() +  "', descrip_area = '" +
                area.getDescripcion() + "' WHERE cod_area ="+cod+"";
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
    
    public Vector <Area> filtrar(String filtro){
        Vector <Area> areas = new Vector<Area>();
        String sql_select;
        sql_select="SELECT cod_area, nom_area, descrip_area FROM area WHERE nom_area LIKE '%"+filtro+"%'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Area area = new Area(); 
               area.setCodigo(tabla.getInt(1));
               area.setNombre(tabla.getString(2));
               area.setDescripcion(tabla.getString(3)); 
               areas.addElement(area);
            }         
            return areas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return areas;
    }
    
    public int eliminar(int cod_Area){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM area WHERE cod_area = "+
                cod_Area+ "";
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
    
    public Vector<Area> listar(){
        Vector <Area> areas = new Vector<Area>();
        String sql_select;
        sql_select="SELECT cod_area, nom_area, descrip_area FROM area";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Area area = new Area(); 
               area.setCodigo(tabla.getInt(1));
               area.setNombre(tabla.getString(2));
               area.setDescripcion(tabla.getString(3)); 
               areas.addElement(area);
            }         
            return areas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return areas;
    }

    public Area consultarCodigo(int cod) {
        Area area = new Area();
        String sql_select;
        sql_select="SELECT cod_area, nom_area, descrip_area FROM area WHERE cod_area ='"+cod+"'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               area.setCodigo(tabla.getInt(1));
               area.setNombre(tabla.getString(2));
               area.setDescripcion(tabla.getString(3));              
            }         
            return area;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
}
