package com.upc.avancetp.controller;

import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizaciones")
public class OrganizacionController {

    @Autowired
    private OrganizacionService organizacionService;

    @PostMapping("/registro")
    public ResponseEntity<OrganizacionesDTO> registrarOrganizacion(@RequestBody OrganizacionesDTO organizacionesDTO) {
        OrganizacionesDTO nuevaOrganizacion = organizacionService.save(organizacionesDTO);
        return ResponseEntity.ok(nuevaOrganizacion);
    }
}
