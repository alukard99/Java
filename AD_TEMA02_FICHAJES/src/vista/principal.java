/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controlConexionBD;
import controlador.controlCampos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controlador.ControlFichajes;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alukard
 */
public class principal extends javax.swing.JFrame {
    private controlConexionBD cbd;
    private controlCampos cc;
    public static Connection conexion;
    ControlFichajes fichaje = new ControlFichajes();
    
    public principal() {
        
            initComponents();
            cbd = new controlConexionBD(); //Este constructor crea la conexion por defecto a AD_TEMA02_FICHAJES
            conexion = cbd.getConexion(); //Unimos la conexion que nos devuelve el constructor a la variable
        try {
            //Llenar la tabla de fichajes.
                //Sacar nombre columnas:
            ArrayList<String> arrayTablaFichajes = new ArrayList<>();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM FICHAJES");
            ResultSetMetaData rsmd = resultado.getMetaData();
            
            for(int i=1;i<=rsmd.getColumnCount();i++){
                arrayTablaFichajes.add(rsmd.getColumnName(i));
            }
            
            
            //Rellenar las filas
            
            Object [] fila = new Object[arrayTablaFichajes.size()];
            DefaultTableModel modeloTabla = new DefaultTableModel();
            tablaFichajes.setModel(modeloTabla);
            
            for(int i=0; i<arrayTablaFichajes.size();i++){
                modeloTabla.addColumn(arrayTablaFichajes.get(i));
            }
            
            while(resultado.next()){
                for(int i = 0; i<arrayTablaFichajes.size(); i++){
                    fila[i] = resultado.getObject(i+1);
                }
                modeloTabla.addRow(fila);
            }
            
            //Llenar la tabla de empleados.
                //Sacar nombre columnas:
            ArrayList<String> arrayTablaEmpleados;
            arrayTablaEmpleados = new ArrayList<>();
            Statement sentencia2 = conexion.createStatement();
            ResultSet resultado2 = sentencia2.executeQuery("SELECT * FROM EMPLEADOS");
            ResultSetMetaData rsmd2 = resultado2.getMetaData();
            
            for(int i=1;i<=rsmd2.getColumnCount();i++){
                arrayTablaEmpleados.add(rsmd2.getColumnName(i));
            }
            
            
                //Rellenar las filas.
            Object [] fila2 = new Object[arrayTablaEmpleados.size()];
            DefaultTableModel modeloTabla2 = new DefaultTableModel();
            tablaEmpleados.setModel(modeloTabla2);
            
            for(int i=0; i<arrayTablaEmpleados.size();i++){
                modeloTabla2.addColumn(arrayTablaEmpleados.get(i));
            }
            
            while(resultado2.next()){
                for(int i = 0; i<arrayTablaEmpleados.size(); i++){
                    fila2[i] = resultado2.getObject(i+1);
                }
                modeloTabla2.addRow(fila2);
            }
            
            
             //Llenar la tabla de nominas.
                //Sacar nombre columnas:
            ArrayList<String> arrayTablaNominas;
            arrayTablaNominas = new ArrayList<>();
            Statement sentencia3 = conexion.createStatement();
            ResultSet resultado3 = sentencia3.executeQuery("SELECT * FROM NOMINAS");
            ResultSetMetaData rsmd3 = resultado3.getMetaData();
            
            for(int i=1;i<=rsmd3.getColumnCount();i++){
                arrayTablaNominas.add(rsmd3.getColumnName(i));
            }
            
            
                //Rellenar las filas.
            Object [] fila3 = new Object[arrayTablaNominas.size()];
            DefaultTableModel modeloTabla3 = new DefaultTableModel();
            tablaNominas.setModel(modeloTabla3);
            
            for(int i=0; i<arrayTablaNominas.size();i++){
                modeloTabla3.addColumn(arrayTablaNominas.get(i));
            }
            
            while(resultado3.next()){
                for(int i = 0; i<arrayTablaNominas.size(); i++){
                    fila3[i] = resultado3.getObject(i+1);
                }
                modeloTabla3.addRow(fila3);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR al leer una tabla. Comprueba la base de datos.." + ex);
        }
        
        
    }
    
    public void fichar(){
        ControlFichajes fichar = new ControlFichajes();
        fichar.crearFichaje(campoDniEmpleado.getText());
    }
    public void modificarFichaje(){
        ControlFichajes modFichaje = new ControlFichajes();
        switch(modFichaje.modFichaje(modificarCampoId.getText(),modificarCampoDni.getText(), modificarCampoFechaI.getText(), modificarCampoFechaF.getText())){
            case 0: JOptionPane.showMessageDialog(null, "Fichaje modificado."); break;
            case 1: JOptionPane.showMessageDialog(null, "Fecha incorrecta."); break;
            case 2: JOptionPane.showMessageDialog(null, "No se pudo modificar el registro."); break;
        }
    }
    
    public void modificarEmpleado(){
        ControlFichajes modFichaje = new ControlFichajes();
        switch(modFichaje.modEmpleado(modificarEmpleadoDniABuscar.getText() ,modificarEmpleadoDni.getText(), modificarEmpleadoNombre.getText(),modificarEmpleadoHorasMin.getText(), modificarEmpleadoHoraN.getText(), modificarEmpleadoHoraE.getText())){
            case 0: JOptionPane.showMessageDialog(null, "Error al modificar empleado."); break;
            case 1: JOptionPane.showMessageDialog(null, "Modificado correctamente."); break;
        }
        
    }
    
    public void borrarFichaje(){
        ControlFichajes borrarFichaje = new ControlFichajes();
        
        switch(borrarFichaje.borrarFichaje(modificarCampoId.getText())){
            case 0: JOptionPane.showMessageDialog(null, "Fichaje borrado correctamente."); break;
            case 1: JOptionPane.showMessageDialog(null, "Error al borrar. Comprueba datos.");
        }
    }
    
    private void crearFichaje(){
        ControlFichajes crearFichaje = new ControlFichajes();
        switch(crearFichaje.crearFichajeGerente(modificarCampoId.getText(), modificarCampoDni.getText(), modificarCampoFechaI.getText(), modificarCampoFechaF.getText())){
            case 0: JOptionPane.showMessageDialog(null, "Fichaje creado.");
            break;
            case 1: JOptionPane.showMessageDialog(null, "Error al crear fichaje.");
            break;
        }
    }
    
    private void crearEmpleado(){
        ControlFichajes crearEmpleado = new ControlFichajes();
        switch(crearEmpleado.crearEmpleado(modificarEmpleadoDni.getText(), modificarEmpleadoNombre.getText(), modificarEmpleadoHorasMin.getText(),modificarEmpleadoHoraN.getText(), modificarEmpleadoHoraE.getText())){
            case 0: JOptionPane.showMessageDialog(null, "Empleado creado."); break;
            case 1: JOptionPane.showMessageDialog(null, "Error al crear empleado."); break;
        }
    }
    
    private void generarNomina(){
        try {
            CallableStatement cst = conexion.prepareCall("{call PR_CREARNOMINAS (?,?)}"); //Se pasan como parametros el mes y el año
            cst.setInt(1, Integer.parseInt(campoMesNomina.getText()));
            cst.setInt(2, Integer.parseInt(campoAnioNomina.getText()));
            cst.execute();
            vista.principal.conexion.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la nomina: " + ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pestañasModo = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        botonFichar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoDniEmpleado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        tabbedGerente = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFichajes = new javax.swing.JTable();
        buttonRecargarFichajes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        modificarCampoId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        modificarCampoDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        modificarCampoFechaI = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        modificarCampoFechaF = new javax.swing.JFormattedTextField();
        buttonCrearFichaje = new javax.swing.JButton();
        botonModFichaje = new javax.swing.JButton();
        buttonBorrarFichaje = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        modificarEmpleadoDniABuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        modificarEmpleadoDni = new javax.swing.JTextField();
        modificarEmpleadoNombre = new javax.swing.JTextField();
        modificarEmpleadoHorasMin = new javax.swing.JTextField();
        modificarEmpleadoHoraN = new javax.swing.JTextField();
        modificarEmpleadoHoraE = new javax.swing.JTextField();
        buttonCrearEmpleado = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buttonRefrescarEmpleados = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaNominas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        buttonGenerarNomina = new javax.swing.JButton();
        buttonRefrescarNominas = new javax.swing.JButton();
        campoMesNomina = new javax.swing.JFormattedTextField();
        campoAnioNomina = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pestañasModo.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        pestañasModo.setToolTipText("Elige entre empleado y gerente");
        pestañasModo.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N

        botonFichar.setText("Fichar");
        botonFichar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFicharActionPerformed(evt);
            }
        });

