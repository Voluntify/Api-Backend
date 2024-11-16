package com.upc.avancetp.controller;

import com.upc.avancetp.dto.*;
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

    @GetMapping("api/admin/VerOrganizacionesPorNombre")
    public ResponseEntity<List<OrganizacionesPorNombreDTO>> ListaOrganizacionesPorNombre(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(organizacionesService.organizacionesPorNombre(name));
    }

    @GetMapping("api/user/VerOrganizacionesPorNombreB")
    public ResponseEntity<List<OrganizacionesPorNombreDTO>> ListaOrganizacionesPorNombreB(
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

    @PutMapping("api/admin/ContrasenaModificar")
    public ResponseEntity<UsuarioDTO> ContrasenaModificacion(
            @RequestParam Long codigo,
            @RequestParam String contrasena) {
        UsuarioDTO updatedCorreo = organizacionesService.ContrasenaModificacion(codigo, contrasena);
        return ResponseEntity.ok(updatedCorreo);
    }
}
