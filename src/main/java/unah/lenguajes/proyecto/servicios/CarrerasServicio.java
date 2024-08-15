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

    public Carreras crearNuevo(Carreras nvaCarrera){
        return this.carrerasRepositorio.save(nvaCarrera);
    }
}
