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
public class Causa {
    int cod_causa;
    String nom_causa;
    String descrip_causa;
    
    public Causa(){}
    
    public void setCodigo(int cod){
        cod_causa = cod;
    }
    
    public void setNombre(String nom){
        nom_causa = nom;
    }
    
    public void setDescripcion(String descrip){
        descrip_causa = descrip;
    }
    
    public int getCodigo(){
        return cod_causa;
    }
    
    public String getNombre(){
        return nom_causa;
    }
    
    public String getDescripcion(){
        return descrip_causa;
    }
}
