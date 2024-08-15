package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Carreras;
import unah.lenguajes.proyecto.modelos.Clases;
import unah.lenguajes.proyecto.repositorios.ClasesRepositorio;

@Service
public class ClasesServicio {
    
    @Autowired
    private ClasesRepositorio clasesRepositorio;


    public List<Clases> obtenerTodos(){
        return this.clasesRepositorio.findAll();
    }

    public Clases crearClase(Clases nvaClase){
        Clases claseRequisito = nvaClase.getClaseRequisito();
        Carreras carrera = nvaClase.getCarrera();
        
        if(claseRequisito != null && !(this.clasesRepositorio.existsByCodigo(claseRequisito.getCodigo()))){
            this.clasesRepositorio.save(claseRequisito);
        } else{
            Clases claseRequisitoExistente = this.clasesRepositorio.findByCodigo(claseRequisito.getCodigo());
            nvaClase.setClaseRequisito(claseRequisitoExistente);
        }



        return this.clasesRepositorio.save(nvaClase);
    }

    public boolean buscarPorCodigo(String codigo){
        return this.clasesRepositorio.existsByCodigo(codigo);
    }
}
