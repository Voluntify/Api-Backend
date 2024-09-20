package com.upc.avancetp.controller;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.service.US17Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/VerAsistencias")
public class US17Controller {
    final US17Service us17Service;

    public US17Controller(US17Service us17Service) {
        this.us17Service = us17Service;
    }

    @GetMapping("DeTodosLosVoluntariados")
    public ResponseEntity<List<AsistenciasDTO>> ListaAsistencias() {
        return ResponseEntity.ok(us17Service.asistenciasMostrarVoluntariados());
    }

    @GetMapping("PorNombreDeVoluntariado")
    public ResponseEntity<List<AsistenciasDTO>> ListaAsistenciasPorNombre(@RequestParam("name") String name) {
        return ResponseEntity.ok(us17Service.asistenciasporVoluntariadoMostrar(name));
    }
}
