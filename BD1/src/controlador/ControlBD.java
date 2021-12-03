package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.producto;


/**
 *
 * @author Alukard
 */
public class ControlBD {
    private int lonArray = 0;
    private ArrayList<modelo.producto> al = new ArrayList();
    private Statement st;
    private ResultSet resultado;
    private producto producto;
    private Fichero f;
    private Connection con;
    private String servidor;
    private String puerto;
    private String id;
    private String usuario;
    private String passw;
    
    public ArrayList<modelo.producto> getAL(){
        return this.al;
    }
    
    
    
    public int conectarse_A_BD(){
        try {
            f = new Fichero();
            int i = f.accederFichero();
            servidor = f.getServidor();
            puerto = f.getPuerto();
            id = f.getId();
            usuario = f.getUsuario();
            passw = f.getPassw();
            this.con = DriverManager.getConnection("jdbc:oracle:thin:@"+this.servidor+":"+this.puerto+":"+this.id,this.usuario,this.passw);
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex);
            return 1;
        }
        return 0;
    }
    
    public int cogerObj(){ //Devuelve un array de Objectos
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear la sentencia: " + ex);
            return 2;
        }
        
        try {
            resultado = st.executeQuery("Select * from articulos");
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la query: " + ex);
            return 3;
        }

        try {
            while(resultado.next()){
                producto = new producto();
                producto.setReferencia(resultado.getString(1)); //Referencia
                producto.setDescripcion(resultado.getString(2)); //Descripcion
                producto.setPrecio(resultado.getDouble(3)); //Precio
                producto.setPorciva(resultado.getInt(4)); //PorcentajeIVA
                System.out.println(producto.getReferencia() + " " + producto.getDescripcion() + " " + producto.getPrecio() + " " + producto.getPorciva());
                al.add(lonArray, producto);
                lonArray++;
            }
        } catch (SQLException ex) {
            System.out.println("Error de base de datos: " + ex);
            return 4;
        }
        return 0;
        }
    
    
    }

