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
public class Medicamento {
    int codigo_medicamento;
    String nom_medicamento;
    String descrip_medicamento;
    int costo_medicamento;
    
    public Medicamento(){}    

    public void setCodigoMedicamento(int cod) {
        codigo_medicamento = cod;
    }

    public void setNomMedicamento(String nom) {
        nom_medicamento = nom;
    }

    public void setDescripMedicamento(String descrip) {
        descrip_medicamento = descrip;
    }

    public void setCostoMedicamento(int costo) {
        costo_medicamento = costo;
    }

    public int getCodigoMedicamento() {
        return codigo_medicamento;
    }

    public String getNomMedicamento() {
        return nom_medicamento;
    }

    public String getDescrip_medicamento() {
        return descrip_medicamento;
    }

    public int getCosto_medicamento() {
        return costo_medicamento;
    }
    
    
}
