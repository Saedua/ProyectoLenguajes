package unah.lenguajes.proyecto.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="historialacademico")
@Data
public class HistorialAcademico {
    
    @Id
    private String cuentaAlumno;

    private String codigo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cuenta_alumno", referencedColumnName = "numerocuenta")
    private Alumnos alumno;
}
