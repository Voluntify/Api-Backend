package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.dto.OrganizacionesPorNombreDTO;
import com.upc.avancetp.dto.OrganizacionesTotalDTO;
import com.upc.avancetp.service.OrganizacionesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OrganizacionesController {
    final OrganizacionesService organizacionesService;

    public OrganizacionesController(OrganizacionesService organizacionesService) {
        this.organizacionesService = organizacionesService;
    }

    @GetMapping("api/user/VerOrganizacionesTodos")
    public ResponseEntity<List<OrganizacionesTotalDTO>> ListaOrganizacionesTotal() {
        return ResponseEntity.ok(organizacionesService.organizacionesTotal());
    }

    @GetMapping("api/user/VerOrganizacionesPorNombre")
    public ResponseEntity<List<OrganizacionesPorNombreDTO>> ListaOrganizacionesTotalPorNombre(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(organizacionesService.organizacionesPorNombre(name));
    }

    @PostMapping("api/RegistroDeOrganizacion")
    public ResponseEntity<OrganizacionesDTO> create(@RequestBody OrganizacionesDTO organizacionesDTO) {
        return new ResponseEntity<>(organizacionesService.save(organizacionesDTO), HttpStatus.CREATED);
    }

    @PutMapping("api/admin/SuscripcionDeOrganizacion")
    public ResponseEntity<OrganizacionesDTO> suscripcionDeOrganizacion(
            @RequestParam Long id,
            @RequestParam boolean suscripcion_activa) {
        OrganizacionesDTO updatedSuscripcion = organizacionesService.suscripcionDeOrganizacion(id, suscripcion_activa);
        return ResponseEntity.ok(updatedSuscripcion);
    }
}
