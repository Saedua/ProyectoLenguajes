package unah.lenguajes.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.Matricula;
import unah.lenguajes.proyecto.servicios.MatriculaServicio;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaController {
    
    @Autowired
    private MatriculaServicio matriculaServicio;

    @GetMapping("/obtener/todos")
    public List<Matricula> obtenerTodos(){
        return this.matriculaServicio.obtenerTodos();
    }

    @PostMapping("/insertar/{idAlumno}")
    public Matricula insertarEnMatricula(@PathVariable String idAlumno, @RequestParam long idSeccion){
        return this.matriculaServicio.insertarEnMatricula(idSeccion, idAlumno);
    }
}
