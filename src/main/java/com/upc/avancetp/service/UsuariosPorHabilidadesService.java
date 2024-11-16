package com.upc.avancetp.service;

import com.upc.avancetp.dto.HabilidadesPorPerfilDTO;
import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.dto.UsuariosPorHabilidadesDTO;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.HabilidadesRepository;
import com.upc.avancetp.repository.UsuariosPorHabilidadesRepository;
import com.upc.avancetp.repository.UsuariosRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<HabilidadesPorPerfilDTO> getHabilidadesPorPerfil(String name) {
        List<Tuple> tuplas = usuariosPorHabilidadesRepository.obtenerHabilidadesPorUsuario(name);
        List<HabilidadesPorPerfilDTO> listPerfil = new ArrayList<>();
        HabilidadesPorPerfilDTO Perfil;
        for (Tuple tuple : tuplas) {
            Perfil = new HabilidadesPorPerfilDTO(
                    tuple.get("usuario_codigo", Long.class),
                    tuple.get("usuario_nombre", String.class),
                    tuple.get("habilidad_codigo", Long.class),
                    tuple.get("habilidad_nombre", String.class)
            );
            listPerfil.add(Perfil);
        }
        return listPerfil;
    }

    public List<HabilidadesPorPerfilDTO> getHabilidadesPorPerfilByAdmin(Long codigo) {
        List<Tuple> tuplas = usuariosPorHabilidadesRepository.obtenerHabilidadesPorUsuarioByAdmin(codigo);
        List<HabilidadesPorPerfilDTO> listPerfil = new ArrayList<>();
        HabilidadesPorPerfilDTO Perfil;
        for (Tuple tuple : tuplas) {
            Perfil = new HabilidadesPorPerfilDTO(
                    tuple.get("usuario_codigo", Long.class),
                    tuple.get("usuario_nombre", String.class),
                    tuple.get("habilidad_codigo", Long.class),
                    tuple.get("habilidad_nombre", String.class)
            );
            listPerfil.add(Perfil);
        }
        return listPerfil;
    }
}
