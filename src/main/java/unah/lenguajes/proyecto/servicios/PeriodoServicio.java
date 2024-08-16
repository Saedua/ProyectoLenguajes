package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Periodo;
import unah.lenguajes.proyecto.repositorios.PeriodoRepositorio;

@Service
public class PeriodoServicio {
    
    @Autowired
    private PeriodoRepositorio periodoRepositorio;


    public List<Periodo> obtenerTodos(){
        return this.periodoRepositorio.findAll();
    }

    public Periodo crearNuevo(Periodo nvoPeriodo){
        return this.periodoRepositorio.save(nvoPeriodo);
    }
}
