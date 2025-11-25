
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    //instancio la controladora de persistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String nombreDuenio, String celDuenio, String alergico, String atEsp) {
       //instancio un Duenio y asigno sus valores
       Duenio duenio = new Duenio();
       duenio.setNombre(nombreDuenio);
       duenio.setCelDuenio(celDuenio);
       
       
       //instancio la mascota y asigno sus valores
       Mascota masco = new Mascota();
       masco.setNombre(nombreMasco);
       masco.setRaza(raza);
       masco.setColor(color);
       masco.setAlergico(alergico);
       masco.setAtencion_especial(atEsp);
       masco.setObservaciones(observaciones);
       masco.setUnDuenio(duenio);
       
       controlPersis.guardar(duenio,masco);
      
       
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

    public void modificarMAscota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atEsp, String nombreDuenio, String celDuenio) {
        //al masco viejo que me llega le setteo los nuevos parametros que llegan con el.
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);
        
        //modifico mascota
        controlPersis.modificarMascota(masco); 
        
        //para el dueño: 
        //primero lo identifico, y para ello instancio un dueño que va a llamar a un metodo de bsuqueda en esta controladora
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        
        //seteo al dueño sus valores nuevos
        dueno.setNombre(nombreDuenio);
        dueno.setCelDuenio(celDuenio);
        
        //llamo a modificar Dueño
        this.modificarDuenio(dueno);
        
               
            }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio); 
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }
    
}
