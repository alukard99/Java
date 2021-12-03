/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import modelo.FormaPago;
import modelo.Prestamo;
import modelo.Recibo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

public class Controlador {
    private Session sesion;
    private void conectar(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession(); //Conecta con la base de datos.
        }
        catch(HibernateException ex){
            System.out.println("Error al conectar"); 
        }
    }
    
    public List<Prestamo> recibirPrestamos(){ //Recibe los prestamos de la BD para meterlos en la tabla mas tarde
            try{ 
            conectar();
            Criteria p = sesion.createCriteria(Prestamo.class);  
            List<Prestamo> prest = p.list();
            return prest;
            }
            finally{
                sesion.close();
            }
    }
    
    public List<FormaPago> listarComboBox(){ //Rellena el comboBox con las formas de pago de la tabla Formas_Pago
        try{
        String sentenciaQuery = "FROM FormaPago";
        conectar();
        Query query = sesion.createQuery(sentenciaQuery);
        List<FormaPago> lista = query.list();
        return lista;
        }
        finally{
            sesion.close();
        }   
    }
    
    public void borrarRegistro(Prestamo prestamoABorrar){ //Borra un registro de la tabla de prestamos
        try{
            conectar();
            sesion.beginTransaction();
            sesion.delete(prestamoABorrar);
            sesion.getTransaction().commit();
        }
        finally{
            sesion.close();
        }
    }
    
    public int generarRegistro(Prestamo prestamo){ //Guarda un prestamo en la base de datos.
        conectar();
        try{
        sesion.beginTransaction();
        sesion.save(prestamo);
        sesion.getTransaction().commit();
        } catch(ConstraintViolationException ex){
            sesion.close();
            return 1;                               //Devuelve -1 si ya existe un prestamo con el mismo ID
        }
        
        finally{
           if(sesion.isOpen()){
                sesion.close();
        }}
        return 0;                                   //Devuelve 0 si no existe ningun prestamo con el mismo ID
    }
    
    public void actualizarPrestamo(Prestamo prestamo){ //Modifica un prestamo con los datos de los campos de la izquierda, exceptuando el ID
        try{
            if(!sesion.isOpen()){
                conectar();
                sesion.beginTransaction();   
            }
                sesion.update(prestamo);
                sesion.getTransaction().commit();
        }
        finally{
            if(sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public void pagarRecibo(Recibo recibo){                                         //Pone la fecha de pago de un recibo a la actual
        conectar();
        try{
            Date fechaPago = new Date(System.currentTimeMillis());
            recibo.setFechaPagado(fechaPago);
            sesion.beginTransaction();
            sesion.update(recibo);
            sesion.getTransaction().commit();
        }
        finally{
            sesion.close();
        }
    }
    
    public void sumarImporte(Recibo reciboPagado){                                  //Se suma el importe pagado del recibo al actual 
        Prestamo prestamoASumar = reciboPagado.getPrestamo();
        
        BigDecimal suma = prestamoASumar.getImportePagado().add(reciboPagado.getImporte());
        prestamoASumar.setImportePagado(suma);
        conectar();
        try{
            sesion.beginTransaction();
            sesion.update(prestamoASumar);
            sesion.getTransaction().commit();
        }
        finally{
            sesion.close();
        }
        
        
    }
    
    public boolean comprobarTodoPagado(Prestamo prestamo){ //Si se han pagado todos los recibos se iguala el importe pagado al importe
        Set<Recibo> recibosPagados = prestamo.getRecibos(); //Cogemos los recibos                           
        for(Recibo re : recibosPagados) {
            if(re.getFechaPagado() == null){
                return false; //False si encuentra un recibo pagado
            }
        }
        return true;
    }
    
    }


