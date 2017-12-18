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
public class Cama {
    int num_cama;
    String estado_cama;
    String descrip_cama;
    int area;
    
    public Cama(){}
    
    public void setNumero(int num){
        num_cama = num;
    }
    
    public void setEstado(String est){
        estado_cama = est;
    }
    
    public void setDescripcion(String descrip){
        descrip_cama = descrip;
    }
    
    public void setArea(int area){
        this.area = area;
    }
    
    public int getNumero(){
        return num_cama;
    }
       
    public String getEstado(){
        return estado_cama;
    }
    
    public String getDescripcion(){
        return descrip_cama;
    }
    
    public int getArea(){
        return this.area;
    }
}
