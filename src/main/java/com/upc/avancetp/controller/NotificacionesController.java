package com.upc.avancetp.controller;

import com.upc.avancetp.dto.NotificacionesDTO;
import com.upc.avancetp.service.NotificacionesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class NotificacionesController {
    final NotificacionesService notificacionesService;

    public NotificacionesController(NotificacionesService notificacionesService) {
        this.notificacionesService = notificacionesService;
    }

    @PostMapping("/RegistrarNotificaciones")
    public ResponseEntity<NotificacionesDTO> create(@RequestBody NotificacionesDTO notificacionesDTO) {
        return new ResponseEntity<>(notificacionesService.save(notificacionesDTO), HttpStatus.CREATED);
    }
}
