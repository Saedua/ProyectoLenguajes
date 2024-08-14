package unah.lenguajes.proyecto.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="matricula")
@Data
public class Matricula {
    
    @Id
    @Column(name = "id_matricula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMatricula;

    @ManyToOne
    @JoinColumn(name = "cuenta_alumno", referencedColumnName = "numerocuenta")
    private Alumnos alumno;

    @OneToMany
    @JoinColumn(name = "id_seccion")
    private List<Secciones> secciones;
}
