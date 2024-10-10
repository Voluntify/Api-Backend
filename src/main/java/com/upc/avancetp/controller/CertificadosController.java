package com.upc.avancetp.controller;

import com.upc.avancetp.dto.CertificadosDTO;
import com.upc.avancetp.dto.CertificadosPorUsuarioDTO;
import com.upc.avancetp.service.CertificadosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class CertificadosController {
    final CertificadosService certificadosService;

    public CertificadosController(CertificadosService certificadosService) {
        this.certificadosService = certificadosService;
    }

    @GetMapping("VerCertificadosPorUsuario")
    public ResponseEntity<List<CertificadosPorUsuarioDTO>> ListaCertificadosPorUsuario(
            @RequestParam("Codigo_Usuario") Long Codigo_Usuario) {
        return ResponseEntity.ok(certificadosService.certificadosPorUsuarioList(Codigo_Usuario));
    }

    @PostMapping("RegistrarCertificados")
    public ResponseEntity<CertificadosDTO> create(@RequestBody CertificadosDTO certificadosDTO) {
        return new ResponseEntity<>(certificadosService.save(certificadosDTO), HttpStatus.CREATED);
    }
}
