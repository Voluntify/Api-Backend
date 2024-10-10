package com.upc.avancetp.controller;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.dto.VoluntariadoPorNombreDTO;
import com.upc.avancetp.dto.VoluntariadosDTO;
import com.upc.avancetp.dto.VoluntariadosTotalDTO;
import com.upc.avancetp.service.VoluntariadosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("api/admin/RegistrarVoluntariados")
    public ResponseEntity<VoluntariadosDTO> registrarVoluntariado(@RequestBody VoluntariadosDTO voluntariadosDTO) {
        return new ResponseEntity<>(voluntariadosService.save(voluntariadosDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("api/admin/EliminarVoluntariadoPorId")
    public ResponseEntity<VoluntariadosDTO> eliminarVoluntariado(@RequestParam Long id) {
        VoluntariadosDTO deleteVoluntariado = voluntariadosService.eliminarVoluntariadoPorId(id);
        return ResponseEntity.ok(deleteVoluntariado);
    }
}
