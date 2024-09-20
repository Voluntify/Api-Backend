package com.upc.avancetp.controller;

import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.service.US09Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/RegistroDeOrganizacion")
public class US09Controller {
    final US09Service us09Service;

    public US09Controller(US09Service us09Service) {
        this.us09Service = us09Service;
    }

    @PostMapping
    public ResponseEntity<OrganizacionesDTO> create(@RequestBody OrganizacionesDTO organizacionesDTO) {
        return new ResponseEntity<>(us09Service.save(organizacionesDTO), HttpStatus.CREATED);
    }
}
