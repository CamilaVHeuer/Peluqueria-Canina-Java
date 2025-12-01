
package com.mycompany.peluqueriacanina.utilidadesIGU;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Utilitario para funciones comunes de interfaz gráfica
 * 
 * Esta clase proporciona métodos estáticos para validaciones de formularios,
 * mostrar mensajes y formatear texto de manera consistente en toda la
 * aplicación.
 * 
 * @author Pablo Szuban
 * @since 1.0
 */
public class UtilidadesIGU {

    /**
     * Muestra un mensaje modal con diferentes tipos (Info/Error)
     * 
     * @param parent  Componente padre para centrar el diálogo, puede ser null
     * @param mensaje Texto del mensaje a mostrar
     * @param tipo    Tipo de mensaje: "Info" o "Error"
     * @param titulo  Título de la ventana del diálogo
     */
    public static void mostrarMensaje(Component parent, String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }

        JDialog dialog;
        dialog = optionPane.createDialog(parent, titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    /**
     * Valida que los campos obligatorios no estén vacíos
     * 
     * @param parent  Componente padre para mostrar errores
     * @param campos  Array de campos de texto a validar
     * @param nombres Array con nombres de los campos (para mensajes de error)
     * @return true si todos los campos tienen contenido, false si alguno está vacío
     */
    public static boolean validarCamposObligatorios(Component parent, JTextField[] campos, String[] nombres) {
        for (int i = 0; i < campos.length; i++) {
            if (campos[i].getText().trim().isEmpty()) {
                mostrarMensaje(parent, "El campo '" + nombres[i] + "' no puede estar vacío",
                        "Error", "Campo obligatorio");
                return false;
            }
        }
        return true;
    }

    /**
     * Valida el formato de campos de texto (solo letras y espacios)
     * 
     * @param parent  Componente padre para mostrar errores
     * @param campos  Array de campos de texto a validar
     * @param nombres Array con nombres de los campos
     * @return true si todos tienen formato correcto, false si hay error
     */
    public static boolean validarFormatoTexto(Component parent, JTextField[] campos, String[] nombres) {
        String regexTexto = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";

        for (int i = 0; i < campos.length; i++) {
            if (!campos[i].getText().trim().matches(regexTexto)) {
                mostrarMensaje(parent, "El campo '" + nombres[i] + "' solo puede contener letras",
                        "Error", "Formato incorrecto");
                return false;
            }
        }
        return true;
    }

    /**
     * Valida que un campo solo contenga números
     * 
     * @param parent Componente padre para mostrar errores
     * @param campo  Campo a validar
     * @param nombre Nombre del campo para el mensaje
     * @return true si es válido, false si hay error
     */
    public static boolean validarFormatoNumerico(Component parent, JTextField campo, String nombre) {
        if (!campo.getText().trim().matches("^[0-9]+$")) {
            mostrarMensaje(parent, "El campo '" + nombre + "' solo puede contener números",
                    "Error", "Formato incorrecto");
            return false;
        }
        return true;
    }

    /**
     * Convierte texto a formato título (Primera Letra De Cada Palabra)
     * 
     * @param texto Texto a convertir, puede ser null o vacío
     * @return Texto formateado en título, o el mismo texto si es null/vacío
     */
    public static String convertirATitulo(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return texto;
        }

        StringBuilder resultado = new StringBuilder();
        String[] palabras = texto.trim().toLowerCase().split("\\s+");

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            if (!palabra.isEmpty()) {
                resultado.append(palabra.substring(0, 1).toUpperCase())
                        .append(palabra.substring(1));

                if (i < palabras.length - 1) {
                    resultado.append(" ");
                }
            }
        }
        return resultado.toString();
    }

    /**
     * Convierte texto a formato oración (Solo primera letra mayúscula)
     * 
     * @param texto Texto a convertir, puede ser null o vacío
     * @return Texto formateado como oración, o el mismo texto si es null/vacío
     */
    public static String convertirAOracion(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return texto;
        }

        String limpio = texto.trim().toLowerCase();
        return limpio.substring(0, 1).toUpperCase() + limpio.substring(1);
    }
}
