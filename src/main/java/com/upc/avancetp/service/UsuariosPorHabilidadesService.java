package com.upc.avancetp.service;

import com.upc.avancetp.dto.UsuariosPorHabilidadesDTO;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.HabilidadesRepository;
import com.upc.avancetp.repository.UsuariosPorHabilidadesRepository;
import com.upc.avancetp.repository.UsuariosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuariosPorHabilidadesService {
    final UsuariosRepository usuariosRepository;
    final HabilidadesRepository habilidadesRepository;
    final UsuariosPorHabilidadesRepository usuariosPorHabilidadesRepository;

    public UsuariosPorHabilidadesService(UsuariosRepository usuariosRepository, HabilidadesRepository habilidadesRepository, UsuariosPorHabilidadesRepository usuariosPorHabilidadesRepository) {
        this.usuariosRepository = usuariosRepository;
        this.habilidadesRepository = habilidadesRepository;
        this.usuariosPorHabilidadesRepository = usuariosPorHabilidadesRepository;
    }

    public UsuariosPorHabilidadesDTO save(UsuariosPorHabilidadesDTO usuariosPorHabilidadesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        UsuariosPorHabilidades usuariosPorHabilidades = modelMapper.map(usuariosPorHabilidadesDTO, UsuariosPorHabilidades.class);
        Habilidades habilidades = habilidadesRepository.findById(usuariosPorHabilidadesDTO.getId_habilidades()).orElse(null);
        Usuarios usuarios = usuariosRepository.findById(usuariosPorHabilidadesDTO.getId_usuarios()).orElse(null);

        usuariosPorHabilidades.setHabilidades(habilidades);
        usuariosPorHabilidades.setUsuarios(usuarios);
        usuariosPorHabilidades = usuariosPorHabilidadesRepository.save(usuariosPorHabilidades);

        modelMapper.map(usuariosPorHabilidades, usuariosPorHabilidadesDTO);
        usuariosPorHabilidadesDTO.setId_habilidades(usuariosPorHabilidades.getHabilidades().getCodigo());
        usuariosPorHabilidadesDTO.setId_usuarios(usuariosPorHabilidades.getUsuarios().getCodigo());
        return usuariosPorHabilidadesDTO;
    }
}
