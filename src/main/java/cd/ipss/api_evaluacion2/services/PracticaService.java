package cd.ipss.api_evaluacion2.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cd.ipss.api_evaluacion2.models.Practica;
import cd.ipss.api_evaluacion2.repositories.PracticaRepository;

@Service
public class PracticaService {
    private final PracticaRepository practicaRepository;
    private static final Logger logger = LoggerFactory.getLogger(PracticaService.class);


    public PracticaService(PracticaRepository practicaRepository) {
        this.practicaRepository = practicaRepository;
    }

    public Practica crearPractica(Practica practica) {
        logger.info("Recibido en el servicio: {}", practica); // Log de los datos recibidos
        Practica result = practicaRepository.save(practica);
        logger.info("Practica guardada en DB: {}", result); // Log después de guardar
        return result;
    }

    public List<Practica> listarPracticasPorEstudiante(String estudianteId) {
        return practicaRepository.findByEstudianteId(estudianteId);
    }

    public List<Practica> listarTodasLasPracticas() {
        return practicaRepository.findAll();
    }

    public Practica actualizarPractica(String id, Practica practicaActualizada) {
        Practica practica = practicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Práctica no encontrada"));
        practica.setFechaInicio(practicaActualizada.getFechaInicio());
        practica.setFechaTermino(practicaActualizada.getFechaTermino());
        practica.setDescripcionActividades(practicaActualizada.getDescripcionActividades());
        practica.setEmpresa(practicaActualizada.getEmpresa());
        practica.setJefeDirecto(practicaActualizada.getJefeDirecto());
        return practicaRepository.save(practica);
    }

    public void eliminarPractica(String id) {
        practicaRepository.deleteById(id);
    }
}
