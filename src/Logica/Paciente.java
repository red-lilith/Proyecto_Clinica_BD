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
public class Paciente {
    int id_paciente;
    String num_ss_paciente;
    String fecha_nacim_paciente;
    String acti_econom_paciente;
    int descuento_paciente;
    
    public Paciente(){}
    
    public void setId(int id){
        id_paciente = id;
    }
    
    public void setNumSegSocial(String seg_social){
        num_ss_paciente = seg_social;
    }
    
    public void setFechaNacimiento(String fecha_nacim){
        fecha_nacim_paciente = fecha_nacim;
    }
    
    public void setActivEconomica(String act_econom){
        acti_econom_paciente = act_econom;
    } 
    
    public void setDescuento(int desc){
        descuento_paciente = desc;
    }
    
    public int getId(){
        return id_paciente;
    }
    
    public String getNumSegSocial(){
        return num_ss_paciente;
    }
    
    public String getFechaNacimiento(){
        return fecha_nacim_paciente;
    }
    
    public String getActivEconomica(){
        return acti_econom_paciente;
    } 
    
    public int getDescuento(){
        return descuento_paciente;
    } 
}
