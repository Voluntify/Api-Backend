package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.service.US13Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class US13Controller {

    final US13Service us13Service;
    public US13Controller(US13Service us13Service) {
        this.us13Service = us13Service;
    }

    @PutMapping("/EstadoDeInscripciones")
    public ResponseEntity<InscripcionesDTO> approveOrRejectInscripcion(
            @RequestParam Long id,
            @RequestParam boolean estado) {
        InscripcionesDTO updatedInscripcion = us13Service.approveOrRejectInscripcion(id, estado);
        return ResponseEntity.ok(updatedInscripcion);
    }
}
