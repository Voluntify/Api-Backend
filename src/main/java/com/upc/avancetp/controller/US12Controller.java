package com.upc.avancetp.controller;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.service.US12Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class US12Controller {
    final US12Service us12Service;

    public US12Controller(US12Service us12Service) {
        this.us12Service = us12Service;
    }

    @GetMapping("Ver/Inscripciones/PorVoluntariado")
    public ResponseEntity<List<InscripcionesDTO>> ListaInscripcionesVoluntariado(@RequestParam("name") String name) {
        return ResponseEntity.ok(us12Service.inscripcionesMostrarPorVoluntariado(name));
    }

    @GetMapping("Ver/Inscripciones/PorUsuario")
    public ResponseEntity<List<InscripcionesDTO>> ListaInscripcionesUsuarios(@RequestParam("name") String name) {
        return ResponseEntity.ok(us12Service.inscripcionesMostrarPorUsuario(name));
    }
}
