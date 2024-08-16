package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Aulas;
import unah.lenguajes.proyecto.repositorios.AulasRepositorio;

@Service
public class AulasServicio {
    
    @Autowired
    private AulasRepositorio aulasRepositorio;

    public List<Aulas> obtenerTodos(){
        return this.aulasRepositorio.findAll();
    }

    public Aulas crearNuevo(Aulas nvaAula){
        return this.aulasRepositorio.save(nvaAula);
    }
}
