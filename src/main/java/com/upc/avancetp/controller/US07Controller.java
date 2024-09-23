package com.upc.avancetp.controller;

import com.upc.avancetp.dto.NotificacionesDTO;
import com.upc.avancetp.service.US07Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class US07Controller {
    final US07Service us07Service;

    public US07Controller(US07Service us07Service) {
        this.us07Service = us07Service;
    }

    @PostMapping("/RegistrarNotificaciones")
    public ResponseEntity<NotificacionesDTO> create(@RequestBody NotificacionesDTO notificacionesDTO) {
        return new ResponseEntity<>(us07Service.save(notificacionesDTO), HttpStatus.CREATED);
    }
}
