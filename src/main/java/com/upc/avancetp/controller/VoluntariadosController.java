package com.upc.avancetp.controller;

import com.upc.avancetp.dto.*;
import com.upc.avancetp.service.VoluntariadosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class VoluntariadosController {
    final VoluntariadosService voluntariadosService;

    public VoluntariadosController(VoluntariadosService voluntariadosService) {
        this.voluntariadosService = voluntariadosService;
    }

    @GetMapping("api/user/VerVoluntariadosTodos")
    public ResponseEntity<List<VoluntariadosTotalDTO>> ListavoluntariadosTotal() {
        return ResponseEntity.ok(voluntariadosService.voluntariadosTotal());
    }

    @GetMapping("api/user/VerVoluntariadosPorNombre")
    public ResponseEntity<List<VoluntariadoPorNombreDTO>> ListavoluntariadosTotalPorNombre(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(voluntariadosService.voluntariadoPorNombre(name));
    }

    @GetMapping("api/admin/VerVoluntariadosPorNombre")
    public ResponseEntity<List<VoluntariadoPorNombreAdminDTODTO>> ListavoluntariadosPorNombre(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(voluntariadosService.VoluntariadosPorNombreAdmin(name));
    }

    @GetMapping("api/user/VerVoluntariadosPorNombreTotal")
    public ResponseEntity<List<VoluntariadosPorNombreTotalDTO>> ListavoluntariadosTotalPorNombreTotal(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(voluntariadosService.voluntariadoPorNombreTotal(name));
    }

    @PostMapping("api/admin/RegistrarVoluntariados")
    public ResponseEntity<VoluntariadosDTO> registrarVoluntariado(@RequestBody VoluntariadosDTO voluntariadosDTO) {
        return new ResponseEntity<>(voluntariadosService.save(voluntariadosDTO), HttpStatus.CREATED);
    }

    @GetMapping("api/admin/VerVoluntariadosPorOrganizacionA")
    public ResponseEntity<List<VoluntariadosPorOrganizacionDTO>> ListavoluntariadosTotalPorOrganizacionA(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(voluntariadosService.voluntariadoPorOrganizacion(name));
    }

    @GetMapping("api/user/VerVoluntariadosPorOrganizacionB")
    public ResponseEntity<List<VoluntariadosPorOrganizacionDTO>> ListavoluntariadosTotalPorOrganizacionB(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(voluntariadosService.voluntariadoPorOrganizacion(name));
    }

    @DeleteMapping("api/admin/EliminarVoluntariadoPorId")
    public ResponseEntity<VoluntariadosDTO> eliminarVoluntariado(@RequestParam Long id) {
        VoluntariadosDTO deleteVoluntariado = voluntariadosService.eliminarVoluntariadoPorId(id);
        return ResponseEntity.ok(deleteVoluntariado);
    }

    @PutMapping("api/admin/fecha_inicioModificacion")
    public ResponseEntity<VoluntariadosDTO> fecha_inicioModificacion(
            @RequestParam Long Id,
            @RequestParam LocalDate fecha_inicio) {
        VoluntariadosDTO updatedDescripcion = voluntariadosService.fecha_inicioModificacion(Id, fecha_inicio);
        return ResponseEntity.ok(updatedDescripcion);
    }

    @PutMapping("api/admin/fecha_finModificacion")
    public ResponseEntity<VoluntariadosDTO> DescripcionModificacion(
            @RequestParam Long Id,
            @RequestParam LocalDate fecha_fin) {
        VoluntariadosDTO updatedDescripcion = voluntariadosService.fecha_finModificacion(Id, fecha_fin);
        return ResponseEntity.ok(updatedDescripcion);
    }

    @PutMapping("api/admin/ubicacionModificacion")
    public ResponseEntity<VoluntariadosDTO> ubicacionModificacion(
            @RequestParam Long Id,
            @RequestParam String ubicacion) {
        VoluntariadosDTO updatedDescripcion = voluntariadosService.ubicacionModificacion(Id, ubicacion);
        return ResponseEntity.ok(updatedDescripcion);
    }

    @PutMapping("api/admin/requisitosModificacion")
    public ResponseEntity<VoluntariadosDTO> requisitosModificacion(
            @RequestParam Long Id,
            @RequestParam String requisitos) {
        VoluntariadosDTO updatedDescripcion = voluntariadosService.requisitosModificacion(Id, requisitos);
        return ResponseEntity.ok(updatedDescripcion);
    }

    @PutMapping("api/admin/DescripcionModificacion")
    public ResponseEntity<VoluntariadosDTO> descripcionModificacion(
            @RequestParam Long Id,
            @RequestParam String descripcion) {
        VoluntariadosDTO updatedDescripcion = voluntariadosService.DescripcionModificacion(Id, descripcion);
        return ResponseEntity.ok(updatedDescripcion);
    }
}
