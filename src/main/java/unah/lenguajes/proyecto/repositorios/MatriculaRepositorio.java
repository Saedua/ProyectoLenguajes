package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Matricula;

@Repository
public interface MatriculaRepositorio extends JpaRepository<Matricula, Long>{
    
}
