/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.Date;
/**
 *
 * @author ennuikibun
 */
public class Historia_Clinica {
    int serial_historia;
    int id_paciente;
    String fecha_apert_historia;
    
    public Historia_Clinica(){}
    
    public void setSerial(int serial){
        serial_historia = serial;
    }
    
    public void setPaciente(int id){
        id_paciente = id;
    }
    
    public void setFechaApertura(String fecha_apert){
        fecha_apert_historia = fecha_apert;
    }
    
    public int getSerial(){
        return serial_historia;
    }
    
    public int getPaciente(){
        return id_paciente;
    }
    
    public String getFechaApertura(){
        return fecha_apert_historia;
    }          
}
