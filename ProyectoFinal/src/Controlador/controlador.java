
package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Alukard
 */
public class controlador implements ActionListener{
    private vista vista;
    private producto producto;
    public controlador(vista vista, producto producto){
        this.vista = vista;
        this.producto = producto;
        this.vista.buttonAdd.addActionListener(this);
        this.vista.buttonAdd.setActionCommand("addProduct");
}

    private void ajustarTamanio(){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        vista.setSize(width/2, height/2);
        vista.setLocationRelativeTo(null);		
        vista.setVisible(true);
        
        
    }
    public static void addProductButton(){
        vista.jDialog1.setVisible(true);
        vista.jDialog1.setLocationRelativeTo(vista);
    }
    
    
    
    public static void main(String[] args){
        
    }
}

