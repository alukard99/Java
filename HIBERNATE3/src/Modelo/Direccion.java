package Modelo;
// Generated 17-nov-2021 18:19:02 by Hibernate Tools 4.3.1



/**
 * Direccion generated by hbm2java
 */
public class Direccion  implements java.io.Serializable {


     private long id;
     private String calle;

    public Direccion() {
    }

	
    public Direccion(long id) {
        this.id = id;
    }
    public Direccion(long id, String calle) {
       this.id = id;
       this.calle = calle;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }




}


