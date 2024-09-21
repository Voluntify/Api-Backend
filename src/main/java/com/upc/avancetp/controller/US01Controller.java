package com.upc.avancetp.controller;

import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.service.US01Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/RegistroDeNuevoUsuario")
public class US01Controller {
    final US01Service us01Service;

    public US01Controller(US01Service us01Service) {
        this.us01Service = us01Service;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(us01Service.save(usuarioDTO), HttpStatus.CREATED);
    }
}
