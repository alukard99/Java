
package controlador;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
public class ControlFichajes {
    public void crearFichaje(String DNI){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String fechaFichaje =  LocalDateTime.now().format(dtf);
            System.out.println(fechaFichaje);
            Statement sentenciaFich = vista.principal.conexion.createStatement();
            Statement sentenciaEmpl = vista.principal.conexion.createStatement();
            ResultSet resultSetDniFichajes = sentenciaFich.executeQuery("SELECT * FROM FICHAJES WHERE DNI ='"+DNI+"' AND FECHORAFIN IS NULL");
            ResultSet resultSetDniEmpleados = sentenciaEmpl.executeQuery("SELECT DNI FROM EMPLEADOS");
            boolean existeDni=false;
            boolean existeFichaje = false;
            while(resultSetDniEmpleados.next() && existeDni==false){
                if(DNI.equals(resultSetDniEmpleados.getString(1))){ //Si encuentra un dni en EMPLEADOS igual al que ha introducido
                    existeDni=true;
                }
                
            }
            if(existeDni==false){
                JOptionPane.showMessageDialog(null, "No existe el empleado.");
            }
            else{ //Si el dni existe queremos comprobar si hay una fecha de entrada
                if(resultSetDniFichajes.next()){ //Si este rs devuelve un valor es porque hay un fichaje de entrada y no de salida.
                    Statement sentencia3 = vista.principal.conexion.createStatement();
                    sentencia3.executeQuery("UPDATE FICHAJES SET FECHORAFIN = TO_DATE('"+ fechaFichaje +"','DD/MM/YYYY HH24:MI') WHERE DNI='"+DNI+"' AND FECHORAFIN IS NULL"); //Se actualiza el registro que tiene fecha de inicio pero no de fin.
                    JOptionPane.showMessageDialog(null, "Adios!."); //Si hay un registro de entrada se añade la fecha de salida
                    existeFichaje=true;
                    vista.principal.conexion.commit();
                }
                if(existeFichaje==false){ //Si no existe el fichaje:
                    Statement sentencia2 = vista.principal.conexion.createStatement();
                    Statement ultimoIdFichaje = vista.principal.conexion.createStatement();//Hay que saber que posicion ocupa el nuevo fichaje
                    ResultSet rsUltimoIdFichaje = ultimoIdFichaje.executeQuery("SELECT MAX(IDFICHAJE) FROM FICHAJES");
                    rsUltimoIdFichaje.next();
                    int ultimoId = rsUltimoIdFichaje.getInt(1);
                    ultimoId += 1;
                    System.out.println("ins = "+"INSERT INTO FICHAJES VALUES ("+ ultimoId +", '" + DNI + "', "+fechaFichaje+", null)");
                    sentencia2.executeQuery("INSERT INTO FICHAJES VALUES ("+ ultimoId +", '" + DNI + "', TO_DATE('"+fechaFichaje+"','DD/MM/YYYY HH24:MI'), null)");
                    vista.principal.conexion.commit();
                    JOptionPane.showMessageDialog(null, "Bienvenido al trabajo.");
                }
            }
            vista.principal.conexion.commit();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sententencia." + ex);
        }
    }
    
    public int modFichaje(String modId, String modDni, String modFechaI, String modFechaF){
        try {
            Statement modFichajeStatement = vista.principal.conexion.createStatement();
            if(!modDni.isEmpty()){
                modFichajeStatement.executeUpdate("UPDATE FICHAJES SET DNI = '" + modDni +"' WHERE IDFICHAJE = " + modId);
                System.out.println("DNI modificado");
            }
            if(!modFechaF.equals("  /  /       :  ")){
                System.out.println("Fecha fin: " + modFechaF);
                modFichajeStatement.executeUpdate("UPDATE FICHAJES SET FECHORAFIN = TO_DATE('" + modFechaF +"', 'DD/MM/YYYY HH24:MI') WHERE IDFICHAJE = " + modId);
                System.out.println("Fecha fin modificado");
            }
            if(!modFechaI.equals("  /  /       :  ")){
                System.out.println("Fecha inicio: " + modFechaI);
                modFichajeStatement.executeUpdate("UPDATE FICHAJES SET FECHORAINI = TO_DATE('" + modFechaI +"', 'DD/MM/YYYY HH24:MI') WHERE IDFICHAJE = " + modId);
                System.out.println("Fecha inicio modificado");
            }
            
            vista.principal.conexion.commit();
            return 0; //Si todo se ha realizado correctamente.
        }catch (SQLDataException ex){
            System.out.println("Fecha erronea." + ex);
            return 1;
        }catch (SQLException ex) {
            System.out.println("No se pudo modificar el registro." + ex);
            return 2;
        }
        
    }
    public int modEmpleado(String modDniBuscado,String modDni, String modNombre, String modHorasMin, String modHorasN, String modHorasE){
        try {
            Statement modEmpleado = vista.principal.conexion.createStatement();
            if(modDniBuscado.isEmpty()){
                return -1;
            }
            else{
                if(!modDni.isEmpty()){
                    modEmpleado.executeUpdate("UPDATE EMPLEADOS SET DNI = '"+modDni+"' WHERE DNI = '" + modDni + "'");
                }
                if(!modNombre.isEmpty()){
                    modEmpleado.executeUpdate("UPDATE EMPLEADOS SET NOMBRE = '"+modNombre+"' WHERE DNI = '" + modDni + "'");
                }
                if(!modHorasMin.isEmpty()){
                    modEmpleado.executeUpdate("UPDATE EMPLEADOS SET HORASMIN = '"+modHorasMin+"' WHERE DNI = '" + modDni + "'");
                }
                if(!modHorasN.isEmpty()){
                    modEmpleado.executeUpdate("UPDATE EMPLEADOS SET PRECIOHORA = '"+modHorasN+"' WHERE DNI = '" + modDni + "'");
                }
                if(!modHorasE.isEmpty()){
                    modEmpleado.executeUpdate("UPDATE EMPLEADOS SET PRECIOHORAE = '"+modHorasE+"' WHERE DNI = '" + modDni + "'");
                }
                vista.principal.conexion.commit();
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar empleado." + ex);
            return -1;
        }
    }
    public int borrarFichaje(String fichajeABorrar){
        try {
            Statement borrarFichaje = vista.principal.conexion.createStatement();
            borrarFichaje.executeQuery("DELETE FICHAJES WHERE IDFICHAJE=" + fichajeABorrar);
            vista.principal.conexion.commit();
            return 0;
        } catch (SQLException ex) {
            return -1;
        }
    }
    
    public int crearFichajeGerente(String id, String nombre, String fechaI, String fechaF){
        try {
            Statement crearFichajeGerente = vista.principal.conexion.createStatement();
            crearFichajeGerente.executeQuery("INSERT INTO FICHAJES VALUES ('"+id+"', '"+nombre+"', TO_DATE('" + fechaI + "', 'DD/MM/YYYY HH:MI'), TO_DATE('" + fechaF + "', 'DD/MM/YYYY HH:MI'))");
            vista.principal.conexion.commit();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 1;
        }
    }
    
    public int crearEmpleado(String dni, String nombre, String horasMin, String horasN, String horasE){
        try {
            Statement crearEmpleado = vista.principal.conexion.createStatement();
            crearEmpleado.executeQuery("INSERT INTO EMPLEADOS VALUES('"+dni+"', '" + nombre + "', '"+ horasMin + "', '" + horasN + "', '" + horasE +"')");
            vista.principal.conexion.commit();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 1;
        }
    }
}
