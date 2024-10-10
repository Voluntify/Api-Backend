package com.upc.avancetp.controller;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.service.AsistenciasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AsistenciasController {
    final AsistenciasService asistenciasService;

    public AsistenciasController(AsistenciasService asistenciasService) {
        this.asistenciasService = asistenciasService;
    }

    @PostMapping("RegistroDeAsistencias")
    public ResponseEntity<AsistenciasDTO> create(@RequestBody AsistenciasDTO asistenciasDTO) {
        return new ResponseEntity<>(asistenciasService.save(asistenciasDTO), HttpStatus.CREATED);
    }

    @GetMapping("VerAsistenciasDeTodosLosVoluntariados")
    public ResponseEntity<List<AsistenciasDTO>> ListaAsistencias() {
        return ResponseEntity.ok(asistenciasService.asistenciasMostrarVoluntariados());
    }

    @GetMapping("VerAsistenciasPorNombreDeVoluntariado")
    public ResponseEntity<List<AsistenciasDTO>> ListaAsistenciasPorNombre(@RequestParam("name") String name) {
        return ResponseEntity.ok(asistenciasService.asistenciasporVoluntariadoMostrar(name));
    }
}
