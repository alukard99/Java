/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Alukard
 */
public class DialogGestorArticulos extends java.awt.Dialog {

    /**
     * Creates new form dialogAniadirArticulos
     */
    public DialogGestorArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        gestorArticulosAniadir = new javax.swing.JButton();
        gestorArticulosBorrar = new javax.swing.JButton();
        gestorArticulosModificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        gestorArticulosCampoDesc = new javax.swing.JTextField();
        gestorArticulosCampoReferencia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gestorArticulosCampoStock = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        gestorArticulosCampoIva = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        gestorArticulosCampoPrecio = new javax.swing.JFormattedTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        gestorArticulosAniadir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gestorArticulosAniadir.setText("Añadir");
        gestorArticulosAniadir.setFocusable(false);
        gestorArticulosAniadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestorArticulosAniadir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestorArticulosAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestorArticulosAniadirActionPerformed(evt);
            }
        });
        jToolBar1.add(gestorArticulosAniadir);

        gestorArticulosBorrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gestorArticulosBorrar.setText("Borrar");
        gestorArticulosBorrar.setFocusable(false);
        gestorArticulosBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestorArticulosBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestorArticulosBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestorArticulosBorrarActionPerformed(evt);
            }
        });
        jToolBar1.add(gestorArticulosBorrar);

        gestorArticulosModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gestorArticulosModificar.setText("Modificar");
        gestorArticulosModificar.setFocusable(false);
        gestorArticulosModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestorArticulosModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestorArticulosModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestorArticulosModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(gestorArticulosModificar);

        add(jToolBar1, java.awt.BorderLayout.NORTH);

        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Referencia");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Precio");

        jLabel4.setText("Stock");

        gestorArticulosCampoStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel5.setText("IVA");

        gestorArticulosCampoIva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        gestorArticulosCampoIva.setToolTipText("%");

        jLabel6.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gestorArticulosCampoStock)
                    .addComponent(gestorArticulosCampoReferencia)
                    .addComponent(gestorArticulosCampoDesc)
                    .addComponent(gestorArticulosCampoIva, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(gestorArticulosCampoPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gestorArticulosCampoDesc, gestorArticulosCampoIva, gestorArticulosCampoReferencia, gestorArticulosCampoStock});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gestorArticulosCampoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gestorArticulosCampoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(gestorArticulosCampoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(gestorArticulosCampoIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gestorArticulosCampoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void gestorArticulosAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestorArticulosAniadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gestorArticulosAniadirActionPerformed

    private void gestorArticulosBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestorArticulosBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gestorArticulosBorrarActionPerformed

    private void gestorArticulosModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestorArticulosModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gestorArticulosModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogGestorArticulos dialog = new DialogGestorArticulos(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gestorArticulosAniadir;
    private javax.swing.JButton gestorArticulosBorrar;
    private javax.swing.JTextField gestorArticulosCampoDesc;
    private javax.swing.JFormattedTextField gestorArticulosCampoIva;
    private javax.swing.JFormattedTextField gestorArticulosCampoPrecio;
    private javax.swing.JTextField gestorArticulosCampoReferencia;
    private javax.swing.JFormattedTextField gestorArticulosCampoStock;
    private javax.swing.JButton gestorArticulosModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
