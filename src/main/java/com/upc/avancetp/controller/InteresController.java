package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.service.InteresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/RegistroDeInteres")
public class InteresController {
    final InteresService interesService;

    public InteresController(InteresService interesService) {
        this.interesService = interesService;
    }

    @PostMapping
    public ResponseEntity<InteresDTO> create(@RequestBody InteresDTO interesDTO) {
        return new ResponseEntity<>(interesService.save(interesDTO), HttpStatus.CREATED);
    }
}
