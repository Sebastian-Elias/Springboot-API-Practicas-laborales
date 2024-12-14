package cd.ipss.api_evaluacion2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cd.ipss.api_evaluacion2.models.Practica;
import cd.ipss.api_evaluacion2.services.PracticaService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    private final PracticaService practicaService;

    public ProfesorController(PracticaService practicaService) {
        this.practicaService = practicaService;
    }

    @PostMapping("/practicas")
    public Practica agregarPractica(@RequestBody Practica practica) {
        return practicaService.crearPractica(practica);
    }

    @GetMapping("/practicas")
    public List<Practica> listarTodasLasPracticas() {
        return practicaService.listarTodasLasPracticas();
    }

    @PutMapping("/practicas/{id}")
    public Practica actualizarPractica(@PathVariable String id, @RequestBody Practica practica) {
        return practicaService.actualizarPractica(id, practica);
    }

    @DeleteMapping("/practicas/{id}")
    public void eliminarPractica(@PathVariable String id) {
        practicaService.eliminarPractica(id);
    }
}