        jLabel3.setText("DNI");

        campoDniEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDniEmpleadoActionPerformed(evt);
            }
        });
        campoDniEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDniEmpleadoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(campoDniEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonFichar)
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoDniEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonFichar))
                .addContainerGap(340, Short.MAX_VALUE))
        );

        pestañasModo.addTab("Empleado", jPanel1);

        tablaFichajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaFichajes);

        buttonRecargarFichajes.setText("Recargar");
        buttonRecargarFichajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecargarFichajesActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Fichaje");

        modificarCampoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarCampoIdActionPerformed(evt);
            }
        });

        jLabel5.setText("DNI");

        modificarCampoDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarCampoDniActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha inicio");

        try {
            modificarCampoFechaI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Fecha fin");

        try {
            modificarCampoFechaF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buttonCrearFichaje.setText("Crear");
        buttonCrearFichaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearFichajeActionPerformed(evt);
            }
        });

        botonModFichaje.setText("Modificar");
        botonModFichaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModFichajeActionPerformed(evt);
            }
        });

        buttonBorrarFichaje.setText("Borrar");
        buttonBorrarFichaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarFichajeActionPerformed(evt);
            }
        });

        jLabel8.setText("dd/mm/aaaa hh:mm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modificarCampoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modificarCampoId, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(modificarCampoFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarCampoFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botonModFichaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBorrarFichaje))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(buttonCrearFichaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRecargarFichajes)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {modificarCampoDni, modificarCampoId});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {modificarCampoFechaF, modificarCampoFechaI});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel7});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonModFichaje, buttonBorrarFichaje, buttonCrearFichaje, buttonRecargarFichajes});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(modificarCampoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(modificarCampoFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCrearFichaje)
                            .addComponent(buttonRecargarFichajes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(modificarCampoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(modificarCampoFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonModFichaje)
                            .addComponent(buttonBorrarFichaje))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(67, 67, 67))))
        );

        tabbedGerente.addTab("Fichajes", jPanel4);

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaEmpleados);

        jLabel15.setText("DNI del empleado a modificar:");

        jLabel10.setText("DNI");

        jLabel11.setText("Nombre");

        jLabel12.setText("Horas minimas");

        jLabel13.setText("Precio hora normal");

        jLabel14.setText("Precio hora extra");

        modificarEmpleadoDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEmpleadoDniActionPerformed(evt);
            }
        });

        buttonCrearEmpleado.setText("Crear");
        buttonCrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearEmpleadoActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Borrar");

        buttonRefrescarEmpleados.setText("Refrescar");
        buttonRefrescarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefrescarEmpleadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarEmpleadoDni, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarEmpleadoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarEmpleadoDniABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(modificarEmpleadoHoraN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modificarEmpleadoHorasMin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(modificarEmpleadoHoraE, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonCrearEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRefrescarEmpleados)))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel14});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(buttonRefrescarEmpleados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(buttonCrearEmpleado)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(modificarEmpleadoDniABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificarEmpleadoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(modificarEmpleadoHoraN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(modificarEmpleadoHorasMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificarEmpleadoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(modificarEmpleadoHoraE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        tabbedGerente.addTab("Empleados", jPanel5);

        tablaNominas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaNominas);

        jLabel2.setText("del");

        buttonGenerarNomina.setText("Generar nomina");
        buttonGenerarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerarNominaActionPerformed(evt);
            }
        });

        buttonRefrescarNominas.setText("Refrescar");
        buttonRefrescarNominas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefrescarNominasActionPerformed(evt);
            }
        });

        try {
            campoMesNomina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoAnioNomina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campoMesNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoAnioNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonGenerarNomina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRefrescarNominas)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buttonRefrescarNominas)
                    .addComponent(campoMesNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAnioNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGenerarNomina)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        tabbedGerente.addTab("Nominas", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedGerente)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedGerente, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pestañasModo.addTab("Gerente", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestañasModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestañasModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonFicharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFicharActionPerformed
        fichaje.crearFichaje(campoDniEmpleado.getText());
    }//GEN-LAST:event_botonFicharActionPerformed

    private void buttonCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearEmpleadoActionPerformed
        crearEmpleado();
    }//GEN-LAST:event_buttonCrearEmpleadoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modificarEmpleado();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void modificarEmpleadoDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEmpleadoDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarEmpleadoDniActionPerformed

    private void buttonCrearFichajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearFichajeActionPerformed
        crearFichaje();
    }//GEN-LAST:event_buttonCrearFichajeActionPerformed

    private void buttonBorrarFichajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarFichajeActionPerformed
        borrarFichaje();
    }//GEN-LAST:event_buttonBorrarFichajeActionPerformed

    private void botonModFichajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModFichajeActionPerformed
        modificarFichaje();
    }//GEN-LAST:event_botonModFichajeActionPerformed

    private void modificarCampoDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarCampoDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarCampoDniActionPerformed

    private void modificarCampoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarCampoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarCampoIdActionPerformed

    private void campoDniEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDniEmpleadoActionPerformed
        
    }//GEN-LAST:event_campoDniEmpleadoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.print("Error al cerrar la conexion.");
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonRecargarFichajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecargarFichajesActionPerformed
        try {
            //Llenar la tabla de fichajes.
                //Sacar nombre columnas:
            ArrayList<String> arrayTablaFichajes = new ArrayList<>();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM FICHAJES");
            ResultSetMetaData rsmd = resultado.getMetaData();
            
            for(int i=1;i<=rsmd.getColumnCount();i++){
                arrayTablaFichajes.add(rsmd.getColumnName(i));
            }
            
            
            //Rellenar las filas
            
            Object [] fila = new Object[arrayTablaFichajes.size()];
            DefaultTableModel modeloTabla = new DefaultTableModel();
            tablaFichajes.setModel(modeloTabla);
            
            for(int i=0; i<arrayTablaFichajes.size();i++){
                modeloTabla.addColumn(arrayTablaFichajes.get(i));
            }
            
            while(resultado.next()){
                for(int i = 0; i<arrayTablaFichajes.size(); i++){
                    fila[i] = resultado.getObject(i+1);
                }
                modeloTabla.addRow(fila);
            }
        }
        catch (SQLException ex) {
            System.out.println("ERROR al leer la tabla Fichajes." + ex);
        }
    }//GEN-LAST:event_buttonRecargarFichajesActionPerformed

    private void buttonGenerarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerarNominaActionPerformed
        generarNomina();
    }//GEN-LAST:event_buttonGenerarNominaActionPerformed

    private void buttonRefrescarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefrescarEmpleadosActionPerformed
        try{
            ArrayList<String> arrayTablaEmpleados;
            arrayTablaEmpleados = new ArrayList<>();
            Statement sentencia2 = conexion.createStatement();
            ResultSet resultado2 = sentencia2.executeQuery("SELECT * FROM EMPLEADOS");
            ResultSetMetaData rsmd2 = resultado2.getMetaData();
            
            for(int i=1;i<=rsmd2.getColumnCount();i++){
                arrayTablaEmpleados.add(rsmd2.getColumnName(i));
            }
            
            
                //Rellenar las filas.
            Object [] fila2 = new Object[arrayTablaEmpleados.size()];
            DefaultTableModel modeloTabla2 = new DefaultTableModel();
            tablaEmpleados.setModel(modeloTabla2);
            
            for(int i=0; i<arrayTablaEmpleados.size();i++){
                modeloTabla2.addColumn(arrayTablaEmpleados.get(i));
            }
            
            while(resultado2.next()){
                for(int i = 0; i<arrayTablaEmpleados.size(); i++){
                    fila2[i] = resultado2.getObject(i+1);
                }
                modeloTabla2.addRow(fila2);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR al leer la tabla Fichajes." + ex);
        }
    }//GEN-LAST:event_buttonRefrescarEmpleadosActionPerformed

    private void buttonRefrescarNominasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefrescarNominasActionPerformed
        try{
            ArrayList<String> arrayTablaNominas;
            arrayTablaNominas = new ArrayList<>();
            Statement sentencia3 = conexion.createStatement();
            ResultSet resultado3 = sentencia3.executeQuery("SELECT * FROM NOMINAS");
            ResultSetMetaData rsmd3 = resultado3.getMetaData();
            
            for(int i=1;i<=rsmd3.getColumnCount();i++){
                arrayTablaNominas.add(rsmd3.getColumnName(i));
            }
            
            
                //Rellenar las filas.
            Object [] fila3 = new Object[arrayTablaNominas.size()];
            DefaultTableModel modeloTabla3 = new DefaultTableModel();
            tablaNominas.setModel(modeloTabla3);
            
            for(int i=0; i<arrayTablaNominas.size();i++){
                modeloTabla3.addColumn(arrayTablaNominas.get(i));
            }
            
            while(resultado3.next()){
                for(int i = 0; i<arrayTablaNominas.size(); i++){
                    fila3[i] = resultado3.getObject(i+1);
                }
                modeloTabla3.addRow(fila3);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR al leer una tabla. Comprueba la base de datos.." + ex);
        }
    }//GEN-LAST:event_buttonRefrescarNominasActionPerformed

    private void campoDniEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDniEmpleadoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                fichar(); //Método que tienes que crearte
            }
    }//GEN-LAST:event_campoDniEmpleadoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonFichar;
    private javax.swing.JButton botonModFichaje;
    private javax.swing.JButton buttonBorrarFichaje;
    private javax.swing.JButton buttonCrearEmpleado;
    private javax.swing.JButton buttonCrearFichaje;
    private javax.swing.JButton buttonGenerarNomina;
    private javax.swing.JButton buttonRecargarFichajes;
    private javax.swing.JButton buttonRefrescarEmpleados;
    private javax.swing.JButton buttonRefrescarNominas;
    private javax.swing.JFormattedTextField campoAnioNomina;
    private javax.swing.JTextField campoDniEmpleado;
    private javax.swing.JFormattedTextField campoMesNomina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField modificarCampoDni;
    private javax.swing.JFormattedTextField modificarCampoFechaF;
    private javax.swing.JFormattedTextField modificarCampoFechaI;
    private javax.swing.JTextField modificarCampoId;
    private javax.swing.JTextField modificarEmpleadoDni;
    private javax.swing.JTextField modificarEmpleadoDniABuscar;
    private javax.swing.JTextField modificarEmpleadoHoraE;
    private javax.swing.JTextField modificarEmpleadoHoraN;
    private javax.swing.JTextField modificarEmpleadoHorasMin;
    private javax.swing.JTextField modificarEmpleadoNombre;
    private javax.swing.JTabbedPane pestañasModo;
    private javax.swing.JTabbedPane tabbedGerente;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaFichajes;
    private javax.swing.JTable tablaNominas;
    // End of variables declaration//GEN-END:variables
}
