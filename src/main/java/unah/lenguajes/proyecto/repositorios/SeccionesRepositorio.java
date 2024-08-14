package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Secciones;

@Repository
public interface SeccionesRepositorio extends JpaRepository<Secciones, Long> {
    
}
