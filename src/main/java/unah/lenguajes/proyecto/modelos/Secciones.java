package unah.lenguajes.proyecto.modelos;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="secciones")
@Data
public class Secciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seccion")
    private long idSeccion;

    @ManyToOne
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    private Clases clase;

    @Column(name = "horainicio")
    private LocalTime horaInicio;

    @Column(name = "horafin")
    private LocalTime horaFin;

    @Column(name = "codigoseccion")
    private String codigoSeccion;

    @ManyToOne
    @JoinColumn(name = "id_docente", referencedColumnName = "id_docente")
    private Docentes docente;

    @OneToOne
    @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")
    private Aulas aula;

    @ManyToOne
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    private Periodo periodo;
}
