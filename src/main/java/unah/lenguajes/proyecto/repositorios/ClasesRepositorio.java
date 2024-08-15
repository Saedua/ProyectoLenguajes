package unah.lenguajes.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.Clases;

@Repository
public interface ClasesRepositorio extends JpaRepository<Clases, Long> {
    public boolean existsByCodigo(String codigo);
    public Clases findByCodigo(String codigo);
}
