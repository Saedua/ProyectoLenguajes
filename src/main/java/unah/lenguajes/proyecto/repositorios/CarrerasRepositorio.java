package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Carreras;

@Repository
public interface CarrerasRepositorio extends JpaRepository<Carreras, Long> {
    
}
