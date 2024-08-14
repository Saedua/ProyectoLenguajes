package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Alumnos;
import unah.lenguajes.proyecto.modelos.HistorialAcademico;

@Repository
public interface HistorialAcademicoRepositorio extends JpaRepository<HistorialAcademico, Alumnos> {

}
