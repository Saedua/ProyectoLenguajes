package unah.lenguajes.proyecto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Alumnos;
import unah.lenguajes.proyecto.modelos.HistorialAcademico;
import unah.lenguajes.proyecto.repositorios.AlumnosRepositorio;
import unah.lenguajes.proyecto.repositorios.HistorialAcademicoRepositorio;

@Service
public class HistorialAcademicoServicio {
    
    @Autowired
    private HistorialAcademicoRepositorio historialAcademicoRepositorio;

    @Autowired
    private AlumnosRepositorio alumnosRepositorio;

    public HistorialAcademico crearNuevo(String cuentaAlumno, String codigo){
        if(this.alumnosRepositorio.existsById(cuentaAlumno)){
            Alumnos alumno = this.alumnosRepositorio.findById(cuentaAlumno).get();

            HistorialAcademico historialAcademico = new HistorialAcademico();
            historialAcademico.setAlumno(alumno);
            historialAcademico.setCodigo(codigo);

            return this.historialAcademicoRepositorio.save(historialAcademico);
        } else{
            return null;
        }
    }
}
