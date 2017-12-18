/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import Logica.Formulacion;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author ennuikibun
 */
public class FormulacionDAO {
    public Acceso_BD fachadaBD;
    
    public FormulacionDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Formulacion formulacion){
        String sql_insert;
        int numFilas=0;
        sql_insert="INSERT INTO formulacion_medicamento  VALUES ("+formulacion.getCodFormula()+ ", "+formulacion.getCodMedicamento()+", '"+formulacion.getDosis()+ "')";
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
    
    public Vector <Formulacion> consultar(int cod_formula){
        Vector <Formulacion> medicamentos = new Vector <Formulacion>();
        String sql_select;
        sql_select="SELECT cod_formula, cod_medicam, dosis FROM formulacion_medicamento WHERE cod_formula ="+cod_formula+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                Formulacion med = new Formulacion();
                med.setCodFormula(tabla.getInt(1));
                med.setCodMedicamento(tabla.getInt(2)); 
                med.setDosis(tabla.getString(3));
                medicamentos.addElement(med);
            }         
            return medicamentos;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int eliminar(int cod_formula){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM formulacion_medicamento WHERE cod_formula = "+
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
