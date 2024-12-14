package cd.ipss.api_evaluacion2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/info")
    public String getInfo() {
        return "Información pública accesible sin autenticación.";
    }
}

