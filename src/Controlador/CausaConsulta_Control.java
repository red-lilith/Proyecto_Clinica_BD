/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.Causa_ConsultaDAO;
import Logica.Causa_Consulta;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class CausaConsulta_Control {
    Causa_ConsultaDAO causa_conDAO;
    
    public CausaConsulta_Control(){
        causa_conDAO = new Causa_ConsultaDAO();
    }
    
    public int  insertarCausaConsulta(int causa, int serial, int consulta){
        Causa_Consulta causa_con = new Causa_Consulta();        

        causa_con.setCausa(causa);
        causa_con.setHistoria(causa);
        causa_con.setCodRegistro(consulta);
        
        int result = causa_conDAO.insertar(causa_con);
        
        return result;
    }    
    
    public Vector<Causa_Consulta> listarCausasConsulta(int cod_reg){
        Vector<Causa_Consulta> causas_con = new Vector<Causa_Consulta>();
        
        causas_con = causa_conDAO.listar(cod_reg);
      
       return causas_con;
    }        
}
