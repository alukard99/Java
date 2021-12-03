/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Columna;


public class controlCampos {
    private ArrayList<String> tablas = new ArrayList<>();
    private ArrayList<Columna> columnas = new ArrayList<>();
    private ResultSet rs;
    private DatabaseMetaData md;
    private String user;
    private ArrayList<Columna> columnasTabla = new ArrayList<>();
    
    
    public ArrayList<String> getArrayTablas(){ //
        try{
            tablas.clear();
            md = vista.principal.conexion.getMetaData();
            user = md.getUserName();
            rs = md.getTables(null, user, "%", null);
            while(rs.next()){
                tablas.add(rs.getString(3));
            }
            return tablas;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al recibir metadatos. Contacte con el administrador de la base de datos." + ex);
            return null;
        }
    }
    
    public ArrayList<Columna> getComboCols(String itemTabla){ 
        try {
            columnas.clear();
            //Devuelve las columnas que se pueden meter al combobox
            ResultSet rs = md.getColumns(null, null, itemTabla, null);
            while(rs.next()){
                columnas.add(new Columna(rs.getString(4), rs.getString(6)));
            }
            rs.close();
            return columnas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al reiniciar cursor: " + ex);
            return null;
        }
    }
    
    
    public ArrayList<Columna> getTableCols(String itemTabla){
        try {
            columnasTabla.clear();
            //Devuelve las columnas que se pueden meter al combobox
            ResultSet rs = md.getColumns(null, null, itemTabla, null);
            while(rs.next()){
                columnasTabla.add(new Columna(rs.getString(4), rs.getString(6)));
            }
            rs.close();
            return columnasTabla;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al recibir datos. Contacte con su administrador de confianza." + ex);
            return null;
        }
    }
    
    public void getTablaFichajes(Connection conexion){
        try {
            md = conexion.getMetaData();
            
        } catch (SQLException ex) {
            System.out.println("Error al recibir metadatos.");
        }
        
    }
    
}
