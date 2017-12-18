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
public class Asistencia_Campana {
    int cod_campana;
    int id_paciente;
    
    public Asistencia_Campana(){}

    public void setCampana(int cod) {
        cod_campana = cod;
    }

    public void setPaciente(int id) {
        id_paciente = id;
    }

    public int getCampana() {
        return cod_campana;
    }

    public int getPaciente() {
        return id_paciente;
    }
    
    
    
}
