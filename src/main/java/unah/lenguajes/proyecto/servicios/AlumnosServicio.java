package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Alumnos;
import unah.lenguajes.proyecto.modelos.Carreras;
import unah.lenguajes.proyecto.repositorios.AlumnosRepositorio;

@Service
public class AlumnosServicio {
    
    @Autowired
    private AlumnosRepositorio alumnosRepositorio;

    public List<Alumnos> obtenerTodos(){
        return this.alumnosRepositorio.findAll();
    }

    public Alumnos crearNuevo(Alumnos nvoAlumno){
        List<Carreras> carreras = nvoAlumno.getCarreras();
        if(carreras!=null){

        }

        return this.alumnosRepositorio.save(nvoAlumno);
    }

    public Alumnos actualizar(String numeroCuenta, Alumnos alumno){
        if(this.alumnosRepositorio.existsById(numeroCuenta)){
            Alumnos alumnoActualizar = this.alumnosRepositorio.findById(numeroCuenta).get();
            if(alumno.getNombre() != null){
                alumnoActualizar.setNombre(alumno.getNombre());
            }
            if(alumno.getApellido() != null){
                alumnoActualizar.setApellido(alumno.getApellido());
            }
            if(alumno.getCarreras() != null){
                alumnoActualizar.setCarreras(alumno.getCarreras());
            }
            if(alumno.getFoto() != null){
                alumnoActualizar.setFoto(alumno.getFoto());
            }
            
            return this.alumnosRepositorio.save(alumnoActualizar);
        } else{
            return null;
        }
    }
}
