/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.PacienteDAO;
import Logica.Paciente;

/**
 *
 * @author ennuikibun
 */
public class Paciente_Control {
    PacienteDAO pacienteDAO;
    
    public Paciente_Control(){
        pacienteDAO = new PacienteDAO();
    }
    
    public int  insertarPaciente(int id, String seg, String fecha, String act){
        Paciente paciente = new Paciente();        

        paciente.setId(id);
        paciente.setNumSegSocial(seg);
        paciente.setFechaNacimiento(fecha);
        paciente.setActivEconomica(act);
        
        int result = pacienteDAO.insertar(paciente);
        
        return result;
    }  

    public Paciente consultarPaciente(int id){
        Paciente paciente = new Paciente();
        
        paciente = pacienteDAO.consultar(id);
      
       return paciente;
    }
    
    public int modificarPaciente(int id, String seg, String fecha, String act){
        Paciente paciente = new Paciente();
        paciente.setNumSegSocial(seg);
        paciente.setFechaNacimiento(fecha);
        paciente.setActivEconomica(act);
                
        int result = pacienteDAO.modificar(paciente, id);
        
        return result;
    }   
    
    public int eliminarPaciente(int id){      
        int result = pacienteDAO.eliminar(id);
      
       return result;
    }    
   
    public int promedioConsultas(int year,int month){
        int result=0;
        if(month==0){
            result = pacienteDAO.promedioConsultas(year,01,12);
        }else{
            result = pacienteDAO.promedioConsultas(year,month,month);
        }
        return result;
    }
    
    public int promedioMedicamentos(int year,int month){
        int result=0;
        if(month==0){
            result = pacienteDAO.promedioMedicamentos(year,01,12);
        }else{
            result = pacienteDAO.promedioMedicamentos(year,month,month);
        }
        return result;
    }
}
