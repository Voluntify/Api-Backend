package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.service.US06Service;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/InscripcionAVoluntariado")
public class US06Controller {
    final US06Service us06Service;

    public US06Controller(US06Service us06Service) {
        this.us06Service = us06Service;
    }

    @PostMapping
    public ResponseEntity<InscripcionesDTO> create(@RequestBody InscripcionesDTO inscripcionesDTO) {
        return new ResponseEntity<>(us06Service.save(inscripcionesDTO), HttpStatus.CREATED);
    }
}
