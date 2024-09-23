package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.service.US13Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
public class US13Controller {

    @Autowired
    private US13Service us13Service;

    @PutMapping("/{id}/estado")
    public ResponseEntity<InscripcionesDTO> approveOrRejectInscripcion(
            @PathVariable Long id,
            @RequestParam boolean estado) {
        InscripcionesDTO updatedInscripcion = us13Service.approveOrRejectInscripcion(id, estado);
        return ResponseEntity.ok(updatedInscripcion);
    }
}
