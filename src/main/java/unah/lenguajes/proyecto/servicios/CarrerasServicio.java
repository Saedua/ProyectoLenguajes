package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Carreras;
import unah.lenguajes.proyecto.repositorios.CarrerasRepositorio;

@Service
public class CarrerasServicio {
    
    @Autowired
    private CarrerasRepositorio carrerasRepositorio;

    public List<Carreras> obtenerTodos(){
        return this.carrerasRepositorio.findAll();
    }

    /*Podria cambiarse a que solo reciba el nombre ya que es la unica columna que necesita.
     * Pero de esta forma se podria utilizar un JSON
     */
    public Carreras crearNuevo(Carreras nvaCarrera){
        return this.carrerasRepositorio.save(nvaCarrera);
    }
}
