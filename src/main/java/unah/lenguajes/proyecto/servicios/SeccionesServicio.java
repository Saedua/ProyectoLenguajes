package unah.lenguajes.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.proyecto.modelos.Aulas;
import unah.lenguajes.proyecto.modelos.Clases;
import unah.lenguajes.proyecto.modelos.Docentes;
import unah.lenguajes.proyecto.modelos.Periodo;
import unah.lenguajes.proyecto.modelos.Secciones;
import unah.lenguajes.proyecto.repositorios.AulasRepositorio;
import unah.lenguajes.proyecto.repositorios.ClasesRepositorio;
import unah.lenguajes.proyecto.repositorios.DocentesRepositorio;
import unah.lenguajes.proyecto.repositorios.PeriodoRepositorio;
import unah.lenguajes.proyecto.repositorios.SeccionesRepositorio;

@Service
public class SeccionesServicio {
    
    @Autowired
    private SeccionesRepositorio seccionesRepositorio;

    @Autowired
    private ClasesRepositorio clasesRepositorio;

    @Autowired
    private DocentesRepositorio docentesRepositorio;

    @Autowired
    private AulasRepositorio aulasRepositorio;

    @Autowired
    private PeriodoRepositorio periodoRepositorio;

    public List<Secciones> obtenerTodos(){
        return this.seccionesRepositorio.findAll();
    }

    public List<Secciones> obtenerTodosPorClase(Clases clase){
        return this.seccionesRepositorio.findByClase(clase);
    }

    public List<Secciones> obtenerTodosPorDocente(Docentes docente){
        return this.seccionesRepositorio.findByDocente(docente);
    }

    public Secciones crearNuevo(Secciones nvaSeccion){
        Clases clase = nvaSeccion.getClase();
        Docentes docente = nvaSeccion.getDocente();
        Aulas aula = nvaSeccion.getAula();
        Periodo periodo = nvaSeccion.getPeriodo();

        //VERIFICACION CLASE
        if(clase != null){
            if(!(this.clasesRepositorio.existsByCodigo(clase.getCodigo()))){
                this.clasesRepositorio.save(clase);
            } else{
                Clases claseExistente = this.clasesRepositorio.findByCodigo(clase.getCodigo());
                nvaSeccion.setClase(claseExistente);
            }
        }

        //VERIFICACION DOCENTE
        if(docente != null){
            if(!(this.docentesRepositorio.existsById(docente.getIdDocente()))){
                this.docentesRepositorio.save(docente);
            } else{
                Docentes docenteExistente = this.docentesRepositorio.findById(docente.getIdDocente()).get();
                nvaSeccion.setDocente(docenteExistente);
            }
        }

        //VERIFICACION AULA
        if(aula!=null){
            if(!(this.aulasRepositorio.existsById(aula.getIdAula()))){
                this.aulasRepositorio.save(aula);
            } else{
                Aulas aulaExistente = this.aulasRepositorio.findById(aula.getIdAula()).get();
                nvaSeccion.setAula(aulaExistente);
            }
        }

        //Verificacion Periodo
        if(periodo!=null){
            if(!(this.periodoRepositorio.existsById(periodo.getIdPeriodo()))){
                this.periodoRepositorio.save(periodo);
            } else{
                Periodo periodoExistente = this.periodoRepositorio.findById(periodo.getIdPeriodo()).get();
                nvaSeccion.setPeriodo(periodoExistente);
            }
        }



            return this.seccionesRepositorio.save(nvaSeccion);

    }

    public Secciones actualizar(long idSeccion, Secciones seccion){
        if(this.seccionesRepositorio.existsById(idSeccion)){
            Secciones seccionActualizar = this.seccionesRepositorio.findById(idSeccion).get();
            if(seccion.getClase() != null){
                Clases claseExistente = this.clasesRepositorio.findByCodigo(seccion.getClase().getCodigo());
                seccionActualizar.setClase(claseExistente);
            }
            if(seccion.getAula() != null){
                Aulas aulaExistente = this.aulasRepositorio.findById(seccion.getAula().getIdAula()).get();
                seccionActualizar.setAula(aulaExistente);
            }
            if(seccion.getCodigoSeccion() != null){
                seccionActualizar.setCodigoSeccion(seccion.getCodigoSeccion());
            }
            if(seccion.getDocente() !=null){
                Docentes docenteExistente = this.docentesRepositorio.findById(seccion.getDocente().getIdDocente()).get();
                seccionActualizar.setDocente(docenteExistente);
            }
            if(seccion.getHoraFin() !=null){
                seccionActualizar.setHoraFin(seccion.getHoraFin());
            }
            if(seccion.getHoraInicio() !=null){
                seccionActualizar.setHoraInicio(seccion.getHoraInicio());
            }
            if(seccion.getPeriodo() !=null){
                Periodo periodoExistente = this.periodoRepositorio.findById(seccion.getPeriodo().getIdPeriodo()).get();
                seccionActualizar.setPeriodo(periodoExistente);
            }
            
            return this.seccionesRepositorio.save(seccionActualizar);
        } else{
            return null;
        }
    }

    //DEPRECATED
    public boolean existenSeccionesPorIds(List<Long> idsSeccion){
        for(Long idSeccion : idsSeccion){
            if(!this.seccionesRepositorio.existsById(idSeccion)){
                return false;
            }
        }
        return true;
    }

}
