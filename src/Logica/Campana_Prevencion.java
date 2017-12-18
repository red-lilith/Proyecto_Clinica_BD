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
public class Campana_Prevencion {
    int cod_campana;
    String nom_campana;
    String objet_campana;
    String fecha_campana;
    int id_medico_encargado;
    
    public Campana_Prevencion(){}

    public void setCodCampana(int cod) {
        cod_campana = cod;
    }

    public void setNomCampana(String nom) {
        nom_campana = nom;
    }

    public void setObjetCampana(String objetivo) {
        objet_campana = objetivo;
    }

    public void setFechaCampana(String fecha) {
        fecha_campana = fecha;
    }

    public void setMedicoEncargado(int id) {
        id_medico_encargado = id;
    }

    public int getCodCampana() {
        return cod_campana;
    }

    public String getNomCampana() {
        return nom_campana;
    }

    public String getObjetCampana() {
        return objet_campana;
    }

    public String getFechaCampana() {
        return fecha_campana;
    }

    public int getMedicoEncargado() {
        return id_medico_encargado;
    }
    
    
    
    
}
