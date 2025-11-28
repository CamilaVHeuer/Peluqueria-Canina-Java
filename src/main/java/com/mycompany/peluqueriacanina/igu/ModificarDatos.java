
package com.mycompany.peluqueriacanina.igu;

import com.mycompany.peluqueriacanina.logica.Controladora;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.logica.Duenio;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;

public class ModificarDatos extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger
                        .getLogger(ModificarDatos.class.getName());

        // declaro a controladora logica
        private Controladora control = null;

        // declaro como variable global una masco
        private Mascota masco;

        // variable para autocomlpetado
        private JPopupMenu popupSugerencias;

        // agrego en el constructor a num_cliente
        public ModificarDatos(int num_cliente) {
                control = new Controladora();
                initComponents();
                configurarAutocompletado();
                cargarDatos(num_cliente);
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
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                txtNombre = new javax.swing.JTextField();
                txtColor = new javax.swing.JTextField();
                txtRaza = new javax.swing.JTextField();
                txtCelDuenio = new javax.swing.JTextField();
                txtNomDuenio = new javax.swing.JTextField();
                jScrollPane1 = new javax.swing.JScrollPane();
                txtObservaciones = new javax.swing.JTextArea();
                cmbAlergico = new javax.swing.JComboBox<>();
                cmbAtEsp = new javax.swing.JComboBox<>();
                jLabel2 = new javax.swing.JLabel();
                btnGuardar = new javax.swing.JButton();
                btnLimpiar = new javax.swing.JButton();
                btnVolver = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
                jLabel1.setText("Modificación de Datos");

                jLabel3.setText("Nombre:");

                jLabel4.setText("Raza:");

                jLabel5.setText("Color:");

                jLabel6.setText("Alérgico");

                jLabel7.setText("Atención Especial:");

                jLabel8.setText("Nombre Dueño:");

                jLabel9.setText("Cel. Dueño:");

                jLabel10.setText("Observaciones:");

                txtObservaciones.setColumns(20);
                txtObservaciones.setRows(5);
                jScrollPane1.setViewportView(txtObservaciones);

                cmbAlergico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SI", "NO", "" }));

                cmbAtEsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SI", "NO", "" }));
                cmbAtEsp.addActionListener(this::cmbAtEspActionPerformed);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(31, 31, 31)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel5)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel9)
                                                                                                                .addComponent(jLabel8)
                                                                                                                .addComponent(jLabel10))
                                                                                                .addGap(28, 28, 28)
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(txtCelDuenio)
                                                                                                                .addComponent(jScrollPane1)
                                                                                                                .addComponent(txtNomDuenio,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                289,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addComponent(jLabel6))
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(65, 65, 65)
                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(txtNombre,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                289,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(txtColor,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                289,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(txtRaza,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                289,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(23, 23, 23)
                                                                                                                                .addComponent(cmbAlergico,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel7)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(cmbAtEsp,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(22, Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel3)
                                                                                                .addGap(35, 35, 35)
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addComponent(txtRaza,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                24,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel2Layout.createSequentialGroup()
                                                                                                                .addComponent(txtNombre,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                24,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(67, 67, 67)))
                                                                .addGap(23, 23, 23)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(txtColor,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                24,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(28, 28, 28)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(cmbAlergico,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(21, 21, 21)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(cmbAtEsp,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(36, 36, 36)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(txtNomDuenio,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                24,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel9)
                                                                                .addComponent(txtCelDuenio,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                24,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(33, 33, 33)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel10)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                88,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jLabel2.setIcon(new javax.swing.ImageIcon(
                                "/home/pabloszuban/Imágenes/Capturas de pantalla/Captura desde 2025-11-20 12-28-33.png")); // NOI18N

                btnGuardar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                btnGuardar.setIcon(new javax.swing.ImageIcon(
                                "/home/pabloszuban/Imágenes/Capturas de pantalla/Captura desde 2025-11-20 17-21-14.png")); // NOI18N
                btnGuardar.setText("Guardar Cambios");
                btnGuardar.addActionListener(this::btnGuardarActionPerformed);

                btnLimpiar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                btnLimpiar.setIcon(new javax.swing.ImageIcon(
                                "/home/pabloszuban/Imágenes/Capturas de pantalla/Captura desde 2025-11-20 17-18-53.png")); // NOI18N
                btnLimpiar.setText("Limpiar");
                btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

                btnVolver.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                btnVolver.setIcon(new javax.swing.ImageIcon(
                                "/home/pabloszuban/Imágenes/Capturas de pantalla/volver.png")); // NOI18N
                btnVolver.setText("Volver");
                btnVolver.addActionListener(this::btnVolverActionPerformed);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                93,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel2)
                                                                .addGap(49, 49, 49))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(168, 168, 168)
                                                                .addComponent(btnLimpiar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                137,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(166, 166, 166)
                                                                .addComponent(btnGuardar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                208,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(80, 80, 80)
                                                                .addComponent(btnVolver,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                123,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel1)
                                                                .addGap(262, 262, 262)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addComponent(btnVolver,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                58,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel1)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(12, 12, 12)
                                                                                                                                                .addComponent(jPanel2,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(51, 51, 51)
                                                                                                                                                .addComponent(jLabel2,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                419,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                52,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(btnLimpiar,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                58,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(btnGuardar,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                58,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(23, 23, 23)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVolverActionPerformed
                // metodo para regresar a la pantalla VerDatos
                VerDatos pantalla = new VerDatos();
                pantalla.setVisible(true);
                pantalla.setLocationRelativeTo(null);
                this.dispose();
        }// GEN-LAST:event_btnVolverActionPerformed

        private void cmbAtEspActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmbAtEspActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_cmbAtEspActionPerformed

        private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLimpiarActionPerformed
                txtNombre.setText("");
                txtRaza.setText("");
                txtColor.setText("");
                txtNomDuenio.setText("");
                txtCelDuenio.setText("");
                txtObservaciones.setText("");
                cmbAlergico.setSelectedIndex(0);
                cmbAtEsp.setSelectedIndex(0);

        }// GEN-LAST:event_btnLimpiarActionPerformed

        private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
                // Primero validar que los campos no estén vacíos
                 if (!validarCamposVacios()) {
                    return;
        }

                 // Luego validar el formato de los datos
                if (!validarFormatoTexto()) {
                    return;
                }

                 // variables auxiliares para pasar como parametros al metodo guardar(), pero lo
                // puedo hacer directo
                // Datos de la mascota (aplicando validaciones de formato)
                String nombreMasco = convertirATitulo(txtNombre.getText());
                String raza = convertirAOracion(txtRaza.getText());
                String color = convertirAOracion(txtColor.getText());
                String observaciones = txtObservaciones.getText().trim();
                String alergico = (String) cmbAlergico.getSelectedItem();
                String atEsp = (String) cmbAtEsp.getSelectedItem();

                // Datos del dueño (aplicando validaciones de formato)
                String nombreDuenio = convertirATitulo(txtNomDuenio.getText());
                String celDuenio = txtCelDuenio.getText().trim();

                // Verificar si cambió la información del dueño
                Duenio duenioOriginal = masco.getUnDuenio();

                // Preparar valores con trim para comparación segura
                String nombreOriginalTrim = duenioOriginal.getNombre() != null ? duenioOriginal.getNombre().trim() : "";
                String celularOriginalTrim = duenioOriginal.getCelDuenio() != null
                                ? duenioOriginal.getCelDuenio().trim()
                                : "";

                // Comparación más segura con validación de nulls y trim en ambos valores
                boolean cambioNombre = !Objects.equals(nombreDuenio.trim(), nombreOriginalTrim);
                boolean cambioCelular = !Objects.equals(celDuenio.trim(), celularOriginalTrim);
                boolean cambioInfo = cambioNombre || cambioCelular;

                if (cambioInfo) {
                        // Verificar si este dueño tiene más mascotas
                        int cantidadMascotas = control.contarMascotasDelDuenio(duenioOriginal.getId_duenio());

                        if (cantidadMascotas > 1) {
                                // El dueño original tiene múltiples mascotas, preguntar qué hacer
                                String mensaje = "El dueño '" + duenioOriginal.getNombre() + "' tiene "
                                                + cantidadMascotas +
                                                " mascotas registradas.\n\n" +
                                                "¿Qué desea hacer?\n\n" +
                                                "• SÍ: Crear/reemplazar un nuevo dueño solo para esta mascota\n" +
                                                "• NO: Modificar el dueño existente (afectará todas sus mascotas)";

                                int opcion = JOptionPane.showConfirmDialog(
                                                this,
                                                mensaje,
                                                "Dueño con múltiples mascotas",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.WARNING_MESSAGE);

                                if (opcion == JOptionPane.YES_OPTION) {
                                        // Usar lógica inteligente para crear/reutilizar dueño
                                        control.modificarMascotaConNuevoDuenio(masco, nombreMasco, raza, color,
                                                        observaciones, alergico, atEsp,
                                                        nombreDuenio, celDuenio);
                                        mostrarMensaje("Mascota actualizada con nuevo dueño", "Info",
                                                        "Edición Correcta");
                                } else {
                                        // Modificar el dueño existente (comportamiento original)
                                        control.modificarMascota(masco, nombreMasco, raza, color, observaciones,
                                                        alergico, atEsp, nombreDuenio, celDuenio);
                                        mostrarMensaje("Mascota y dueño actualizados (todas las mascotas del dueño afectadas)",
                                                        "Info", "Edición Correcta");
                                }
                        } else {
                                // El dueño original solo tiene esta mascota
                                // PERO necesitamos verificar si el nuevo dueño ya existe
                                control.modificarMascotaConNuevoDuenio(masco, nombreMasco, raza, color,
                                                observaciones, alergico, atEsp,
                                                nombreDuenio, celDuenio);
                                mostrarMensaje("Mascota actualizada correctamente", "Info", "Edición Correcta");
                        }
                } else {
                        // No cambió la información del dueño, solo modificar la mascota
                        control.modificarMascota(masco, nombreMasco, raza, color, observaciones,
                                        alergico, atEsp, nombreDuenio, celDuenio);
                        mostrarMensaje("Edición realizada correctamente", "Info", "Edición Correcta");
                }

                // llamo a la pantalla de ver Datos que va a tener los datos actualizados
                // (porque la cerré cuando llamé a la ventana editar)
                VerDatos pantalla = new VerDatos();
                pantalla.setVisible(true);
                pantalla.setLocationRelativeTo(null);
                // cerrar la ventana de edicion
                this.dispose();

        }// GEN-LAST:event_btnGuardarActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnGuardar;
        private javax.swing.JButton btnLimpiar;
        private javax.swing.JButton btnVolver;
        private javax.swing.JComboBox<String> cmbAlergico;
        private javax.swing.JComboBox<String> cmbAtEsp;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextField txtCelDuenio;
        private javax.swing.JTextField txtColor;
        private javax.swing.JTextField txtNomDuenio;
        private javax.swing.JTextField txtNombre;
        private javax.swing.JTextArea txtObservaciones;
        private javax.swing.JTextField txtRaza;
        // End of variables declaration//GEN-END:variables

        private void cargarDatos(int num_cliente) {
                this.masco = control.traerUnaMascota(num_cliente);
                // Seteo los datos que trae

                txtNombre.setText(masco.getNombre());
                txtRaza.setText(masco.getRaza());
                txtColor.setText(masco.getColor());
                txtNomDuenio.setText(masco.getUnDuenio().getNombre());
                txtCelDuenio.setText(masco.getUnDuenio().getCelDuenio());
                txtObservaciones.setText(masco.getObservaciones());

                if (masco.getAlergico().equals("SI")) {
                        cmbAlergico.setSelectedIndex(1);
                } else {
                        if (masco.getAlergico().equals("NO")) {
                                cmbAlergico.setSelectedIndex(2);
                        }

                }

                if (masco.getAtencion_especial().equals("SI")) {
                        cmbAtEsp.setSelectedIndex(1);
                } else {
                        if (masco.getAtencion_especial().equals("NO")) {
                                cmbAtEsp.setSelectedIndex(2);

                        }
                }

        }

        public void mostrarMensaje(String mensaje, String tipo, String titulo) {
                JOptionPane optionPane = new JOptionPane(mensaje);
                if (tipo.equals("Info")) {
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                } else {
                        if (tipo.equals("Error")) {
                                optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                        }
                }
                JDialog dialog;
                dialog = optionPane.createDialog(titulo);
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
        }

        // Métodos para validación y formato de datos
        private String convertirATitulo(String texto) {
                if (texto == null || texto.trim().isEmpty()) {
                        return texto;
                }

                StringBuilder resultado = new StringBuilder();
                String[] palabras = texto.trim().toLowerCase().split("\\s+");

                for (int i = 0; i < palabras.length; i++) {
                        String palabra = palabras[i];
                        if (!palabra.isEmpty()) {
                                // Capitalizar primera letra + resto en minúscula
                                resultado.append(palabra.substring(0, 1).toUpperCase())
                                                .append(palabra.substring(1));

                                // Agregar espacio entre palabras
                                if (i < palabras.length - 1) {
                                        resultado.append(" ");
                                }
                        }
                }

                return resultado.toString();
        }

        private String convertirAOracion(String texto) {
                if (texto == null || texto.trim().isEmpty()) {
                        return texto;
                }

                String limpio = texto.trim().toLowerCase();
                return limpio.substring(0, 1).toUpperCase() + limpio.substring(1);
        }

        private void configurarAutocompletado() {
                // Inicializar popup de sugerencias
                popupSugerencias = new JPopupMenu();

                // Agregar listener al campo de nombre del dueño
                txtNomDuenio.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                                String texto = txtNomDuenio.getText().trim();

                                // Solo mostrar sugerencias si hay al menos 2 caracteres
                                if (texto.length() >= 2) {
                                        // Usar un timer para dar tiempo a seguir escribiendo
                                        javax.swing.Timer timer = new javax.swing.Timer(500, evt -> {
                                                mostrarSugerenciasDuenios(texto);
                                        });
                                        timer.setRepeats(false);
                                        timer.start();
                                } else {
                                        popupSugerencias.setVisible(false);
                                }
                        }
                });

                // Ocultar popup cuando se pierde el foco
                txtNomDuenio.addFocusListener(new java.awt.event.FocusAdapter() {
                        @Override
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                // Delay para permitir click en sugerencias
                                javax.swing.Timer timer = new javax.swing.Timer(2500, e -> {
                                        popupSugerencias.setVisible(false);
                                });
                                timer.setRepeats(false);
                                timer.start();
                        }
                });
        }

        private void mostrarSugerenciasDuenios(String nombreParcial) {
                // Verificar que el texto actual sigue siendo el mismo (no cambió mientras
                // esperaba el timer)
                if (!nombreParcial.equals(txtNomDuenio.getText().trim())) {
                        return;
                }

                List<Duenio> sugerencias = control.buscarDueniosParaAutocompletar(nombreParcial);

                // Limpiar sugerencias anteriores
                popupSugerencias.removeAll();

                if (!sugerencias.isEmpty()) {
                        // Agregar cada sugerencia como un item del menú
                        for (Duenio duenio : sugerencias) {
                                JMenuItem item = new JMenuItem(duenio.getNombre() + " - " + duenio.getCelDuenio());

                                item.addActionListener(e -> {
                                        // Al hacer click, completar los campos
                                        txtNomDuenio.setText(duenio.getNombre());
                                        txtCelDuenio.setText(duenio.getCelDuenio());
                                        popupSugerencias.setVisible(false);

                                        // Enfocar el siguiente campo
                                        txtObservaciones.requestFocus();
                                });

                                popupSugerencias.add(item);
                        }

                        // Mostrar el popup justo debajo del campo de texto
                        popupSugerencias.show(txtNomDuenio, 0, txtNomDuenio.getHeight());
                } else {
                        popupSugerencias.setVisible(false);
                }
        }

    private boolean validarCamposVacios() {
         if (txtNombre.getText().trim().isEmpty()) {
            mostrarMensaje("El campo 'Nombre' no puede estar vacío", "Error", "Campo obligatorio");
            return false;
        }
        if (txtRaza.getText().trim().isEmpty()) {
            mostrarMensaje("El campo 'Raza' no puede estar vacío", "Error", "Campo obligatorio");
            return false;
        }
        if (txtColor.getText().trim().isEmpty()) {
            mostrarMensaje("El campo 'Color' no puede estar vacío", "Error", "Campo obligatorio");
            return false;
        }
        if (txtNomDuenio.getText().trim().isEmpty()) {
            mostrarMensaje("El campo 'Nombre Dueño' no puede estar vacío", "Error", "Campo obligatorio");
            return false;
        }
        if (txtCelDuenio.getText().trim().isEmpty()) {
            mostrarMensaje("El campo 'Celular Dueño' no puede estar vacío", "Error", "Campo obligatorio");
            return false;
        }
        return true;
    }
    

    private boolean validarFormatoTexto() {
        // Validar que nombre, raza, color y nombre dueño solo contengan letras y
        // espacios
        if (!txtNombre.getText().trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarMensaje("El campo 'Nombre' solo puede contener letras", "Error", "Formato incorrecto");
            return false;
        }
        if (!txtRaza.getText().trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarMensaje("El campo 'Raza' solo puede contener letras", "Error", "Formato incorrecto");
            return false;
        }
        if (!txtColor.getText().trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarMensaje("El campo 'Color' solo puede contener letras", "Error", "Formato incorrecto");
            return false;
        }
        if (!txtNomDuenio.getText().trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarMensaje("El campo 'Nombre Dueño' solo puede contener letras", "Error", "Formato incorrecto");
            return false;
        }

        // Validar que celular solo contenga números
        if (!txtCelDuenio.getText().trim().matches("^[0-9]+$")) {
            mostrarMensaje("El campo 'Celular Dueño' solo puede contener números", "Error", "Formato incorrecto");
            return false;
        }

        return true;
    }
}
