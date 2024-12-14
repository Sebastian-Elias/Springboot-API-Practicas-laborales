package cd.ipss.api_evaluacion2.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import cd.ipss.api_evaluacion2.models.Practica;
import cd.ipss.api_evaluacion2.services.PracticaService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final PracticaService practicaService;
    private static final Logger logger = LoggerFactory.getLogger(EstudianteController.class);

    // Inyección de dependencias para el servicio
    public EstudianteController(PracticaService practicaService) {
        this.practicaService = practicaService;
    }

    @PostMapping("/practicas")
    @ResponseStatus(HttpStatus.CREATED)
    public Practica agregarPractica(@RequestBody Practica practica) {
        logger.info("Recibiendo solicitud para agregar práctica: {}", practica);
        return practicaService.crearPractica(practica);
    }

    @GetMapping("/practicas/{estudianteId}")
    public List<Practica> listarPracticas(@PathVariable String estudianteId) {
        return practicaService.listarPracticasPorEstudiante(estudianteId);
    }
}
