package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Carreras;
import unah.lenguajes.proyecto.modelos.Clases;
import unah.lenguajes.proyecto.repositorios.CarrerasRepositorio;
import unah.lenguajes.proyecto.repositorios.ClasesRepositorio;

@Service
public class ClasesServicio {
    
    @Autowired
    private ClasesRepositorio clasesRepositorio;

    @Autowired
    private CarrerasRepositorio carrerasRepositorio;


    public List<Clases> obtenerTodos(){
        return this.clasesRepositorio.findAll();
    }

    public Clases crearClase(Clases nvaClase){
        Clases claseRequisito = nvaClase.getClaseRequisito();
        Carreras carrera = nvaClase.getCarrera();
        
        if(claseRequisito != null){
            if(!(this.clasesRepositorio.existsByCodigo(claseRequisito.getCodigo()))){
                this.clasesRepositorio.save(claseRequisito);
            } else{
                Clases claseRequisitoExistente = this.clasesRepositorio.findByCodigo(claseRequisito.getCodigo());
                nvaClase.setClaseRequisito(claseRequisitoExistente);
            }
        } 
        
        /*Evaluar si este necesita la misma forma que el de arriba. En este caso, la carrera no podria ser
         * nula ya que cada clase debe pertenecer a una carrera. Diferente al caso de arriba con la claseRequisito
         */
        if((carrera != null) && !(this.carrerasRepositorio.existsById(carrera.getIdCarrera()))){
            this.carrerasRepositorio.save(carrera);
        } else{
            Carreras carreraExistente = this.carrerasRepositorio.findById(carrera.getIdCarrera()).get();
            nvaClase.setCarrera(carreraExistente);
        }



        return this.clasesRepositorio.save(nvaClase);
    }

    public boolean buscarPorCodigo(String codigo){
        return this.clasesRepositorio.existsByCodigo(codigo);
    }
}
