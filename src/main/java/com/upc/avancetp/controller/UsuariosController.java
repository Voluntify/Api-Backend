package com.upc.avancetp.controller;

import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.dto.VoluntariadoPorNombreDTO;
import com.upc.avancetp.service.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsuariosController {
    final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
            this.usuariosService = usuariosService;
        }

    @PostMapping("api/RegistroDeNuevoUsuario")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.save(usuarioDTO), HttpStatus.CREATED);
    }

    @GetMapping("api/user/perfil")
    public ResponseEntity<List<UsuarioDTO>> getPerfil(
            @RequestParam("name") String name
    ){
        return ResponseEntity.ok(usuariosService.getPerfil(name));
    }
}
