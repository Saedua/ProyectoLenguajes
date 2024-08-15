package unah.lenguajes.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.Carreras;
import unah.lenguajes.proyecto.servicios.CarrerasServicio;

@RestController
@RequestMapping("/api/carreras")
public class CarrerasController {
    
    @Autowired
    private CarrerasServicio carrerasServicio;

    @GetMapping("/obtener/todos")
    public List<Carreras> obtenerTodos(){
        return this.carrerasServicio.obtenerTodos();
    }

    @PostMapping("/crear/nuevo")
    public Carreras crearNuevo(@RequestBody Carreras nvaCarrera){
        return this.carrerasServicio.crearNuevo(nvaCarrera);
    }
}
