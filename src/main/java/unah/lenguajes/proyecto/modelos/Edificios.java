package unah.lenguajes.proyecto.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="edificios")
@Data
public class Edificios {
    @Id
    @Column(name = "id_edificio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEdificio;

    private String nombre;
}
