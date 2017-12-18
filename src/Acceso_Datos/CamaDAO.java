/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Cama;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Sebastianaf
 */
public class CamaDAO {  
    public Acceso_BD fachadaBD;
    AreaDAO areaDAO;
    
    public CamaDAO(){
        fachadaBD = new Acceso_BD();
        AreaDAO areaDAO = new AreaDAO();
    }
    
    public int insertar(Cama cama){
        String sql_insert;
        int numFilas=0;
        sql_insert="INSERT INTO cama VALUES ("+
        cama.getNumero()+ ", '" + cama.getDescripcion() +  "', " +
        cama.getArea() + ", '"+ cama.getEstado() +"')";
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
    
    public Cama consultar(int num_cama){
        Cama cama = new Cama();
        String sql_select;
        sql_select="SELECT num_cama, descripcion_cama, cod_area, estado FROM cama WHERE num_cama ="+num_cama+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                cama.setNumero(tabla.getInt(1));
                cama.setDescripcion(tabla.getString(2));
                cama.setArea(tabla.getInt(3));
                cama.setEstado(tabla.getString(4));             
            }         
            return cama;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Cama cama, int num){
        String sql_update;
        int numFilas=0;
        sql_update="UPDATE area SET descripcion_cama = '" + cama.getDescripcion() +  "', cod_area = " +
        cama.getArea() + ", estado = '"+ cama.getEstado() + "' WHERE num_cama ="+num+"";
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
    
    public Vector filtrar(String filtro){
        Vector <Cama> camas = new Vector<Cama>();
        String sql_select;
        sql_select="SELECT num_cama, descripcion_cama, cod_area, estado FROM cama WHERE estado LIKE '%"+filtro+"%'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Cama cama = new Cama(); 
                cama.setNumero(tabla.getInt(1));
                cama.setDescripcion(tabla.getString(2));
                cama.setArea(tabla.getInt(3));
                cama.setEstado(tabla.getString(4));   
                camas.addElement(cama);
            }         
            return camas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return camas;
    }
    
    public int eliminar(int num_cama){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM cama WHERE num_cama = "+
                num_cama+ "";
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
    
    public Vector<Cama> listar(){
        Vector<Cama> camas = new Vector<Cama>();
        String sql_select;
        sql_select="SELECT num_cama, descripcion_cama, cod_area, estado FROM cama";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Cama cama = new Cama();
                cama.setNumero(tabla.getInt(1));
                cama.setDescripcion(tabla.getString(2));
                cama.setArea(tabla.getInt(3));
                cama.setEstado(tabla.getString(4)); 
                camas.addElement(cama);
            }         
            return camas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return camas;
    }
}
