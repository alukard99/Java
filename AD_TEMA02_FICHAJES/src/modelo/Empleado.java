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
public class Empleado {
    
    private String dni;
    private String nombre;
    private int horasMin;
    private Double precioHora;
    private Double precioHoraE;

    
    public Empleado(){
        
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasMin() {
        return horasMin;
    }

    public void setHorasMin(int horasMin) {
        this.horasMin = horasMin;
    }

    public Double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Double precioHora) {
        this.precioHora = precioHora;
    }

    public Double getPrecioHoraE() {
        return precioHoraE;
    }

    public void setPrecioHoraE(Double precioHoraE) {
        this.precioHoraE = precioHoraE;
    }
    
    
    
}

