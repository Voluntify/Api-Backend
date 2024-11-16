package com.upc.avancetp.controller;

import com.upc.avancetp.dto.HabilidadesPorPerfilDTO;
import com.upc.avancetp.dto.InteresesPorPerfilDTO;
import com.upc.avancetp.dto.InteresesPorUsuariosDTO;
import com.upc.avancetp.service.InteresesPorUsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class InteresesPorUsuariosController {
    final InteresesPorUsuariosService interesesPorUsuariosService;

    public InteresesPorUsuariosController(InteresesPorUsuariosService interesesPorUsuariosService) {
        this.interesesPorUsuariosService = interesesPorUsuariosService;
    }

    @PostMapping("api/user/RegistroInteresPorUsuario")
    public ResponseEntity<InteresesPorUsuariosDTO> create(@RequestBody InteresesPorUsuariosDTO interesesPorUsuariosDTO) {
        return new ResponseEntity<>(interesesPorUsuariosService.save(interesesPorUsuariosDTO), HttpStatus.CREATED);
    }

    @GetMapping("api/user/InteresesPorPerfil")
    public ResponseEntity<List<InteresesPorPerfilDTO>> getInteresesPorPerfil(
            @RequestParam("name") String name
    ){
        return ResponseEntity.ok(interesesPorUsuariosService.getInteresesPorPerfil(name));
    }

    @GetMapping("api/admin/InteresesPorPerfilByAdmin")
    public ResponseEntity<List<InteresesPorPerfilDTO>> getInteresesPorPerfilByAdmin(
            @RequestParam("codigo") Long codigo
    ){
        return ResponseEntity.ok(interesesPorUsuariosService.getInteresesPorPerfilByAdmin(codigo));
    }
}
