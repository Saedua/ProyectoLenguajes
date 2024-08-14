package unah.lenguajes.proyecto.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="clases_historial")
@Data
public class ClasesHistorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clases_historial")
    private long idClasesHistorial;

    @OneToOne
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    private Clases clase;

    @OneToOne
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    private Periodo periodo;

    @OneToOne
    @JoinColumn(name = "historial_alumno", referencedColumnName = "cuenta_alumno")
    private HistorialAcademico historialAcademico;

    private double calificacion;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private EstadoClase estado;
}
