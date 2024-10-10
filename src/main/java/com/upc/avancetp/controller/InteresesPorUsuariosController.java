package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InteresesPorUsuariosDTO;
import com.upc.avancetp.service.InteresesPorUsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class InteresesPorUsuariosController {
    final InteresesPorUsuariosService interesesPorUsuariosService;

    public InteresesPorUsuariosController(InteresesPorUsuariosService interesesPorUsuariosService) {
        this.interesesPorUsuariosService = interesesPorUsuariosService;
    }

    @PostMapping("RegistroInteresPorUsuario")
    public ResponseEntity<InteresesPorUsuariosDTO> create(@RequestBody InteresesPorUsuariosDTO interesesPorUsuariosDTO) {
        return new ResponseEntity<>(interesesPorUsuariosService.save(interesesPorUsuariosDTO), HttpStatus.CREATED);
    }
}
