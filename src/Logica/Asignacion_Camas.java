/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author ennuikibun
 */
public class Asignacion_Camas {
    int id_paciente;
    int cod_cama;
    String fecha_asignacion; 
    String fecha_salida; 
    
    public Asignacion_Camas(){}

    public void setPaciente(int id) {
        id_paciente = id;
    }

    public void setCama(int cod) {
        cod_cama = cod;
    }

    public void setFechaAsignacion(String fecha) {
        fecha_asignacion = fecha;
    }

    public void setFechaSalida(String fecha) {
        fecha_salida = fecha;
    }

    public int getPaciente() {
        return id_paciente;
    }

    public int getCama() {
        return cod_cama;
    }

    public String getFechaAsignacion() {
        return fecha_asignacion;
    }

    public String getFechaSalida() {
        return fecha_salida;
    }
    
    
    
    
    
    
}
