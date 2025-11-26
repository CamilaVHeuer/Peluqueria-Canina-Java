
package com.mycompany.peluqueriacanina.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "duenio")

public class Duenio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_duenio;
    private String nombre;
    private String celDuenio;
    @OneToMany(mappedBy = "unDuenio")
    private List<Mascota> listaMascotas;

    public Duenio() {
    }

    public Duenio(int id_duenio, String nombre, String celDuenio, List<Mascota> listaMascotas) {
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.celDuenio = celDuenio;
        this.listaMascotas = listaMascotas;
    }

    // Constructor sin lista de mascotas (para compatibilidad)
    public Duenio(int id_duenio, String nombre, String celDuenio) {
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.celDuenio = celDuenio;
        this.listaMascotas = new ArrayList<>();
    }

    public int getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelDuenio() {
        return celDuenio;
    }

    public void setCelDuenio(String celDuenio) {
        this.celDuenio = celDuenio;
    }

    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
}
