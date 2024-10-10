package com.upc.avancetp.controller;

import com.upc.avancetp.dto.UsuariosPorHabilidadesDTO;
import com.upc.avancetp.service.UsuariosPorHabilidadesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UsuariosPorHabilidadesController {
    final UsuariosPorHabilidadesService usuariosPorHabilidadesService;

    public UsuariosPorHabilidadesController(UsuariosPorHabilidadesService usuariosPorHabilidadesService) {
        this.usuariosPorHabilidadesService = usuariosPorHabilidadesService;
    }

    @PostMapping("RegistroHabilidadesPorUsuario")
    public ResponseEntity<UsuariosPorHabilidadesDTO> create(@RequestBody UsuariosPorHabilidadesDTO usuariosPorHabilidadesDTO) {
        return new ResponseEntity<>(usuariosPorHabilidadesService.save(usuariosPorHabilidadesDTO), HttpStatus.CREATED);
    }
}
