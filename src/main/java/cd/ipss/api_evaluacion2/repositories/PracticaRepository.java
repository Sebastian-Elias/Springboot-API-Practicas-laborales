package cd.ipss.api_evaluacion2.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cd.ipss.api_evaluacion2.models.Practica;

public interface PracticaRepository extends MongoRepository<Practica, String> {
    List<Practica> findByEstudianteId(String estudianteId); // Consultar prácticas por estudiante

}
