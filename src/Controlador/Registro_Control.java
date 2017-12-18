/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.Registro_ConsultaDAO;
import Logica.Registro_Consulta;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Registro_Control {
    Registro_ConsultaDAO registroDAO;
    
    public Registro_Control(){
        registroDAO = new Registro_ConsultaDAO();
    }

    public int  insertarRegistro(int cod, int serial, String fecha, int medico, int codform, int precio){
        Registro_Consulta registro = new Registro_Consulta();       

        registro.setCodConsulta(cod);
        registro.setHistoria(serial);
        registro.setFechaConsulta(fecha);
        registro.setMedico(medico);
        registro.setCodFormulaConsulta(codform);
        registro.setPrecioConsulta(precio);
        
        int result = registroDAO.insertar(registro);
        
        return result;
    } 
    
    public int  insertarRegistroNOFormula(int cod, int serial, String fecha, int medico, int precio){
        Registro_Consulta registro = new Registro_Consulta();       

        registro.setCodConsulta(cod);
        registro.setHistoria(serial);
        registro.setFechaConsulta(fecha);
        registro.setMedico(medico);
        registro.setPrecioConsulta(precio);
        
        int result = registroDAO.insertarSINFormula(registro);
        
        return result;
    } 
    
    public Registro_Consulta consultarRegistro(int serial, int cod){
        Registro_Consulta registro = new Registro_Consulta();
        
        registro = registroDAO.consultar(serial, cod);
      
       return registro;
    }
    
    public Vector<Registro_Consulta> filtrarRegistros(int serial, String fecha1, String fecha2){
        Vector<Registro_Consulta> registros = new Vector<Registro_Consulta>();
        
        registros = registroDAO.consultarxFechas(serial, fecha1, fecha2);
      
       return registros;
    }    
    
    public Vector<Registro_Consulta> listarRegistros(int serial){
        Vector<Registro_Consulta> registros = new Vector<Registro_Consulta>();
        
        registros = registroDAO.listar(serial);
      
       return registros;
    } 
    
    public int eliminarRegistros(int id_paciente){
       
        int result = registroDAO.eliminarTodos(id_paciente);
      
       return result;
    }
  
}
