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
public class producto {
    public String referencia;
    private String descripcion;
    private double precio;
    private int porciva;

    public producto(String referencia, String descripcion, double precio, int porciva) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porciva = porciva;
    }

    public producto() {
         
    }
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPorciva() {
        return porciva;
    }

    public void setPorciva(int porciva) {
        this.porciva = porciva;
    }
    
    
}
