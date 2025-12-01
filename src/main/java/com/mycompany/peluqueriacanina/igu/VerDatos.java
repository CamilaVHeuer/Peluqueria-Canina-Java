
package com.mycompany.peluqueriacanina.igu;

import com.mycompany.peluqueriacanina.logica.Controladora;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.utilidadesIGU.UtilidadesIGU;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerDatos extends javax.swing.JFrame {
        // declaro una instancia de la controladora logica
        private Controladora control = null;

        private static final java.util.logging.Logger logger = java.util.logging.Logger
                        .getLogger(VerDatos.class.getName());

        public VerDatos() {
                control = new Controladora();
                initComponents();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                tablaMascotas = new javax.swing.JTable();
                jLabel2 = new javax.swing.JLabel();
                btnEditar = new javax.swing.JButton();
                btnEliminar = new javax.swing.JButton();
                btnVolver = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowOpened(java.awt.event.WindowEvent evt) {
                                formWindowOpened(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
                jLabel1.setText("Visualización de Datos");

                jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                tablaMascotas.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                {},
                                                {},
                                                {},
                                                {}
                                },
                                new String[] {

                                }));
                jScrollPane1.setViewportView(tablaMascotas);

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                jLabel2.setText("Datos de mascotas:");

                btnEditar.setIcon(new javax.swing.ImageIcon(
                                "/home/pabloszuban/Imágenes/Capturas de pantalla/editar.png")); // NOI18N
                btnEditar.setText("Editar");
                btnEditar.addActionListener(this::btnEditarActionPerformed);

                btnEliminar.setIcon(new javax.swing.ImageIcon(
                                "/home/pabloszuban/Imágenes/Capturas de pantalla/eliminar.png")); // NOI18N
                btnEliminar.setText("Eliminar");
                btnEliminar.addActionListener(this::btnEliminarActionPerformed);

                btnVolver
                                .setIcon(new javax.swing.ImageIcon(
                                                "/home/pabloszuban/Imágenes/Capturas de pantalla/volverinicio.png")); // NOI18N
                btnVolver.setText("Volver");
                btnVolver.addActionListener(this::btnVolverActionPerformed);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addComponent(jLabel2)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                612,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                47,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(btnEliminar,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                128, Short.MAX_VALUE)
                                                                                .addComponent(btnEditar,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(btnVolver,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addComponent(jLabel2)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                525,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(18, 18, 18))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(66, 66, 66)
                                                                                                .addComponent(btnEliminar,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                56,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(36, 36, 36)
                                                                                                .addComponent(btnEditar,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                56,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(37, 37, 37)
                                                                                                .addComponent(btnVolver,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                56,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel1Layout.createSequentialGroup()
                                                                                .addContainerGap(256, Short.MAX_VALUE)
                                                                                .addComponent(jLabel1)
                                                                                .addGap(197, 197, 197))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVolverActionPerformed
                // metodo para regresar a la pantalla principal
                Principal pantalla = new Principal();
                pantalla.setVisible(true);
                pantalla.setLocationRelativeTo(null);
                this.dispose();

        }// GEN-LAST:event_btnVolverActionPerformed

        private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
                // primero veo si la tabla está vacia
                if (tablaMascotas.getRowCount() > 0) {
                        // controla que se haya seleccionado un registro
                        if (tablaMascotas.getSelectedRow() != -1) {
                                // obtengo id de la mascota a eliminar
                                int num_cliente = Integer
                                                .parseInt(String.valueOf(tablaMascotas
                                                                .getValueAt(tablaMascotas.getSelectedRow(), 0)));

                                // Obtener el nombre de la mascota para personalizar el mensaje
                                String nombreMascota = String
                                                .valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 1));

                                // Confirmacion antes de eliminar
                                int confirmacion = JOptionPane.showConfirmDialog(
                                                this,
                                                "¿Estás seguro de que deseas eliminar la mascota '" + nombreMascota
                                                                + "'?\n\n" +
                                                                "Esta acción no se puede deshacer.",
                                                "Confirmar eliminación",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.WARNING_MESSAGE);
                                // Solo eliminar si el usuario confirma
                                if (confirmacion == JOptionPane.YES_OPTION) {
                                        // llamo al método borrar
                                        control.borrarMascota(num_cliente);

                                        // aviso al usuario que borró correctamente
                                        UtilidadesIGU.mostrarMensaje(this,
                                                        "La mascota '" + nombreMascota
                                                                        + "' fue eliminada correctamente",
                                                        "Info",
                                                        "Eliminación exitosa");
                                        // vuelvo a cargar los datos en la pantalla para actualizar la info.
                                        cargarTabla();
                                }
                                // Si dice NO o cierra el diálogo, no hace nada

                        } else {
                                UtilidadesIGU.mostrarMensaje(this, "No seleccionó ninguna mascota", "Error", "Error");
                        }
                } else {
                        UtilidadesIGU.mostrarMensaje(this, "No hay ninguna mascota para eliminar", "Error",
                                        "Error al eliminar");
                }

        }// GEN-LAST:event_btnEliminarActionPerformed

        private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
                cargarTabla();
        }// GEN-LAST:event_formWindowOpened

        private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
                // controlo que la tabla no esté vacía
                if (tablaMascotas.getRowCount() > 0) {
                        // controla que se haya seleccionado un registro
                        if (tablaMascotas.getSelectedRow() != -1) {
                                // obtengo id de la mascota a editar
                                int num_cliente = Integer
                                                .parseInt(String.valueOf(tablaMascotas
                                                                .getValueAt(tablaMascotas.getSelectedRow(), 0)));
                                /// creo una instancia de ModificarDatos y la hago visible
                                ModificarDatos pantallaModif = new ModificarDatos(num_cliente);
                                pantallaModif.setVisible(true);
                                pantallaModif.setLocationRelativeTo(null);
                                // cierro ventana
                                this.dispose();

                        } else {
                                UtilidadesIGU.mostrarMensaje(this, "No seleccionó ninguna mascota", "Error", "Error");
                        }
                }

                else {
                        UtilidadesIGU.mostrarMensaje(this, "No hay ninguna mascota para editar", "Error",
                                        "Error al editar");
                }

        }// GEN-LAST:event_btnEditarActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEditar;
        private javax.swing.JButton btnEliminar;
        private javax.swing.JButton btnVolver;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tablaMascotas;
        // End of variables declaration//GEN-END:variables

        private void cargarTabla() {
                // defino el modelo que quiero que tenga la tabla
                DefaultTableModel modeloTabla = new DefaultTableModel() {
                        // hago que filas y columnas no sean editables
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                return false;
                        }

                };
                // establezco nombres de columnas, creo un vector
                String[] titulos = { "Num", "Nombre", "Color", "Raza", "Alergico", "At. Esp.", "Dueño", "Cel" };
                modeloTabla.setColumnIdentifiers(titulos);

                // carga de los datos desde la BD: llamo a la logica para que llame a la BD y lo
                // guardo en una lista
                List<Mascota> listaMascotas = control.traerMascotas();

                // recorro la lista para mostrar cada elemento en la tabla
                if (listaMascotas != null) {
                        for (Mascota masco : listaMascotas) {
                                Object[] objeto = { masco.getNum_cliente(), masco.getNombre(), masco.getColor(),
                                                masco.getRaza(),
                                                masco.getAlergico(), masco.getAtencion_especial(),
                                                masco.getUnDuenio().getNombre(),
                                                masco.getUnDuenio().getCelDuenio() };
                                // agrego el objeto como fila a la tabla
                                modeloTabla.addRow(objeto);
                        }
                }
                // asigno el modelo a la tablaMascotas
                tablaMascotas.setModel(modeloTabla);
        }
}
