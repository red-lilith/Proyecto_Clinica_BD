/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Gui.*;
import javax.swing.JFrame;

/**
 *
 * @author ennuikibun
 */
public class Vista_Control {
    
    
   
    String usuarioActual;
    int idActual; 
    Vista_Control vista = this;
    LogIn login = new LogIn(vista);
    Admin_Principal admin = new Admin_Principal(vista);
    AdminUsuarios adminUsers = new AdminUsuarios(vista);
    
    
    
    General general = new General(vista);
    Agendamiento agendamiento = new Agendamiento(vista);
    Pacientes pacientes = new Pacientes(vista);
    CampanasPrevencion campanas = new CampanasPrevencion(vista);
    CambiarContrasena cambiarCont = new CambiarContrasena(vista);
    Medicamentos medicamentos = new Medicamentos(vista); 
    public Vista_Control(){
        
        usuarioActual = "";
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin.setDefaultCloseOperation(admin.EXIT_ON_CLOSE);
        adminUsers.setDefaultCloseOperation(adminUsers.EXIT_ON_CLOSE);
        general.setDefaultCloseOperation(general.EXIT_ON_CLOSE);
        agendamiento.setDefaultCloseOperation(agendamiento.EXIT_ON_CLOSE);
        pacientes.setDefaultCloseOperation(pacientes.EXIT_ON_CLOSE);
        campanas.setDefaultCloseOperation(campanas.EXIT_ON_CLOSE);
        cambiarCont.setDefaultCloseOperation(campanas.EXIT_ON_CLOSE);
        medicamentos.setDefaultCloseOperation(medicamentos.EXIT_ON_CLOSE);
    }
    
    public void setUsuario(String user){
        usuarioActual = user;
    }
    
    public String getUsuario(){
        return usuarioActual;
    }
    
     public void setIdActual(int id){
        idActual = id; 
    }
    
    public int getIdActual(){
        return idActual;
    }
    
    public void mostrarVentana(String ventana){
        if(ventana.equals("admin"))
            admin.setVisible(true);
        else if(ventana.equals("login")) //muestra la ventana de login
            login.setVisible(true);
        else if(ventana.equals("adminUsers"))
            adminUsers.setVisible(true);
        else if(ventana.equals("general"))
            general.setVisible(true);
        else if(ventana.equals("agendamiento"))
            agendamiento.setVisible(true);
        else if (ventana.equals("pacientes"))
            pacientes.setVisible(true);
        else if (ventana.equals("campanas"))
            campanas.setVisible(true);   
        else if (ventana.equals("cambiarCont"))
            cambiarCont.setVisible(true);
        else if (ventana.equals("medicamentos"))
            medicamentos.setVisible(true);
    }
}
