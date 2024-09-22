package com.upc.avancetp.service;

import com.upc.avancetp.dto.NotificacionesDTO;
import com.upc.avancetp.model.Notificaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.US01Repository;
import com.upc.avancetp.repository.US07Repository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class US07Service {
    final US07Repository us07Repository;
    final US01Repository us01Repository;

    public US07Service(US07Repository us07Repository, US01Repository us01Repository) {
        this.us07Repository = us07Repository;
        this.us01Repository = us01Repository;
    }

    public NotificacionesDTO save(NotificacionesDTO notificacionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Notificaciones notificaciones = modelMapper.map(notificacionesDTO, Notificaciones.class);
        Usuarios usuario = us01Repository.findById(notificacionesDTO.getId_usuarios()).orElse(null);

        notificaciones.setUsuarios(usuario);
        notificaciones = us07Repository.save(notificaciones);

        modelMapper.map(notificaciones, notificacionesDTO);
        notificacionesDTO.setId_usuarios(notificaciones.getUsuarios().getCodigo());
        return notificacionesDTO;
    }
}
