package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Edificios;

@Repository
public interface EdificiosRepositorio extends JpaRepository<Edificios, Long> {
    
}
