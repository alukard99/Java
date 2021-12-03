/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alukard
 */
public class controlConexionBD {
    public static Connection conexion;
    private String server;
    private String port;
    private String user;
    private String passw;
    
    public controlConexionBD(String server,String port,String user,String passw){
        this.server = server;
        this.port = port;
        this.user = user;
        this.passw = passw;
    }
    
    public void setDatos(String server,String port,String user,String passw){
        this.server = server;
        this.port = port;
        this.user = user;
        this.passw = passw;
    }
    
    public Connection crearConexion(){
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+this.server+":"+this.port+":"+"xe",this.user,this.passw);
            
            return conexion;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD: " + ex);
            return null;
        }
    }
    public Connection getConexion(){
        return conexion;
    }
}

