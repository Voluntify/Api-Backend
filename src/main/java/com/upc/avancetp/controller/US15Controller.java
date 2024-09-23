package com.upc.avancetp.controller;

import com.upc.avancetp.dto.CertificadosDTO;
import com.upc.avancetp.dto.CertificadosPorUsuarioDTO;
import com.upc.avancetp.service.US08Service;
import com.upc.avancetp.service.US15Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class US15Controller {
    final US15Service us15Service;

    public US15Controller(US15Service us15Service) {
        this.us15Service = us15Service;
    }

    @PostMapping("RegistrarCertificados")
    public ResponseEntity<CertificadosDTO> create(@RequestBody CertificadosDTO certificadosDTO) {
        return new ResponseEntity<>(us15Service.save(certificadosDTO), HttpStatus.CREATED);
    }
}
