/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Paciente;
import java.sql.*;
/**
 *
 * @author Sebastianaf
 */
public class PacienteDAO {
    public Acceso_BD fachadaBD;
    
    public PacienteDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Paciente paciente){
        String sql_insert;
        int numFilas=0;

        sql_insert="INSERT INTO paciente VALUES ("+
                paciente.getId()+ ", '" + paciente.getNumSegSocial() +  "', '" +
                paciente.getFechaNacimiento() + "', '" + paciente.getActivEconomica() +  "')";
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
    
    public Paciente consultar(int id_paciente){
        Paciente paciente = new Paciente();
        String sql_select;
        sql_select="SELECT id_paciente, num_ss_paciente, fecha_nacim_paciente, act_econom_paciente FROM paciente WHERE id_paciente ="+id_paciente+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            if (!tabla.isBeforeFirst() ) 
                return null;
            while(tabla.next()){ 
               paciente.setId(tabla.getInt(1));
               paciente.setNumSegSocial(tabla.getString(2));
               paciente.setFechaNacimiento(tabla.getString(3));
               paciente.setActivEconomica(tabla.getString(4));  
            }         
            return paciente;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Paciente paciente, int id){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE paciente SET num_ss_paciente = '" + paciente.getNumSegSocial() +  "', fecha_nacim_paciente = '" +
                paciente.getFechaNacimiento() + "', act_econom_paciente = '" + paciente.getActivEconomica() + "' WHERE id_paciente ="+id+"";
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
    
    public int eliminar(int id_paciente){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM paciente WHERE id_paciente = "+
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
    
    public int promedioConsultas(int y,int m1, int m2){
        int result = 0;
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet promedio = sentencia.executeQuery(
                    "select round(avg(precio_consulta)) from registro_consulta\n" +
                    "where fecha_consulta between '"+y+"/"+m1+"/01' and '"+y+"/"+m2+"/28'"
            );
            
            promedio.next();
            result = promedio.getInt(1);
            
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return result;
    }
    
    public int promedioMedicamentos(int y,int m1,int m2){
        int result = 0;
        try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet promedio = sentencia.executeQuery(
                    "select round(avg(costo_medicam))\n" +
                    "from registro_consulta join formulacion_medicamento \n" +
                    "on registro_consulta.cod_formula=formulacion_medicamento.cod_formula\n" +
                    "join medicamento on medicamento.cod_medicam=formulacion_medicamento.cod_medicam\n" +
                    "where fecha_consulta between '"+y+"/"+m1+"/01' and '"+y+"/"+m2+"/28'"
            );
            
            promedio.next();
            result = promedio.getInt(1);
            
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return result;
    }
}
