package unah.lenguajes.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.Periodo;
import unah.lenguajes.proyecto.servicios.PeriodoServicio;

@RestController
@RequestMapping("/api/periodo")
public class PeriodoController {
    
    @Autowired
    private PeriodoServicio periodoServicio;

    @GetMapping("/obtener/todos")
    public List<Periodo> obtenerTodos(){
        return this.periodoServicio.obtenerTodos();
    }
}
