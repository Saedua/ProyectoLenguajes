package unah.lenguajes.proyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Clases;
import unah.lenguajes.proyecto.modelos.Docentes;
import unah.lenguajes.proyecto.modelos.Secciones;

@Repository
public interface SeccionesRepositorio extends JpaRepository<Secciones, Long> {
    public List<Secciones> findByClase(Clases clase);
    public List<Secciones> findByDocente(Docentes docente);
}
