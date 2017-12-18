/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
/**
 *
 * @author ennuikibun
 */
public class Cita {
    int id_paciente;
    String fecha_cita;
    String hora_cita;
    int id_medico;
    int precio_cita;
    
    public Cita(){}
    
    public void setPaciente(int id){
        id_paciente = id;
    }
    
    public void setFecha(String fecha){
        fecha_cita = fecha;
    }
    
    public void setHora(String hora){
        hora_cita = hora;
    }
    
    public void setMedico(int id){
        id_medico = id;
    }
    
    public void setPrecio(int precio) {
        precio_cita = precio;
    }    
    
    public int getPaciente(){
        return id_paciente;
    }
    
    public String getFecha(){
        return fecha_cita;
    }
    
    public String getHora(){
        return hora_cita;
    }
    
    public int getMedico(){
        return id_medico;
    }  

    public int getPrecio() {
        return precio_cita;
    }
    
    
}
