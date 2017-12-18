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
public class Formulacion {
    
    int cod_formula;
    int cod_medicamento;
    String dosis;
    
    public Formulacion(){}

    public void setCodFormula(int cod) {
        cod_formula = cod;
    }

    public void setCodMedicamento(int cod) {
        cod_medicamento = cod;
    }

    public void setDosis(String _dosis) {
        dosis = _dosis;
    }

    public int getCodFormula() {
        return cod_formula;
    }

    public int getCodMedicamento() {
        return cod_medicamento;
    }

    public String getDosis() {
        return dosis;
    }
    
    
}
