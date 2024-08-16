package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Alumnos;
import unah.lenguajes.proyecto.modelos.Clases;
import unah.lenguajes.proyecto.modelos.ClasesHistorial;
import unah.lenguajes.proyecto.modelos.EstadoClase;
import unah.lenguajes.proyecto.modelos.HistorialAcademico;
import unah.lenguajes.proyecto.modelos.Periodo;
import unah.lenguajes.proyecto.repositorios.AlumnosRepositorio;
import unah.lenguajes.proyecto.repositorios.ClasesHistorialRepositorio;
import unah.lenguajes.proyecto.repositorios.ClasesRepositorio;
import unah.lenguajes.proyecto.repositorios.EstadoClaseRepositorio;
import unah.lenguajes.proyecto.repositorios.HistorialAcademicoRepositorio;
import unah.lenguajes.proyecto.repositorios.PeriodoRepositorio;

@Service
public class ClasesHistorialServicio {
    
    @Autowired
    private ClasesHistorialRepositorio clasesHistorialRepositorio;

    @Autowired
    private AlumnosRepositorio alumnosRepositorio;

    @Autowired
    private HistorialAcademicoRepositorio historialAcademicoRepositorio;

    @Autowired
    private ClasesRepositorio clasesRepositorio;

    @Autowired
    private PeriodoRepositorio periodoRepositorio;

    @Autowired
    private EstadoClaseRepositorio estadoClaseRepositorio;

    public List<ClasesHistorial> obtenerTodos(){
        return clasesHistorialRepositorio.findAll();
    }

    public List<ClasesHistorial> obtenerTodosPorEstudiante(HistorialAcademico historialAcademico){
        return clasesHistorialRepositorio.findByHistorialAcademico(historialAcademico);
    }

    public ClasesHistorial crearEntrada(String cuentaAlumno, ClasesHistorial clasesHistorial){
        if(this.alumnosRepositorio.existsById(cuentaAlumno)){
            Alumnos alumno = this.alumnosRepositorio.findById(cuentaAlumno).get();
            HistorialAcademico historialAcademico = this.historialAcademicoRepositorio.findByCuentaAlumno(alumno.getNumeroCuenta());
            clasesHistorial.setHistorialAcademico(historialAcademico);

            //VERIFICACION CLASE
            Clases clase = clasesHistorial.getClase();
            if(clase != null){
                if(!(this.clasesRepositorio.existsByCodigo(clase.getCodigo()))){
                    this.clasesRepositorio.save(clase);
                } else{
                    Clases claseExistente = this.clasesRepositorio.findByCodigo(clase.getCodigo());
                    clasesHistorial.setClase(claseExistente);
                }
            }

            //VERIFICACION PERIODO
            Periodo periodo = clasesHistorial.getPeriodo();
            if(periodo!=null){
                if(!(this.periodoRepositorio.existsById(periodo.getIdPeriodo()))){
                    this.periodoRepositorio.save(periodo);
                } else{
                    Periodo periodoExistente = this.periodoRepositorio.findById(periodo.getIdPeriodo()).get();
                    clasesHistorial.setPeriodo(periodoExistente);
                }
            }

            //VERIFICACION ESTADO
            EstadoClase estadoClase = clasesHistorial.getEstado();
            if(estadoClase != null){
                if(!(this.estadoClaseRepositorio.existsById(estadoClase.getIdEstado()))){
                    this.estadoClaseRepositorio.save(estadoClase);
                } else{
                    EstadoClase estadoClaseExistente = this.estadoClaseRepositorio.findById(estadoClase.getIdEstado()).get();
                    clasesHistorial.setEstado(estadoClaseExistente);
                }
            }



            return this.clasesHistorialRepositorio.save(clasesHistorial);
        } else{
            return null;
        }
    }
}
