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
public class Habilidades_Enfermera {
    int id_enfermera;
    String habilidad;
    
    public Habilidades_Enfermera(){}
    
    public void setId(int id){
        id_enfermera = id;
    }
    
    public void setHabilidad(String habilidad){
        this.habilidad = habilidad;
    }
    
    public int getId(){
        return id_enfermera;
    }
    
    public String getHabilidad(){
        return this.habilidad;
    }    
}
