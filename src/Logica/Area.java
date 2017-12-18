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
public class Area {
    int cod_area;
    String nom_area;
    String descrip_area;
    
    public Area(){}
    
    public void setCodigo(int cod){
        cod_area = cod;
    }
    
    public void setNombre(String nom){
        nom_area = nom;
    }
    
    public void setDescripcion(String descrip){
        descrip_area = descrip;
    }
    
    public int getCodigo(){
        return cod_area;
    }
    
    public String getNombre(){
        return nom_area;
    }
    
    public String getDescripcion(){
        return descrip_area;
    }
}
