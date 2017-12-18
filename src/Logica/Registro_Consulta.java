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
public class Registro_Consulta {
    int cod_consulta;
    int serial_historia;
    String fecha_consulta;
    int id_medico;
    int cod_formula_consulta;
    int precio_consulta;
    
    
    public Registro_Consulta(){}

    public void setCodConsulta(int cod) {
        cod_consulta = cod;
    }    
    
    public void setHistoria(int historia) {
        serial_historia = historia;
    }

    public void setFechaConsulta(String fecha) {
        fecha_consulta = fecha;
    }
    
    public void setMedico(int id) {
        id_medico = id;
    }
    
    public void setCodFormulaConsulta(int cod) {
        cod_formula_consulta = cod;
    }

    public void setPrecioConsulta(int precio) {
        precio_consulta = precio;
    }

    public int getCodConsulta() {
        return cod_consulta;
    }

    public int getHistoria() {
        return serial_historia;
    }

    public String getFechaConsulta() {
        return fecha_consulta;
    }
    
    public int getMedico() {
        return id_medico;
    }
    
    public int getCodFormulaConsulta() {
        return cod_formula_consulta;
    }

    public int getPrecioConsulta() {
        return precio_consulta;
    }


    
    
    
    
}
