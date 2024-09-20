package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.service.InteresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Interes")
public class InteresController {
    final InteresService interesService;

    public InteresController(InteresService interesService) {
        this.interesService = interesService;
    }

    @PostMapping("Registro")
    public ResponseEntity<InteresDTO> create(@RequestBody InteresDTO interesDTO) {
        return new ResponseEntity<>(interesService.save(interesDTO), HttpStatus.CREATED);
    }

    @GetMapping("Ver")
    public ResponseEntity<List<InteresDTO>> ListaInteres() {
        return ResponseEntity.ok(interesService.interesMostrar());
    }
}
