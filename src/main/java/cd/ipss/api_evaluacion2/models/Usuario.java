package cd.ipss.api_evaluacion2.models;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombreCompleto;
    private String email;
    private String contraseña;
    private String rol; // "ESTUDIANTE" o "PROFESOR"
}
