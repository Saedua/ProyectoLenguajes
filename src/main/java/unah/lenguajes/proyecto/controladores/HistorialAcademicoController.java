package unah.lenguajes.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.proyecto.modelos.HistorialAcademico;
import unah.lenguajes.proyecto.servicios.HistorialAcademicoServicio;

@RestController
@RequestMapping("/api/historialacademico")
public class HistorialAcademicoController {
    
    @Autowired
    private HistorialAcademicoServicio historialAcademicoServicio;

    @PostMapping("/crear/{cuentaAlumno}")
    public HistorialAcademico crearNuevo(@PathVariable String cuentaAlumno, @RequestParam String codigo){
        return this.historialAcademicoServicio.crearNuevo(cuentaAlumno, codigo);
    }
}
