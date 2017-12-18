/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Area;
import Logica.Empleado;
import java.sql.*;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Sebastianaf
 */
public class EmpleadoDAO {
    public Acceso_BD fachadaBD;
    
    public EmpleadoDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Empleado empleado){
        String sql_insert;
        int numFilas=0;
        
        sql_insert="INSERT INTO empleado VALUES ("+
                empleado.getId()+ ", '" + empleado.getCargo() +  "', " +
                empleado.getSalario() + ", '" + empleado.getEmail() + "', " + empleado.getArea() + ", " + empleado.getJefe() + ",'"+empleado.getUsuario()+"','"+empleado.getContrasena()+"')";
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
    
    public Empleado consultar(int id_empleado){
        Empleado empleado = new Empleado();
        String sql_select;
        sql_select="SELECT id_empleado, cargo_empleado, salario_empleado, email_empleado, cod_area, id_jefe, usuario_empleado, contrasena_empleado FROM empleado WHERE id_empleado ="+id_empleado+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               empleado.setId(tabla.getInt(1));
               empleado.setCargo(tabla.getString(2));
               empleado.setSalario(tabla.getInt(3));
               empleado.setEmail(tabla.getString(4));  
               empleado.setArea(tabla.getInt(5));
               empleado.setJefe(tabla.getInt(6));
               empleado.setUsuario(tabla.getString(7));
               empleado.setContrasena_empleado(tabla.getString(8));
            }         
            return empleado;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Empleado empleado, int id){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE empleado SET cargo_empleado = '" + empleado.getCargo() +  "', email_empleado = '" +
                empleado.getEmail() + "', salario_empleado = " + empleado.getSalario() + ", cod_area = " + empleado.getArea() +", id_jefe = " + empleado.getJefe() + " WHERE id_empleado ="+id+"";
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
    
    public int eliminar(int id_empleado){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM empleado WHERE id_empleado = "+
                id_empleado+ "";
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
       
    
    public int loguear(String user, String pass){
        int id = 0;
        String sql_select;
        sql_select="SELECT id_empleado FROM empleado WHERE usuario_empleado ='"+user+"' AND contrasena_empleado ='"+pass+"'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               id = tabla.getInt(1);
            }         
            return id;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return id;
    }
    
    public int cambiarContrasena(String user, String pass){
        String sql_update;
        int numFilas=0;
        sql_update="UPDATE empleado SET contrasena_empleado = '" +pass+ "' WHERE usuario_empleado ='"+user+"'";
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
    
    
    public Vector<Empleado> listar(){
        Vector <Empleado> listaEmpleados = new Vector<Empleado>();
        String sql_select;
        sql_select="SELECT id_empleado, cargo_empleado, salario_empleado, email_empleado, cod_area, id_jefe, usuario_empleado, contrasena_empleado FROM empleado";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
               Empleado empleado = new Empleado(); 
               empleado.setId(tabla.getInt(1));
               empleado.setCargo(tabla.getString(2));
               empleado.setSalario(tabla.getInt(3));
               empleado.setEmail(tabla.getString(4));
               empleado.setArea(tabla.getInt(5));
               empleado.setJefe(tabla.getInt(6));
               empleado.setUsuario(tabla.getString(7));
               empleado.setContrasena_empleado(tabla.getString(8));
               
               
               listaEmpleados.addElement(empleado);
            }         
            return listaEmpleados;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return listaEmpleados;
    }
}
