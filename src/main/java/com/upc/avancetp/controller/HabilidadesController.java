package com.upc.avancetp.controller;

import com.upc.avancetp.dto.HabilidadesDTO;
import com.upc.avancetp.service.HabilidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HabilidadesController {
    final HabilidadeService habilidadeService;

    public HabilidadesController(HabilidadeService habilidadeService) {
        this.habilidadeService = habilidadeService;
    }

    @PostMapping("api/admin/RegistroHabilidades")
    public ResponseEntity<HabilidadesDTO> create(@RequestBody HabilidadesDTO habilidadesDTO) {
        return new ResponseEntity<>(habilidadeService.save(habilidadesDTO), HttpStatus.CREATED);
    }

    @GetMapping("api/VerHabilidades")
    public ResponseEntity<List<HabilidadesDTO>> ListaHabilidades() {
        return ResponseEntity.ok(habilidadeService.habilidadesMostrar());
    }
}