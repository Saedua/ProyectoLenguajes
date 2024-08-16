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

import unah.lenguajes.proyecto.modelos.Clases;
import unah.lenguajes.proyecto.modelos.Docentes;
import unah.lenguajes.proyecto.modelos.Secciones;
import unah.lenguajes.proyecto.servicios.SeccionesServicio;

@RestController
@RequestMapping("/api/secciones")
public class SeccionesController {
    
    @Autowired
    private SeccionesServicio seccionesServicio;

    @GetMapping("/obtener/todos")
    public List<Secciones> obtenerTodos(){
        return this.seccionesServicio.obtenerTodos();
    }

    @GetMapping("/obtener/clase")
    public List<Secciones> obtenerTodosPorClase(@RequestBody Clases clase){
        return this.seccionesServicio.obtenerTodosPorClase(clase);
    }

    @GetMapping("/obtener/docente")
    public List<Secciones> obtenerTodosPorDocente(@RequestBody Docentes docente){
        return this.seccionesServicio.obtenerTodosPorDocente(docente);
    }

    @PostMapping("/crear/nuevo")
    public Secciones crearNuevo(@RequestBody Secciones seccion){
        return this.seccionesServicio.crearNuevo(seccion);
    }

    @PutMapping("/actualizar/{idSeccion}")
    public Secciones actualizar(@PathVariable(name = "idSeccion") long idSeccion, @RequestBody Secciones seccion){
        return this.seccionesServicio.actualizar(idSeccion, seccion);
    }
}
