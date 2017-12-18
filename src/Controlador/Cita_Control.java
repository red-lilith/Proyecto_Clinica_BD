/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.CitaDAO;
import Logica.Cita;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Cita_Control {
    CitaDAO citaDAO;
    
    public Cita_Control(){
        citaDAO = new CitaDAO();
    }
    
    public int  insertarCita(int id, String fecha, String hora, int med, int prec){
        Cita cita = new Cita();        

        cita.setPaciente(id);
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setMedico(med);
        cita.setPrecio(prec);
        
        int result = citaDAO.insertar(cita);
        
        return result;
    }    
    
    public int eliminarCita(int pac, int med, String fec, String hora){
        int result = citaDAO.eliminar(pac, med, fec, hora);
      
       return result;
    }
    
    public Vector<Cita> filtrarCitaMedico(int filtro){
        Vector <Cita> citas = new Vector<Cita>();
        
        citas = citaDAO.consultarxMedico(filtro);
      
       return citas;
    }
    
    public Vector<Cita> filtrarCitaPaciente(int filtro){
        Vector <Cita> citas = new Vector<Cita>();
        
        citas = citaDAO.consultarxPaciente(filtro);
      
       return citas;
    }
    
    public Vector<Cita> filtrarFechas(String fecha1, String Fecha2){
        Vector <Cita> citas = new Vector<Cita>();
        
        citas = citaDAO.consultarxFechas(fecha1,Fecha2);
      
       return citas;
    }
    
    public Vector<Cita> filtrarMes(String fecha1, String fecha2, int id_medico){
        Vector <Cita> citas = new Vector<Cita>();
        
        citas = citaDAO.consultarxMes(fecha1, fecha2, id_medico);
      
       return citas;
    }
    
    public Vector<Cita> listarCita(){
        Vector<Cita> citas = new Vector<Cita>();
        
        citas = citaDAO.listar();
      
       return citas;
    }
    
    public boolean validarCita(Vector<Cita> citas, String fecha, String hora){
        for(int i=0; i<citas.size();i++){
            if(citas.get(i).getFecha().equals(fecha) && citas.get(i).getHora().equals(hora))
                return false;
        }
        return true;
    }
               
}
