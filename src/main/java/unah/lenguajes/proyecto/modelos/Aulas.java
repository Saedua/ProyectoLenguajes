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
@Table(name="aulas")
@Data
public class Aulas {
    @Id
    @Column(name = "id_aula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAula;

    @OneToOne
    @JoinColumn(name="id_edificio", referencedColumnName = "id_edificio")
    private Edificios edificio;

    @Column(name = "nombre")
    private String nombre;
}
