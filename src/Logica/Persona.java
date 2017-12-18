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
public class Persona {
    int id_persona;
    String nom_persona;
    String dir_persona;
    String tel_persona;
    
    public Persona(){}
    
    public void setId(int id){
        id_persona = id;
    }
    
    public void setNombre(String nom){
        nom_persona = nom;
    }
    
    public void setDireccion(String dir){
        dir_persona = dir;
    }
    
    public void setTelefono(String tel){
        tel_persona = tel;
    }
    
    public int getId(){
        return id_persona;
    }
    
    public String getNombre(){
        return nom_persona;
    }
    
    public String getDireccion(){
        return dir_persona;
    }
    
    public String getTelefono(){
        return tel_persona;
    }
}
