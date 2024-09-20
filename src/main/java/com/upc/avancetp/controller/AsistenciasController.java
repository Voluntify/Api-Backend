package com.upc.avancetp.controller;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.dto.CategoriasDTO;
import com.upc.avancetp.service.AsistenciasService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/Asistencias")
public class AsistenciasController {
    final AsistenciasService asistenciasService;

    public AsistenciasController(AsistenciasService asistenciasService) {
        this.asistenciasService = asistenciasService;
    }

    @PostMapping("Registro")
    public ResponseEntity<AsistenciasDTO> create(@RequestBody AsistenciasDTO asistenciasDTO) {
        return new ResponseEntity<>(asistenciasService.save(asistenciasDTO), HttpStatus.CREATED);
    }

    @GetMapping("Ver")
    public ResponseEntity<List<AsistenciasDTO>> ListaAsistencias() {
        return ResponseEntity.ok(asistenciasService.asistenciasMostrar());
    }
}
