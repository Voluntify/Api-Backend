package com.upc.avancetp.controller;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.dto.CategoriasDTO;
import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.service.CategoriasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Categorias")
public class CategoriasController {
    final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @PostMapping("Registro")
    public ResponseEntity<CategoriasDTO> create(@RequestBody CategoriasDTO categoriasDTO) {
        return new ResponseEntity<>(categoriasService.save(categoriasDTO), HttpStatus.CREATED);
    }

    @GetMapping("Ver")
    public ResponseEntity<List<CategoriasDTO>> ListaCategorias() {
        return ResponseEntity.ok(categoriasService.categoriasMostrar());
    }
}
