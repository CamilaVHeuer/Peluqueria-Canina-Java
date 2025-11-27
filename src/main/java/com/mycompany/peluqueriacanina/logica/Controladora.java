
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    // instancio la controladora de persistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String nombreDuenio,
            String celDuenio, String alergico, String atEsp) {
        // 1. BUSCAR SI YA EXISTE EL DUEÑO (evitar duplicados)
        List<Duenio> duenosExistentes = controlPersis.buscarDuenioPorNombreYCelular(nombreDuenio, celDuenio);

        Duenio duenio;
        if (!duenosExistentes.isEmpty()) {
            // Si ya existe, usar el existente
            duenio = duenosExistentes.get(0);
            System.out.println("Dueño encontrado: " + duenio.getNombre() + " (ID: " + duenio.getId_duenio() + ")");
        } else {
            // Si no existe, crear uno nuevo
            duenio = new Duenio();
            duenio.setNombre(nombreDuenio);
            duenio.setCelDuenio(celDuenio);
            System.out.println("Creando nuevo dueño: " + nombreDuenio);
        }

        // 2. CREAR LA MASCOTA
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);

        // 3. GUARDAR (solo crea dueño nuevo si no existía)
        if (duenosExistentes.isEmpty()) {
            controlPersis.guardar(duenio, masco);
        } else {
            // Solo guarda la mascota, el dueño ya existe
            controlPersis.guardarSoloMascota(masco);
        }
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();

    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerUnaMascota(int num_cliente) {
        return controlPersis.traerUnaMascota(num_cliente);

    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones,
            String alergico, String atEsp, String nombreDuenio, String celDuenio) {
        // al masco viejo que me llega le setteo los nuevos parametros que llegan con
        // el.
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);

        // modifico mascota
        controlPersis.modificarMascota(masco);

        // para el dueño:
        // primero lo identifico, y para ello instancio un dueño que va a llamar a un
        // metodo de bsuqueda en esta controladora
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());

        // seteo al dueño sus valores nuevos
        dueno.setNombre(nombreDuenio);
        dueno.setCelDuenio(celDuenio);

        // llamo a modificar Dueño
        this.modificarDuenio(dueno);

    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }

    // Métodos de búsqueda para la interfaz
    public List<Duenio> buscarDueniosPorNombre(String nombre) {
        return controlPersis.buscarDuenioPorNombre(nombre);
    }

    public List<Duenio> buscarDueniosParaAutocompletar(String nombreParcial) {
        return controlPersis.buscarDueniosParaAutocompletar(nombreParcial);
    }

    public List<Duenio> verificarDuenioExistente(String nombre, String celular) {
        return controlPersis.buscarDuenioPorNombreYCelular(nombre, celular);
    }

    // Método para contar mascotas de un dueño
    public int contarMascotasDelDuenio(int id_duenio) {
        return controlPersis.contarMascotasPorDuenio(id_duenio);
    }

    // Método para crear un nuevo dueño y asignarlo a una mascota
    public void modificarMascotaConNuevoDuenio(Mascota masco, String nombreMasco, String raza, String color,
            String observaciones, String alergico, String atEsp, String nombreDuenio, String celDuenio) {

        // Modificar datos de la mascota
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);

        // VERIFICAR SI YA EXISTE UN DUEÑO CON ESE NOMBRE Y CELULAR
        List<Duenio> duenosExistentes = controlPersis.buscarDuenioPorNombreYCelular(nombreDuenio, celDuenio);

        Duenio duenioParaAsignar;
        if (!duenosExistentes.isEmpty()) {
            // Ya existe un dueño con esos datos, usar el existente
            duenioParaAsignar = duenosExistentes.get(0);
            System.out.println("REUTILIZANDO dueño existente: " + duenioParaAsignar.getNombre() + " (ID: "
                    + duenioParaAsignar.getId_duenio() + ")");
        } else {
            // No existe, crear un nuevo dueño
            duenioParaAsignar = new Duenio();
            duenioParaAsignar.setNombre(nombreDuenio);
            duenioParaAsignar.setCelDuenio(celDuenio);
            System.out.println("CREANDO nuevo dueño: " + nombreDuenio);
        }

        // Asignar el dueño a la mascota
        masco.setUnDuenio(duenioParaAsignar);

        // Guardar según corresponda
        if (duenosExistentes.isEmpty()) {
            // Crear nuevo dueño y actualizar mascota
            controlPersis.guardarNuevoDuenioYActualizarMascota(duenioParaAsignar, masco);
        } else {
            // Solo actualizar la mascota (el dueño ya existe)
            controlPersis.modificarMascota(masco);
        }
    }
}
