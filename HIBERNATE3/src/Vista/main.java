/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.NewHibernateUtil;
import Modelo.Profesor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class main {

    public static void main(String[] args) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try{
            
            Criteria p = sesion.createCriteria(Profesor.class);
            List<Profesor> profe = p.list();
            
            profe.forEach((pr) -> {
                System.out.println(pr.getNombre());
            });
        }
        finally{
            sesion.close();
        }
    }
    
}
