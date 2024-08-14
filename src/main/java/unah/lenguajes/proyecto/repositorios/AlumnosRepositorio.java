package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Alumnos;

@Repository
public interface AlumnosRepositorio extends JpaRepository<Alumnos, String> {
    
}
