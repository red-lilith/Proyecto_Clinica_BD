/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.FormulacionDAO;
import Logica.Formulacion;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Formulacion_Control {
    FormulacionDAO formulacionDAO;
    
    public Formulacion_Control(){
        formulacionDAO = new FormulacionDAO();
    }
    
    public int  insertarFormulacion(int formula, int medicam, String dosis){
        Formulacion form = new Formulacion();        

        form.setCodFormula(formula);
        form.setCodMedicamento(medicam);
        form.setDosis(dosis);
        
        int result = formulacionDAO.insertar(form);
        
        return result;
    }  

    public Vector<Formulacion> consultarFormulacion(int cod_formula){
        Vector<Formulacion>  form = new Vector<Formulacion>();
        
        form = formulacionDAO.consultar(cod_formula);
      
       return form;
    }  
    
    public int eliminarFormulacion(int cod_formula){
        int result = formulacionDAO.eliminar(cod_formula);
      
       return result;
    }       
}
