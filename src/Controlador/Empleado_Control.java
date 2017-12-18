/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Acceso_Datos.EmpleadoDAO;
import Logica.Empleado;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class Empleado_Control {
    EmpleadoDAO empleadoDAO;
    
    public Empleado_Control(){
        empleadoDAO = new EmpleadoDAO();
    }
    
    public int  insertarEmpleado(int id, String cargo, int salario, String mail, int area, int jefe, String nom){
        Empleado empleado = new Empleado();        

        empleado.setId(id);
        empleado.setCargo(cargo);
        empleado.setSalario(salario);
        empleado.setEmail(mail);
        empleado.setArea(area);
        empleado.setJefe(jefe);
        
        Random generator = new Random();
        int randNum = generator.nextInt(1000) + 1;
        String user = nom + randNum;
        String pass = user;
        
        empleado.setUsuario(user);
        empleado.setContrasena_empleado(pass);
        
        int result = empleadoDAO.insertar(empleado);
        
        return result;
    }  

    public Empleado consultarEmpleado(int id){
        Empleado empleado = new Empleado();
        
        empleado = empleadoDAO.consultar(id);
      
       return empleado;
    }
    
    public int modificarEmpleado(int id, String cargo, int salario, String mail, int area, int jefe){
        Empleado empleado = new Empleado();
        empleado.setCargo(cargo);
        empleado.setSalario(salario);
        empleado.setEmail(mail);
        empleado.setArea(area);
        empleado.setJefe(jefe);
                
        int result = empleadoDAO.modificar(empleado, id);
        
        return result;
    }   
    
    public int eliminarEmpleado(int id){
        Empleado empleado = new Empleado();
        
        int result = empleadoDAO.eliminar(id);
      
        return result;
    }   
    
    public int loguearEmpleado(String user, String pass){
        
        int result = empleadoDAO.loguear(user, pass);
      
        return result;
    } 
    
    public int cambiarContrasenaEmpleado(String user, String pass){
        int result = empleadoDAO.cambiarContrasena(user, pass);
      
        return result;
    } 
    
    public Vector<Empleado> listarEmpleados(){
        Vector<Empleado> listaEmpleados = new Vector<Empleado>();
        
        listaEmpleados = empleadoDAO.listar();
        
        return listaEmpleados;
    }
   
}
