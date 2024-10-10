package com.upc.avancetp.controller;

import com.upc.avancetp.dto.VoluntariadosPorHabilidadesDTO;
import com.upc.avancetp.service.VoluntariadosPorHabilidadesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
public class VoluntariadosPorHabilidadesController {
    final VoluntariadosPorHabilidadesService voluntariadosPorHabilidadesService;

    public VoluntariadosPorHabilidadesController(VoluntariadosPorHabilidadesService voluntariadosPorHabilidadesService) {
        this.voluntariadosPorHabilidadesService = voluntariadosPorHabilidadesService;
    }

    @PostMapping("RegistroHabilidadesPorVoluntariado")
    public ResponseEntity<VoluntariadosPorHabilidadesDTO> create(@RequestBody VoluntariadosPorHabilidadesDTO voluntariadosPorHabilidadesDTO) {
        return new ResponseEntity<>(voluntariadosPorHabilidadesService.save(voluntariadosPorHabilidadesDTO), HttpStatus.CREATED);
    }
}
