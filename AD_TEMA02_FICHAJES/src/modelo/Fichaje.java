/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Alukard
 */
public class Fichaje {
    private int idFichaje;
    private String dni;
    private Date FecHoraIni;
    private Date FecHoraFin;

    public int getIdFichaje() {
        return idFichaje;
    }

    public void setIdFichaje(int idFichaje) {
        this.idFichaje = idFichaje;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecHoraIni() {
        return FecHoraIni;
    }

    public void setFecHoraIni(Date FecHoraIni) {
        this.FecHoraIni = FecHoraIni;
    }

    public Date getFecHoraFin() {
        return FecHoraFin;
    }

    public void setFecHoraFin(Date FecHoraFin) {
        this.FecHoraFin = FecHoraFin;
    }
    
    
    
}
