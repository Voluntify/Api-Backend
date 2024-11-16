package com.upc.avancetp.controller;

import com.upc.avancetp.dto.AsistenciaPorUsuarioDTO;
import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.dto.InteresesPorPerfilDTO;
import com.upc.avancetp.service.AsistenciasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AsistenciasController {
    final AsistenciasService asistenciasService;

    public AsistenciasController(AsistenciasService asistenciasService) {
        this.asistenciasService = asistenciasService;
    }

    @PostMapping("api/admin/RegistroDeAsistencias")
    public ResponseEntity<AsistenciasDTO> create(@RequestBody AsistenciasDTO asistenciasDTO) {
        return new ResponseEntity<>(asistenciasService.save(asistenciasDTO), HttpStatus.CREATED);
    }

    @GetMapping("api/admin/VerAsistenciasDeTodosLosVoluntariados")
    public ResponseEntity<List<AsistenciasDTO>> ListaAsistencias() {
        return ResponseEntity.ok(asistenciasService.asistenciasMostrarVoluntariados());
    }

    @GetMapping("api/admin/VerAsistenciasPorNombreDeVoluntariado")
    public ResponseEntity<List<AsistenciasDTO>> ListaAsistenciasPorNombre(@RequestParam("name") String name) {
        return ResponseEntity.ok(asistenciasService.asistenciasporVoluntariadoMostrar(name));
    }

    @GetMapping("api/user/VoluntariadosRealizadosPorUsuario")
    public ResponseEntity<List<AsistenciaPorUsuarioDTO>> NombreDeVoluntariadoRealizado(
            @RequestParam("name") String name
    ){
        return ResponseEntity.ok(asistenciasService.NombreDeVoluntariadoRealizado(name));
    }

    @GetMapping("api/admin/VoluntariadosRealizadosPorUsuarioByAdmin")
    public ResponseEntity<List<AsistenciaPorUsuarioDTO>> NombreDeVoluntariadoRealizadoByAdmin(
            @RequestParam("codigo") Long codigo
    ){
        return ResponseEntity.ok(asistenciasService.NombreDeVoluntariadoRealizadoByAdmin(codigo));
    }
}
