package com.upc.avancetp.controller;

import com.upc.avancetp.dto.VoluntariadosDTO;
import com.upc.avancetp.service.US11Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class US11Controller {

    private final US11Service us11Service;

    public US11Controller(US11Service us11Service) {
        this.us11Service = us11Service;
    }

    @PostMapping("RegistrarVoluntariados")
    public ResponseEntity<VoluntariadosDTO> registrarVoluntariado(@RequestBody VoluntariadosDTO voluntariadosDTO) {
        return new ResponseEntity<>(us11Service.save(voluntariadosDTO), HttpStatus.CREATED);
    }
}
