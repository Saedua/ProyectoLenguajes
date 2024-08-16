package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Docentes;
import unah.lenguajes.proyecto.repositorios.DocentesRepositorio;

@Service
public class DocentesServicio {
    
    @Autowired
    private DocentesRepositorio docentesRepositorio;

    public List<Docentes> obtenerTodos(){
        return this.docentesRepositorio.findAll();
    }

    public Docentes crearNuevo(Docentes nvoDocente){
        return this.docentesRepositorio.save(nvoDocente);
    }
}
