/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alukard
 */
public class Columna {
    private String nombreCol;
    private String tipoCol;

    public Columna(String nombreCol, String tipoCol){
        this.nombreCol = nombreCol;
        this.tipoCol = tipoCol;
    }

    @Override
    public String toString() {
        return nombreCol;
    }
    
    public String getNombreCol() {
        return nombreCol;
    }

    public void setNombreCol(String nombreCol) {
        this.nombreCol = nombreCol;
    }

    public String getTipoCol() {
        return tipoCol;
    }

    public void setTipoCol(String tipoCol) {
        this.tipoCol = tipoCol;
    }
}


