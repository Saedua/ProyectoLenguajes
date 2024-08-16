package unah.lenguajes.proyecto.modelos;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "alumnos_carreras",
        joinColumns = @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera"),
        inverseJoinColumns = @JoinColumn(name = "id_alumno", referencedColumnName = "numerocuenta")
    )
    private List<Alumnos> alumnos;
}
