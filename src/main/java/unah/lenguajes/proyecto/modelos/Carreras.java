package unah.lenguajes.proyecto.modelos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="carreras")
@Data
public class Carreras {
    @Id
    @Column(name = "id_carrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarrera;

    private String nombre;

    /*Ver si es necesario anotar que esta en una relacion Muchos a muchos */
}
