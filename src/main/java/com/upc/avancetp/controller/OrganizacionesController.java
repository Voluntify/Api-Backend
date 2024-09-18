package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.service.OrganizacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/RegistroDeOrganizacion")
public class OrganizacionesController {
    final OrganizacionesService organizacionesService;

    public OrganizacionesController(OrganizacionesService organizacionesService) {
        this.organizacionesService = organizacionesService;
    }

    @PostMapping
    public ResponseEntity<OrganizacionesDTO> create(@RequestBody OrganizacionesDTO organizacionesDTO) {
        return new ResponseEntity<>(organizacionesService.save(organizacionesDTO), HttpStatus.CREATED);
    }
}
