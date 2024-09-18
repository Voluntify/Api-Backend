package com.upc.avancetp.controller;

import com.upc.avancetp.dto.CategoriasDTO;
import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.service.CategoriasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registroDeCategoria")
public class CategoriasController {
    final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }
    @PostMapping
    public ResponseEntity<CategoriasDTO> create(@RequestBody CategoriasDTO categoriasDTO) {
        return new ResponseEntity<>(categoriasService.save(categoriasDTO), HttpStatus.CREATED);
    }
}
