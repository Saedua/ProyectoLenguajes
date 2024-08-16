package unah.lenguajes.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.Docentes;
import unah.lenguajes.proyecto.servicios.DocentesServicio;

@RestController
@RequestMapping("/api/docentes")
public class DocentesController {
    
    @Autowired
    private DocentesServicio docentesServicio;

    @GetMapping("/obtener/todos")
    public List<Docentes> obtenerTodos(){
        return this.docentesServicio.obtenerTodos();
    }

    @PostMapping("/crear/nuevo")
    public Docentes crearNuevo(@RequestBody Docentes nvoDocente){
        return this.docentesServicio.crearNuevo(nvoDocente);
    }

    
}
