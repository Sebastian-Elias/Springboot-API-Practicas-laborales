package cd.ipss.api_evaluacion2.models;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "practicas")
public class Practica {
    @Id
    private String id;
    private String estudianteId; // Relación con el estudiante
    private String profesorId; // Relación con el profesor supervisor
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaTermino;
    private String descripcionActividades;
    private Empresa empresa;
    private JefeDirecto jefeDirecto;
}

