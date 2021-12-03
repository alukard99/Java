/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

/**
 *
 * @author Alukard
 */
public class Fichero{
    private String servidor;
    private String puerto;
    private String id;
    private String usuario;
    private String passw;
    
    
    public int accederFichero(){
        
        try{
        File f;
        f = new File("oracle.txt");
        FileReader fr = new FileReader(f);
        BufferedReader bf = new BufferedReader(fr);
        
        this.servidor = bf.readLine();
        this.puerto = bf.readLine();
        this.id = bf.readLine();
        this.usuario = bf.readLine();
        this.passw = bf.readLine();
        return 0;
        }catch(FileNotFoundException e){
            return 1;
        } catch (IOException ex) {
            return 2;
        }
    }

    public String getServidor() {
        return servidor;
    }

    public String getPuerto() {
        return puerto;
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassw() {
        return passw;
    }
    
    
}
