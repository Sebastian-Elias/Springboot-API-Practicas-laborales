package cd.ipss.api_evaluacion2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import cd.ipss.api_evaluacion2.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmail(String email); // Buscar usuarios por email (para autenticación)

}
