/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import modelo.Persona;
public class Db4o {

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile("personas.db4o");
        Persona p1 = new Persona("Alex", 22, 1.75, 73);
        Persona p2 = new Persona("Alba", 20, 1.65, 50);
        
        db.store(p1);
        db.store(p2);
        
        Persona p = new Persona();
        ObjectSet<Persona> result = db.queryByExample(p);
        
        System.out.println("La bd tiene: " + result.size() + " objectos dentro.");
        while(result.hasNext()){
            System.out.println(result.next());
        }
        //Cerramos la conexion:
        db.close();
    }
}
