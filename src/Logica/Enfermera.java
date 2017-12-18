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
public class Enfermera {
    int id_enfermera;
    int experiencia_enfermera;
    
    public Enfermera(){}
    
    public void setId(int id){
        id_enfermera = id;
    }
    
    public void setExperiencia(int experiencia){
        experiencia_enfermera = experiencia;
    }
    
    public int getId(){
        return id_enfermera;
    }
    
    public int getExperiencia(){
        return experiencia_enfermera;
    }          
}
