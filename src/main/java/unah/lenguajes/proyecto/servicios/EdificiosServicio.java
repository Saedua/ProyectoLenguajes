package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Edificios;
import unah.lenguajes.proyecto.repositorios.EdificiosRepositorio;

@Service
public class EdificiosServicio {
    
    @Autowired
    private EdificiosRepositorio edificiosRepositorio;

    public List<Edificios> obtenerTodos(){
        return this.edificiosRepositorio.findAll();
    }

    public Edificios crearNuevo(String nombre){
        Edificios edificio = new Edificios();
        edificio.setNombre(nombre);

        return this.edificiosRepositorio.save(edificio);
    }
}
