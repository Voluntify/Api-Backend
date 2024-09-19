package com.upc.avancetp.controller;

import com.upc.avancetp.dto.HabilidadesDTO;
import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.service.HabilidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/RegistroDeHabilidad")
public class HabilidadesController {
    final HabilidadeService habilidadeService;

    public HabilidadesController(HabilidadeService habilidadeService) {
        this.habilidadeService = habilidadeService;
    }

    @PostMapping
    public ResponseEntity<HabilidadesDTO> create(@RequestBody HabilidadesDTO habilidadesDTO) {
        return new ResponseEntity<>(habilidadeService.save(habilidadesDTO), HttpStatus.CREATED);
    }
}
