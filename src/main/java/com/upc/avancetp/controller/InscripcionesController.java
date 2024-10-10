package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.service.InscripcionesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class InscripcionesController {
    final InscripcionesService inscripcionesService;

    public InscripcionesController(InscripcionesService inscripcionesService) {
        this.inscripcionesService = inscripcionesService;
    }

    @PostMapping("api/user/InscripcionAVoluntariado")
    public ResponseEntity<InscripcionesDTO> create(@RequestBody InscripcionesDTO inscripcionesDTO) {
        return new ResponseEntity<>(inscripcionesService.save(inscripcionesDTO), HttpStatus.CREATED);
    }


    @GetMapping("api/admin/VerInscripcionesPorVoluntariado")
    public ResponseEntity<List<InscripcionesDTO>> ListaInscripcionesVoluntariado(@RequestParam("name") String name) {
        return ResponseEntity.ok(inscripcionesService.inscripcionesMostrarPorVoluntariado(name));
    }

    @GetMapping("api/admin/VerInscripcionesPorUsuario")
    public ResponseEntity<List<InscripcionesDTO>> ListaInscripcionesUsuarios(@RequestParam("name") String name) {
        return ResponseEntity.ok(inscripcionesService.inscripcionesMostrarPorUsuario(name));
    }


    @PutMapping("api/admin/EstadoDeInscripciones")
    public ResponseEntity<InscripcionesDTO> approveOrRejectInscripcion(
            @RequestParam Long id,
            @RequestParam boolean estado) {
        InscripcionesDTO updatedInscripcion = inscripcionesService.approveOrRejectInscripcion(id, estado);
        return ResponseEntity.ok(updatedInscripcion);
    }
}

