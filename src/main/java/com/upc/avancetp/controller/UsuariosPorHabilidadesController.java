package com.upc.avancetp.controller;

import com.upc.avancetp.dto.HabilidadesPorPerfilDTO;
import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.dto.UsuariosPorHabilidadesDTO;
import com.upc.avancetp.model.Habilidades;
import com.upc.avancetp.service.UsuariosPorHabilidadesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsuariosPorHabilidadesController {
    final UsuariosPorHabilidadesService usuariosPorHabilidadesService;

    public UsuariosPorHabilidadesController(UsuariosPorHabilidadesService usuariosPorHabilidadesService) {
        this.usuariosPorHabilidadesService = usuariosPorHabilidadesService;
    }

    @PostMapping("api/user/RegistroHabilidadesPorUsuario")
    public ResponseEntity<UsuariosPorHabilidadesDTO> create(@RequestBody UsuariosPorHabilidadesDTO usuariosPorHabilidadesDTO) {
        return new ResponseEntity<>(usuariosPorHabilidadesService.save(usuariosPorHabilidadesDTO), HttpStatus.CREATED);
    }

    @GetMapping("api/user/HabilidadesPorPerfil")
    public ResponseEntity<List<HabilidadesPorPerfilDTO>> getHabilidadesPorPerfil(
            @RequestParam("name") String name
    ){
        return ResponseEntity.ok(usuariosPorHabilidadesService.getHabilidadesPorPerfil(name));
    }

    @GetMapping("api/admin/HabilidadesPorPerfilAdmin")
    public ResponseEntity<List<HabilidadesPorPerfilDTO>> getHabilidadesPorPerfilByAdmin(
            @RequestParam("codigo") Long codigo
    ){
        return ResponseEntity.ok(usuariosPorHabilidadesService.getHabilidadesPorPerfilByAdmin(codigo));
    }
}
