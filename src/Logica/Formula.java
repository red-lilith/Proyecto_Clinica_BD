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
public class Formula {
    int cod_formula;
    int id_medico;   
    
    public Formula(){}

    public void setCodigo(int cod) {
        cod_formula = cod;
    }

    public void setMedico(int id) {
        id_medico = id;
    }

    public int getCodigo() {
        return cod_formula;
    }

    public int getMedico() {
        return id_medico;
    }    
}