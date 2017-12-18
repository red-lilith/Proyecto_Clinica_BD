/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acceso_Datos;

import Logica.Medicamento;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Sebastianaf
 */
public class MedicamentoDAO {
    public Acceso_BD fachadaBD;
    
    public MedicamentoDAO(){
        fachadaBD = new Acceso_BD();
    }
    
    public int insertar(Medicamento medicamento){
        String sql_insert;
        int numFilas=0;
        sql_insert="INSERT INTO medicamento (nom_medicam, descrip_medicam, costo_medicam) VALUES ('"+
        medicamento.getNomMedicamento()+ "', '" + medicamento.getDescrip_medicamento() +  "', " +
        medicamento.getCosto_medicamento() + ")";
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
    
    public Vector<Medicamento> buscarxNombre(String nombre){
        Vector <Medicamento> meds = new Vector <Medicamento>();
        String sql_select;
        sql_select="SELECT cod_medicam,nom_medicam, descrip_medicam, costo_medicam FROM medicamento WHERE nom_medicam ILIKE '%"+nombre+"%'";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                System.out.println("next");
                Medicamento med = new Medicamento(); 
                med.setCodigoMedicamento(tabla.getInt(1));
                med.setNomMedicamento( tabla.getString(2) );
                med.setDescripMedicamento(tabla.getString(3));
                med.setCostoMedicamento(tabla.getInt(4));
                meds.addElement(med);
            }         
            System.out.println("size: "+ meds.size());
            return meds;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return meds;
    }
    
    public int consultarxNombre(String nombre){
        int cod = 0;
        String sql_select;
        sql_select="SELECT cod_medicam FROM medicamento WHERE nom_medicam = '"+nombre+"'";
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
    
    public Medicamento consultar(int cod_medicamento){
        Medicamento medic = new Medicamento();
        String sql_select;
        sql_select="SELECT cod_medicam, nom_medicam, descrip_medicam, costo_medicam FROM medicamento WHERE cod_medicam ="+cod_medicamento+"";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                medic.setCodigoMedicamento(tabla.getInt(1));
                medic.setNomMedicamento(tabla.getString(2));
                medic.setDescripMedicamento(tabla.getString(3));
                medic.setCostoMedicamento(tabla.getInt(4));             
            }         
            return medic;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificar(Medicamento medicamento, int cod){
        String sql_update;
        int numFilas=0;
        sql_update="UPDATE medicamento SET nom_medicam = '" + medicamento.getNomMedicamento() +  "', descrip_medicam = '" +
        medicamento.getDescrip_medicamento() + "', costo_medicam = "+ medicamento.getCosto_medicamento() + "";
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
    
    public int eliminar(int cod_medicamento){
        String sql_delete;
        int numFilas=0;

        sql_delete="DELETE FROM medicamento WHERE cod_medicam = "+
                cod_medicamento+ "";
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
    
    public Vector<Medicamento> listar(){
        Vector<Medicamento> medics = new Vector<Medicamento>();
        String sql_select;
        sql_select="SELECT cod_medicam, nom_medicam, descrip_medicam, costo_medicam FROM medicamento";
         try{
            Connection conn = fachadaBD.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){ 
                Medicamento medic = new Medicamento();
                medic.setCodigoMedicamento(tabla.getInt(1));
                medic.setNomMedicamento(tabla.getString(2));
                medic.setDescripMedicamento(tabla.getString(3));
                medic.setCostoMedicamento(tabla.getInt(4)); 
                medics.addElement(medic);
            }         
            return medics;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return medics;
    }
}
