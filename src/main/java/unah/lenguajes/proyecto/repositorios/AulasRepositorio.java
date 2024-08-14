package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Aulas;

@Repository
public interface AulasRepositorio extends JpaRepository<Aulas, Long>{
    
}
