package com.upc.avancetp.controller;

import com.upc.avancetp.dto.VoluntariadosDTO;
import com.upc.avancetp.service.VoluntariadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voluntariados")
public class VoluntariadosController {

    private final VoluntariadosService voluntariadosService;

    public VoluntariadosController(VoluntariadosService voluntariadosService) {
        this.voluntariadosService = voluntariadosService;
    }

    // Endpoint para registrar un nuevo voluntariado
    @PostMapping
    public ResponseEntity<VoluntariadosDTO> registrarVoluntariado(@RequestBody VoluntariadosDTO voluntariadosDTO) {
        VoluntariadosDTO nuevoVoluntariado = voluntariadosService.save(voluntariadosDTO);
        return ResponseEntity.ok(nuevoVoluntariado);
    }
}
