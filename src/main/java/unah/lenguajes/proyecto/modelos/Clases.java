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
@Table(name="clases")
@Data
public class Clases {
    
    @Id
    @Column(name = "id_clase")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClase;

    private String nombre;

    @Column(name = "unidadesvalorativas")
    private Integer unidadesValorativas;

    private String codigo;

    @OneToOne
    @JoinColumn(name = "id_clase_requisito", referencedColumnName = "id_clase")
    private Clases claseRequisito;

    @OneToOne
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    private Carreras carrera;
}
