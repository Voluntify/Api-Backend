package com.upc.avancetp.controller;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.service.AsistenciasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/RegistroDeAsistencias")
public class AsistenciasController {
    final AsistenciasService asistenciasService;

    public AsistenciasController(AsistenciasService asistenciasService) {
        this.asistenciasService = asistenciasService;
    }

    @PostMapping
    public ResponseEntity<AsistenciasDTO> create(@RequestBody AsistenciasDTO asistenciasDTO) {
        return new ResponseEntity<>(asistenciasService.save(asistenciasDTO), HttpStatus.CREATED);
    }
}
