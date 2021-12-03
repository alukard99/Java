/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.NewHibernateUtil;
import Modelo.Libro;
import Modelo.Persona;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {

    private static Session sesion;
    private static Transaction tx;
            
    public static void main(String[] args) {
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
       /* 
        Persona p1 = new Persona(1);
        p1.setNombre("Alex");
        
        Persona p2 = new Persona(2);
        p2.setNombre("Juan juanito juan");
        
        Libro l1 = new Libro("id1");
        l1.setTitulo("El amanecer de los vivos");
          
        Libro l2 = new Libro("id2");
        l2.setTitulo("La casa de mantequilla");
        
        Libro l3 = new Libro("id3");
        l3.setTitulo("La paja mental del macaco");
        
        p1.getLibros().add(l1);
        p1.getLibros().add(l2);
        p2.getLibros().add(l1);
        p1.getLibros().add(l3);
        
        System.out.println("Nombre persona: " + p1.getNombre());
        System.out.println("Libros: " + p1.numLibros());
        System.out.println("Nombre persona: " + p2.getNombre());
        System.out.println("Libros: " + p2.numLibros());
        
        sesion.save(p1);
        sesion.save(p2);
        
        tx.commit();
        sesion.close();
        
        
        
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        
        
        
       /* p1 = (Persona) sesion.get(Persona.class, Long.valueOf(1));
        if(p1!=null){
            System.out.println("Datos de la Base de datos:");
            System.out.println("Persona :" + p1);
            System.out.println("Número de libros: " + p1.numLibros());
            Set libros = p1.getLibros();
            for(Iterator it=libros.iterator(); it.hasNext();) {
                Libro l = (Libro) it.next();
                System.out.println("Libro " + l);
            }
        }
            p2 = (Persona) sesion.get(Persona.class, Long.valueOf(2));
        if(p2!=null){
            System.out.println("Datos de la Base de datos:");
            System.out.println("Persona :" + p2);
            System.out.println("Número de libros: " + p2.numLibros());
            Set libros = p2.getLibros();
            for(Iterator it=libros.iterator(); it.hasNext();) {
                Libro l = (Libro) it.next();
                System.out.println("Libro " + l);
            }
        }*/
       
       Session sesion = NewHibernateUtil.getSessionFactory().openSession();
       
       try{
           Criteria p = sesion.createCriteria(Persona.class);
           List<Persona> per = p.list();
           
           for(Persona pers : per){
               System.out.println(pers.getNombre());
           }
       }
       finally{
            sesion.close();
        }
       
       
       
    }
    
}
