package unah.lenguajes.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.Alumnos;
import unah.lenguajes.proyecto.servicios.AlumnosServicio;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnosController {
    @Autowired
    private AlumnosServicio alumnosServicio;

    @GetMapping("/obtener/todos")
    public List<Alumnos> obtenerTodos(){
        return this.alumnosServicio.obtenerTodos();
    }

    @PostMapping("/crear/nuevo")
    public Alumnos crearNuevo(@RequestBody Alumnos nvoAlumno){
        return this.alumnosServicio.crearNuevo(nvoAlumno);
    }

    @PutMapping("/actualizar/{numeroCuenta}")
    public Alumnos actualizar(@PathVariable(name="numeroCuenta") String numeroCuenta, @RequestBody Alumnos alumno){
        return this.alumnosServicio.actualizar(numeroCuenta, alumno);
    }
}
