package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Docentes;

@Repository
public interface DocentesRepositorio extends JpaRepository<Docentes, Long>{
    
}
