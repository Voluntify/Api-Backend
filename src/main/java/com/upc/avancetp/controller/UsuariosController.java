package com.upc.avancetp.controller;

import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.service.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/RegistroDeNuevoUsuario")
public class UsuariosController {
    final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
            this.usuariosService = usuariosService;
        }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.save(usuarioDTO), HttpStatus.CREATED);
    }
}
