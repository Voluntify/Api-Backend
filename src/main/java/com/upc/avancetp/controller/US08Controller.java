package com.upc.avancetp.controller;

import com.upc.avancetp.dto.CertificadosDTO;
import com.upc.avancetp.dto.CertificadosPorUsuarioDTO;
import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.dto.VoluntariadoPorNombreDTO;
import com.upc.avancetp.service.US08Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class US08Controller {
    final US08Service us08Service;

    public US08Controller(US08Service us08Service) {
        this.us08Service = us08Service;
    }

    @GetMapping("VerCertificadosPorUsuario")
    public ResponseEntity<List<CertificadosPorUsuarioDTO>> ListaCertificadosPorUsuario(
            @RequestParam("Codigo_Usuario") Long Codigo_Usuario) {
        return ResponseEntity.ok(us08Service.certificadosPorUsuarioList(Codigo_Usuario));
    }
}
