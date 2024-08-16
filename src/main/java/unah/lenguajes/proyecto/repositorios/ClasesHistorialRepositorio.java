package unah.lenguajes.proyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.proyecto.modelos.ClasesHistorial;
import unah.lenguajes.proyecto.modelos.HistorialAcademico;

@Repository
public interface ClasesHistorialRepositorio extends JpaRepository<ClasesHistorial, Long> {
    
    public List<ClasesHistorial> findByHistorialAcademico(HistorialAcademico historialAcademico);
}
