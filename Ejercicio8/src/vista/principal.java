/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.util.ArrayList;
import modelo.columna;
import controlador.controlCampos;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alukard
 */
public class principal extends javax.swing.JFrame {
    private ArrayList<columna> arrayColumnasCombo;
    private ArrayList<String> arrayColumnasjTabla;
    private ArrayList<String> arrayTablas;
    private controlCampos cc = new controlCampos();
    
    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
        
        arrayTablas = cc.getArrayTablas();
        rellenarListaTablas();
        
    }
    
    public void rellenarListaTablas(){
        for(int i = 0; i<arrayTablas.size(); i++){
            listaTablas.addItem(arrayTablas.get(i));
        }
    }
    
    public void rellenarListaCols(){
        listaCol.removeAllItems();
        
        if(arrayColumnasCombo!=null){
        arrayColumnasCombo.clear();}
        String itemTabla = listaTablas.getSelectedItem().toString();
        arrayColumnasCombo = cc.getComboCols(itemTabla);
        for(int i=0; i<arrayColumnasCombo.size(); i++){
            listaCol.addItem(arrayColumnasCombo.get(i));
        } 
    }
    
    public void elegirOperador(){
        String columnaSel="";
        if(listaCol.getSelectedItem()!=null){ //Comprobamos que no este vacio (Daba error si no lo esta)
        columnaSel = listaCol.getSelectedItem().toString();}
        String tipoCol="";
        int i;
        for(i=0; i<arrayColumnasCombo.size(); i++){
            if(columnaSel.equals(arrayColumnasCombo.get(i).getNombreCol())){ //Si la columna coincide en el array.
                tipoCol = arrayColumnasCombo.get(i).getTipoCol();
            }
        }
        listaOperadores.removeAllItems();
        if("VARCHAR2".equals(tipoCol)){
            listaOperadores.addItem("LIKE");
            listaOperadores.addItem("=");
        }
        if("NUMBER".equals(tipoCol)){
            listaOperadores.addItem("<");
            listaOperadores.addItem("<=");
            listaOperadores.addItem("=");
            listaOperadores.addItem(">=");
            listaOperadores.addItem(">");
        }
        if("DATE".equals(tipoCol)){
            listaOperadores.addItem("<");
            listaOperadores.addItem("<=");
            listaOperadores.addItem("=");
            listaOperadores.addItem(">=");
            listaOperadores.addItem(">");
        }
    }
    
    public void rellenarResultado(){
        modelo.columna columnaSel;
        columnaSel = (columna) listaCol.getSelectedItem();
        String tipoColumnaSel = columnaSel.getTipoCol();
        
        if("VARCHAR2".equals(tipoColumnaSel)){
            campoResultado.setText("SELECT * FROM " + listaTablas.getSelectedItem().toString() + " WHERE " + listaCol.getSelectedItem() + " " + listaOperadores.getSelectedItem().toString() + " '%" + campoValor.getText() + "%'");
        }
        if("DATE".equals(tipoColumnaSel)){
            campoResultado.setText("SELECT * FROM " + listaTablas.getSelectedItem().toString() + " WHERE " + listaCol.getSelectedItem() + " " + listaOperadores.getSelectedItem().toString() + " " + campoValor.getText());
        
        }
        if("NUMBER".equals(tipoColumnaSel)){
            campoResultado.setText("SELECT * FROM " + listaTablas.getSelectedItem().toString() + " WHERE " + listaCol.getSelectedItem() + " " + listaOperadores.getSelectedItem().toString() + " " + campoValor.getText());
        
        }
        
    }
    
    public void ejecutarSentencia(){
        try {
            arrayColumnasjTabla = new ArrayList<>();
            Statement sentencia = dialogDatos.conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(campoResultado.getText());
            ResultSetMetaData rsmd = resultado.getMetaData();
            
            for(int i=1; i<=rsmd.getColumnCount();i++){
                arrayColumnasjTabla.add(rsmd.getColumnName(i));
            }
            
            DefaultTableModel modeloTabla = new DefaultTableModel();
            jTable1.setModel(modeloTabla);
            
            for(int i=0; i<arrayColumnasjTabla.size();i++){
                modeloTabla.addColumn(arrayColumnasjTabla.get(i));
            }
            
            Object [] fila = new Object[arrayColumnasjTabla.size()];
            while(resultado.next()){
                for(int i = 0; i < arrayColumnasjTabla.size(); i++){
                    fila[i] = resultado.getObject(i+1);
                    
                }
                modeloTabla.addRow(fila);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:"+ex+" al ejecutar la sentencia. ¿Está correctamente escrita?");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listaTablas = new javax.swing.JComboBox<>();
        listaCol = new javax.swing.JComboBox<>();
        listaOperadores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        campoResultado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tablas");

        jLabel2.setText("Operador");

        listaTablas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaTablasItemStateChanged(evt);
            }
        });

        listaCol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaColItemStateChanged(evt);
            }
        });
        listaCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaColActionPerformed(evt);
            }
        });

        listaOperadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Columnas");

        jLabel4.setText("Valor");

        campoValor.setText("1");
        campoValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoValorFocusLost(evt);
            }
        });

        jButton1.setText("Ejecutar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listaCol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listaOperadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {campoValor, listaCol, listaOperadores});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaCol)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaOperadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoValor, listaCol, listaOperadores, listaTablas});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaColActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaColActionPerformed

    private void listaTablasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaTablasItemStateChanged
        rellenarListaCols();
    }//GEN-LAST:event_listaTablasItemStateChanged

    private void listaColItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaColItemStateChanged
        if(listaCol!= null){
                elegirOperador();}
    }//GEN-LAST:event_listaColItemStateChanged

    private void campoValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoValorFocusLost
        rellenarResultado();
    }//GEN-LAST:event_campoValorFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ejecutarSentencia();
    }//GEN-LAST:event_jButton1ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoResultado;
    private javax.swing.JTextField campoValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<columna> listaCol;
    private javax.swing.JComboBox<String> listaOperadores;
    private javax.swing.JComboBox<String> listaTablas;
    // End of variables declaration//GEN-END:variables
}
