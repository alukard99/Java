/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Prestamo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Controlador {
    private Session sesion;
    private void conectar(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
        }
        catch(HibernateException ex){
            System.out.println("xde");
        }
    }
    
    public List<Prestamo> recibirPrestamos(){
            conectar();
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            Criteria p = sesion.createCriteria(Prestamo.class);
            List<Prestamo> prest = p.list();
            return prest;
    }
    }

