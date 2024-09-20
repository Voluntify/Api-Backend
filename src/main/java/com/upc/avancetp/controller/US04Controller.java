package com.upc.avancetp.controller;

import com.upc.avancetp.dto.VoluntariadoPorNombreDTO;
import com.upc.avancetp.dto.VoluntariadosTotalDTO;
import com.upc.avancetp.service.US04Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/VerVoluntariados")
public class US04Controller {
    final US04Service us04Service;

    public US04Controller(US04Service us04Service) {
        this.us04Service = us04Service;
    }

    @GetMapping("Todos")
    public ResponseEntity<List<VoluntariadosTotalDTO>> ListavoluntariadosTotal() {
        return ResponseEntity.ok(us04Service.voluntariadosTotal());
    }

    @GetMapping("PorNombre")
    public ResponseEntity<List<VoluntariadoPorNombreDTO>> ListavoluntariadosTotalPorNombre(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(us04Service.voluntariadoPorNombre(name));
    }

}
