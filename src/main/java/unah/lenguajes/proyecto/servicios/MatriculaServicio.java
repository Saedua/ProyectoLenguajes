package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Alumnos;
import unah.lenguajes.proyecto.modelos.Matricula;
import unah.lenguajes.proyecto.modelos.Secciones;
import unah.lenguajes.proyecto.repositorios.AlumnosRepositorio;
import unah.lenguajes.proyecto.repositorios.MatriculaRepositorio;
import unah.lenguajes.proyecto.repositorios.SeccionesRepositorio;

@Service
public class MatriculaServicio {
    
    @Autowired
    private MatriculaRepositorio matriculaRepositorio;

    @Autowired
    private AlumnosRepositorio alumnosRepositorio;

    @Autowired
    private SeccionesRepositorio seccionesRepositorio;

    public List<Matricula> obtenerTodos(){
       return this.matriculaRepositorio.findAll();
    }

    public Matricula insertarEnMatricula(long idSeccion, String idAlumno){
        if(this.seccionesRepositorio.existsById(idSeccion) && this.alumnosRepositorio.existsById(idAlumno)){
            Secciones seccion = this.seccionesRepositorio.findById(idSeccion).get();
            Alumnos alumno = this.alumnosRepositorio.findById(idAlumno).get();

            Matricula matricula = new Matricula();

            matricula.setAlumno(alumno);
            matricula.setSeccion(seccion);

            return this.matriculaRepositorio.save(matricula);
        } else{
            return null;
        }
    }

}
