package com.upc.avancetp.service;

import com.upc.avancetp.dto.NotificacionesDTO;
import com.upc.avancetp.model.Notificaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.NotificacionesRepository;
import com.upc.avancetp.repository.UsuariosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class NotificacionesService {
    final NotificacionesRepository notificacionesRepository;
    final UsuariosRepository usuariosRepository;

    public NotificacionesService(NotificacionesRepository notificacionesRepository, UsuariosRepository usuariosRepository) {
        this.notificacionesRepository = notificacionesRepository;
        this.usuariosRepository = usuariosRepository;
    }

    public NotificacionesDTO save(NotificacionesDTO notificacionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Notificaciones notificaciones = modelMapper.map(notificacionesDTO, Notificaciones.class);
        Usuarios usuario = usuariosRepository.findById(notificacionesDTO.getId_usuarios()).orElse(null);

        notificaciones.setUsuarios(usuario);
        notificaciones = notificacionesRepository.save(notificaciones);

        modelMapper.map(notificaciones, notificacionesDTO);
        notificacionesDTO.setId_usuarios(notificaciones.getUsuarios().getCodigo());
        return notificacionesDTO;
    }
}
