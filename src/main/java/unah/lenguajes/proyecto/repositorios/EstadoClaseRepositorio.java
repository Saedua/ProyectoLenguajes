package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.EstadoClase;

@Repository
public interface EstadoClaseRepositorio extends JpaRepository<EstadoClase, Long> {
    
}
