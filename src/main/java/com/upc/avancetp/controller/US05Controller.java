package com.upc.avancetp.controller;

import com.upc.avancetp.dto.OrganizacionesPorNombreDTO;
import com.upc.avancetp.dto.OrganizacionesTotalDTO;
import com.upc.avancetp.service.US05Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class US05Controller {
    final US05Service us05Service;

    public US05Controller(US05Service us05Service) {
        this.us05Service = us05Service;
    }

    @GetMapping("VerOrganizacionesTodos")
    public ResponseEntity<List<OrganizacionesTotalDTO>> ListaOrganizacionesTotal() {
        return ResponseEntity.ok(us05Service.organizacionesTotal());
    }

    @GetMapping("VerOrganizacionesPorNombre")
    public ResponseEntity<List<OrganizacionesPorNombreDTO>> ListaOrganizacionesTotalPorNombre(
            @RequestParam("name") String name) {
        return ResponseEntity.ok(us05Service.organizacionesPorNombre(name));
    }
}
