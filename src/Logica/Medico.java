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
public class Medico {
    int id_medico;
    String especialidad_medico;
    String num_licencia_medico;
    String universidad_medico;
    
    public Medico(){}
    
    public void setId(int id){
        id_medico = id;
    }
    
    public void setEspecialidad(String especialidad){
        especialidad_medico = especialidad;
    }
    
    public void setNumLicencia(String num_licencia){
        num_licencia_medico = num_licencia;
    }
    
    public void setUniversidad(String universidad){
        universidad_medico = universidad;
    }  
    
    public int getId(){
        return id_medico;
    }
    
    public String getEspecialidad(){
        return especialidad_medico;
    }
    
    public String getNumLicencia(){
        return num_licencia_medico;
    }
    
    public String getUniversidad(){
        return universidad_medico;
    }       
}
