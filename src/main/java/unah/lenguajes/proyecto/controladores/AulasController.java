package unah.lenguajes.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.Aulas;
import unah.lenguajes.proyecto.servicios.AulasServicio;

@RestController
@RequestMapping("/api/aulas")
public class AulasController {
    
    @Autowired
    private AulasServicio aulasServicio;

    @GetMapping("/obtener/todos")
    public List<Aulas> obtenerTodos(){
        return this.aulasServicio.obtenerTodos();
    }
}
