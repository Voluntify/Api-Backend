package com.upc.avancetp.controller;

import com.upc.avancetp.dto.UsuarioCodigoDTO;
import com.upc.avancetp.dto.UsuarioDTO;
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

    @GetMapping("api/admin/perfil")
    public ResponseEntity<List<UsuarioDTO>> getPerfilAdmin(
            @RequestParam("codigo") Long codigo
    ){
        return ResponseEntity.ok(usuariosService.ObtenerPerfilByAdmin(codigo));
    }

    @GetMapping("api/user/codigoUsuario")
    public ResponseEntity<List<UsuarioCodigoDTO>> getCodigo(
            @RequestParam("name") String name
    ){
        return ResponseEntity.ok(usuariosService.getUsuarioCodigo(name));
    }

    @PutMapping("api/user/CorreoModificacion")
    public ResponseEntity<UsuarioDTO> CorreoModificacion(
            @RequestParam Long usuarioId,
            @RequestParam String correo) {
        UsuarioDTO updatedCorreo = usuariosService.CorreoModificacion(usuarioId, correo);
        return ResponseEntity.ok(updatedCorreo);
    }

    @PutMapping("api/user/TelefonoModificacion")
    public ResponseEntity<UsuarioDTO> TelefonoModificacion(
            @RequestParam Long usuarioId,
            @RequestParam Long telefono) {
        UsuarioDTO updatedTelefono = usuariosService.TelefonoModificacion(usuarioId, telefono);
        return ResponseEntity.ok(updatedTelefono);
    }

    @PutMapping("api/user/DireccionModificacion")
    public ResponseEntity<UsuarioDTO> DireccionModificacion(
            @RequestParam Long usuarioId,
            @RequestParam String direccion) {
        UsuarioDTO updatedDireccion = usuariosService.DireccionModificacion(usuarioId, direccion);
        return ResponseEntity.ok(updatedDireccion);
    }
}
