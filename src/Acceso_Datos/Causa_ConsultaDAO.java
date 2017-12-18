/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Causa_Consulta;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class Causa_ConsultaDAO {
    public Acceso_BD fachadaBD;
    
    public Causa_ConsultaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Causa_Consulta causaConsulta){
        String sql_insert;
        int numFilas=0;
        sql_insert="INSERT INTO causas_consulta VALUES ("+
        causaConsulta.getCausa()+ ","+causaConsulta.getCodRegistro()+")";
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
    
    public Vector<Causa_Consulta> listar(int cod_reg){
        Vector<Causa_Consulta> causas_con = new Vector<Causa_Consulta>();
        String sql_select;
        sql_select="SELECT cod_causa, cod_consulta FROM causas_consulta WHERE cod_consulta ="+cod_reg+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Causa_Consulta c = new Causa_Consulta();
                c.setCausa(tabla.getInt(1));
                c.setCodRegistro(tabla.getInt(2));
                causas_con.addElement(c);
            }         
            return causas_con;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return causas_con;
    }
}
