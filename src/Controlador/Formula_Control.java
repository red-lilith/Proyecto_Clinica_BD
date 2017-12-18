/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.FormulaDAO;
import Logica.Formula;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Formula_Control {
    FormulaDAO formulaDAO;
    
    public Formula_Control(){
        formulaDAO = new FormulaDAO();
    }
    
    public int  insertarFormula(int medico){
        Formula formula = new Formula();        

        formula.setMedico(medico);
        
        int result = formulaDAO.insertar(formula);
        
        return result;
    }  

    public Formula consultarFormula(int cod){
        Formula formula = new Formula();
        
        formula = formulaDAO.consultar(cod);
      
       return formula;
    }  
    
    public int consultarCodFormula(){
        int result = formulaDAO.consultarCodigo();
      
       return result;
    } 
    
    public int eliminarFormula(int cod){
        int result = formulaDAO.eliminar(cod);
      
       return result;
    }     
}
