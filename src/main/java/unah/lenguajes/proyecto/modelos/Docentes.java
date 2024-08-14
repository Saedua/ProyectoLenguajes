package unah.lenguajes.proyecto.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="docentes")
@Data
public class Docentes {
    
    @Id
    @Column(name = "id_docente")
    private long idDocente;

    private String nombre;

    private String apellido;

    private String correo;

    private String contrasena;

    private String foto;

    private char sexo;
}
