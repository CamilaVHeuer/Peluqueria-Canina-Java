
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

public class ControladoraPersistencia {
    // instancio los JpaController
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        // crear en la BD el dueño
        duenioJpa.create(duenio);

        // crear en la BD la mascota
        mascoJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
        return mascoJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null,
                    ex);
        }
    }

    public Mascota traerUnaMascota(int num_cliente) {
        return mascoJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null,
                    ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null,
                    ex);
        }
    }

    // Métodos de búsqueda de dueños
    public List<Duenio> buscarDuenioPorNombre(String nombre) {
        return duenioJpa.buscarDuenioPorNombre(nombre);
    }

    public List<Duenio> buscarDuenioPorNombreYCelular(String nombre, String celular) {
        return duenioJpa.buscarDuenioPorNombreYCelular(nombre, celular);
    }

    public List<Duenio> buscarDueniosParaAutocompletar(String nombreParcial) {
        return duenioJpa.buscarDueniosParaAutocompletar(nombreParcial);
    }

    // Guardar solo mascota (cuando el dueño ya existe)
    public void guardarSoloMascota(Mascota masco) {
        mascoJpa.create(masco);
    }

    // Contar mascotas de un dueño específico
    public int contarMascotasPorDuenio(int id_duenio) {
        return mascoJpa.contarMascotasPorDuenio(id_duenio);
    }

    // Crear nuevo dueño y actualizar mascota
    public void guardarNuevoDuenioYActualizarMascota(Duenio nuevoDuenio, Mascota masco) {
        try {
            // Primero crear el nuevo dueño
            duenioJpa.create(nuevoDuenio);
            // Luego actualizar la mascota con el nuevo dueño
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null,
                    ex);
        }
    }
}
