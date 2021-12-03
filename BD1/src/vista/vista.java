/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.ControlBD;
import controlador.Fichero;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alukard
 */
public class vista extends javax.swing.JFrame {
    
    
    private Fichero f = new Fichero(); //Sirve de controlador para abrir el fichero y comprobar que los datos son correctos.
                                       //Devuelve null si no encuentra el fichero 
    private ControlBD bd1 = new ControlBD();
    private DefaultTableModel tm = new DefaultTableModel();
    
    
    public vista() {
        
        int flagBD = bd1.conectarse_A_BD(); //Devuelve el int del error en concreto.
       switch(flagBD){
           case 1:
               JOptionPane.showMessageDialog(null, "Error de conexion.");
           case 2:
               JOptionPane.showMessageDialog(null, "Error al crear la sentencia.");
           case 3:
               JOptionPane.showMessageDialog(null, "Error al ejecutar la query.");
           case 4:
               JOptionPane.showMessageDialog(null, "Error en la base de datos.");
           case 0:
                initComponents();                // o 0 si ha sido exitoso.
                rellenarTabla();
       }
        
        
    }
    private void borrarRegistro(){
        int[] filas = jTable1.getSelectedRows();
        
        if(filas.length == 1){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Borrar registro?","Borrar registro.",YES_NO_OPTION);
            
            switch(respuesta){
                case 0:
                    
            }
        }
        
    }
    
    private void rellenarTabla(){
        int i = 0;
        bd1.cogerObj();
        ArrayList<modelo.producto> al = bd1.getAL();
        tm = (DefaultTableModel) jTable1.getModel();
        jTable1.setModel(tm);
        while(i < al.size()){
        tm.addRow(new Object[]{al.get(i).getReferencia(),al.get(i).getDescripcion(),al.get(i).getPrecio(),al.get(i).getPorciva()});
        i++;
        }
        //
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referencia", "Descripcion", "Precio", "PORCIVA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonBorrar.setText("Borrar registro");
        buttonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(buttonBorrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonBorrar)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarActionPerformed
        borrarRegistro();
    }//GEN-LAST:event_buttonBorrarActionPerformed
    
    
    
    public static void main(String args[]) {
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBorrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
