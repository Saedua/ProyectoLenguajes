package unah.lenguajes.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.Clases;
import unah.lenguajes.proyecto.servicios.ClasesServicio;

@RestController
@RequestMapping("/api/clases")
public class ClasesController {
    @Autowired
    private ClasesServicio clasesServicio;

    @GetMapping("/obtener/todos")
    public List<Clases> obtenerTodos(){
        return this.clasesServicio.obtenerTodos();
    }

    @PostMapping("/crear/nuevo")
    public Clases crearClase(@RequestBody Clases nvaClase){
        return this.clasesServicio.crearClase(nvaClase);
    }
}
