/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Formula;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class FormulaDAO {
    public Acceso_BD fachadaBD;
    
    public FormulaDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Formula formula){
        String sql_insert;
        int numFilas=0;
        sql_insert="INSERT INTO formula (id_medico) VALUES ("+
        formula.getMedico()+ ")";
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
    
    public int consultarCodigo(){
        int cod = 0;
        String sql_select;
        sql_select="SELECT currval('formula_seq')";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                cod = tabla.getInt(1);         
            }         
            return cod;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return cod;
    }    
    
    public Formula consultar(int cod_formula){
        Formula formula = new Formula();
        String sql_select;
        sql_select="SELECT cod_formula, id_medico FROM formula WHERE cod_formula ="+cod_formula+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                formula.setCodigo(tabla.getInt(1));
                formula.setMedico(tabla.getInt(2));          
            }         
            return formula;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int eliminar(int cod_formula){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM formula WHERE cod_formula = "+
                cod_formula+ "";
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
}
