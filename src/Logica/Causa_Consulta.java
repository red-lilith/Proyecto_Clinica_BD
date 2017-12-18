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
public class Causa_Consulta {
    int codCausa;
    int serial_historia;
    int cod_registro;
    
    public Causa_Consulta(){} 

    public void setCausa(int cod) {
        codCausa = cod;
    }

    public void setHistoria(int his) {
        serial_historia = his;
    }

    public void setCodRegistro(int cod) {
        cod_registro = cod;
    }

    public int getCausa() {
        return codCausa;
    }

    public int getHistoria() {
        return serial_historia;
    }

    public int getCodRegistro() {
        return cod_registro;
    }
    
    
    
    
}
