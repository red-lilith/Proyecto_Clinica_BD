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
public class Empleado {
    int id_empleado;
    String cargo_empleado;
    int salario_empleado;
    String email_empleado;
    int area;
    int jefe;
    String usuario_empleado;
    String contrasena_empleado;
   
    public Empleado(){}
    
    public void setId(int id){
        id_empleado = id;
    }
    
    public void setCargo(String cargo){
        cargo_empleado = cargo;
    }
    
    public void setSalario(int salario){
        salario_empleado = salario;
    }
    
    public void setEmail(String email){
        email_empleado = email;
    }
    
    public void setArea(int area){
        this.area = area;
    }

    public void setJefe(int jefe){
        this.jefe = jefe;
    }

    public void setUsuario(String usuario) {
        usuario_empleado = usuario;
    }

    public void setContrasena_empleado(String contra) {
        contrasena_empleado = contra;
    }    
    
    public int getId(){
        return id_empleado;
    }
    
    public String getCargo(){
        return cargo_empleado;
    }
    
    public int getSalario(){
        return salario_empleado;
    }
    
    public String getEmail(){
        return email_empleado;
    }  
    
    public int getArea(){
        return area;
    }  
    
    public int getJefe(){
        return jefe;
    }   
    
    public String getUsuario() {
        return usuario_empleado;
    }

    public String getContrasena() {
        return contrasena_empleado;
    }    
   
}
