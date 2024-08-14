package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.ClasesHistorial;

@Repository
public interface ClasesHistorialRepositorio extends JpaRepository<ClasesHistorial, Long> {
    
}
