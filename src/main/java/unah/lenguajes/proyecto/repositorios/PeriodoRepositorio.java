package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Periodo;

@Repository
public interface PeriodoRepositorio extends JpaRepository<Periodo, Long>{
    
}
