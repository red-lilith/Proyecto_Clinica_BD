/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.Historia_ClinicaDAO;
import Logica.Historia_Clinica;
import Logica.Registro_Consulta;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Historia_Control {
    Historia_ClinicaDAO historiaDAO;
    
    public Historia_Control(){
        historiaDAO = new Historia_ClinicaDAO();
    }
    
    public int  insertarHistoria(int id_paciente, String fecha_apert){
        Historia_Clinica historia = new Historia_Clinica();        

        historia.setPaciente(id_paciente);
        historia.setFechaApertura(fecha_apert);
        
        int result = historiaDAO.insertar(historia);
        
        return result;
    }    

    public Historia_Clinica consultarHistoria(int id_paciente){
        Historia_Clinica paciente = new Historia_Clinica();
        
        paciente = historiaDAO.consultar(id_paciente);
      
       return paciente;
    }
    
    public int eliminarHistoria(int id_paciente){
        int result = historiaDAO.eliminar(id_paciente);
        return result;
    }
    
    
       
}
