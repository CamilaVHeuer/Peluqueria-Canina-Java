
package com.mycompany.peluqueriacanina.igu;

import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(Principal.class.getName());

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVerDatos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCargaDatos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel1.setText("Peluquería Canina");

        btnVerDatos.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnVerDatos.setText("Ver Datos");
        btnVerDatos.addActionListener(this::btnVerDatosActionPerformed);

        btnSalir.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        btnCargaDatos.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnCargaDatos.setText("Cargar Datos");
        btnCargaDatos.addActionListener(this::btnCargaDatosActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCargaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 328,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 328,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 328,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(86, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnCargaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(btnVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89,
                                        Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        jLabel2.setIcon(new javax.swing.ImageIcon(
                "/home/pabloszuban/Imágenes/Capturas de pantalla/Captura desde 2025-11-20 12-28-33.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(297, 297, 297)
                                                .addComponent(jLabel1)))
                                .addContainerGap(18, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(69, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerDatosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerDatosActionPerformed
        VerDatos pantalla = new VerDatos();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        this.dispose();
    }// GEN-LAST:event_btnVerDatosActionPerformed

    private void btnCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCargaDatosActionPerformed
        CargaDatos pantalla = new CargaDatos();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        this.dispose();
    }// GEN-LAST:event_btnCargaDatosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        // Mostrar diálogo de confirmación antes de cerrar
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas salir de la aplicación?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        // Si el usuario confirma, cerrar la aplicación
        if (confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0); // Cierra completamente la aplicación
        }
        // Si dice NO o cierra el diálogo, no hace nada (se queda en la app)

    }// GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargaDatos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
