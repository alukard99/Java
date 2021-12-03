
package Modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Nava Anlage
 */
public class producto {
    private int id;
    private String tipo;
    private Double precio;
    private String descripcion;
    private LocalDate fechaSalida;
    private LocalDate antiguedad;
    private LocalDate fechaActual;
    
    public producto(int id, String tipo, Double precio, String descripcion, String fechaSalida) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fechaSalida = LocalDate.parse(fechaSalida);
        fechaActual = LocalDate.parse(LocalDateTime.now().toString(),DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    //Para sacar la antigüedad del producto queremos sacar la fecha de salida de este y restarsela al dia de hoy, lo que devuelve la cantidad de tiempo que ha pasado desde que salió
    public void calcAntiguedad(){
        Period tiempoPasado = Period.between(fechaSalida, fechaActual);
    }
}
