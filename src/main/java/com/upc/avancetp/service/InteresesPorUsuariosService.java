package com.upc.avancetp.service;

import com.upc.avancetp.dto.HabilidadesPorPerfilDTO;
import com.upc.avancetp.dto.InteresesPorPerfilDTO;
import com.upc.avancetp.dto.InteresesPorUsuariosDTO;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.InteresRepository;
import com.upc.avancetp.repository.InteresesPorUsuariosRepository;
import com.upc.avancetp.repository.UsuariosRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InteresesPorUsuariosService {
    final UsuariosRepository usuariosRepository;
    final InteresRepository interesRepository;
    final InteresesPorUsuariosRepository interesesPorUsuariosRepository;

    public InteresesPorUsuariosService(UsuariosRepository usuariosRepository, InteresRepository interesRepository, InteresesPorUsuariosRepository interesesPorUsuariosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.interesRepository = interesRepository;
        this.interesesPorUsuariosRepository = interesesPorUsuariosRepository;
    }

    public InteresesPorUsuariosDTO save(InteresesPorUsuariosDTO interesesPorUsuariosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        InteresesPorUsuarios interesesPorUsuarios = modelMapper.map(interesesPorUsuariosDTO, InteresesPorUsuarios.class);
        Intereses intereses = interesRepository.findById(interesesPorUsuariosDTO.getId_intereses()).orElse(null);
        Usuarios usuarios = usuariosRepository.findById(interesesPorUsuariosDTO.getId_usuarios()).orElse(null);

        interesesPorUsuarios.setIntereses(intereses);
        interesesPorUsuarios.setUsuarios(usuarios);
        interesesPorUsuarios = interesesPorUsuariosRepository.save(interesesPorUsuarios);

        modelMapper.map(interesesPorUsuarios, interesesPorUsuariosDTO);
        interesesPorUsuariosDTO.setId_intereses(interesesPorUsuarios.getIntereses().getCodigo());
        interesesPorUsuariosDTO.setId_usuarios(interesesPorUsuarios.getUsuarios().getCodigo());
        return interesesPorUsuariosDTO;
    }

    public List<InteresesPorPerfilDTO> getInteresesPorPerfil(String name) {
        List<Tuple> tuplas = interesesPorUsuariosRepository.obtenerInteresesPorUsuario(name);
        List<InteresesPorPerfilDTO> listPerfil = new ArrayList<>();
        InteresesPorPerfilDTO Perfil;
        for (Tuple tuple : tuplas) {
            Perfil = new InteresesPorPerfilDTO(
                    tuple.get("usuario_codigo", Long.class),
                    tuple.get("usuario_nombre", String.class),
                    tuple.get("interes_codigo", Long.class),
                    tuple.get("interes_nombre", String.class)
            );
            listPerfil.add(Perfil);
        }
        return listPerfil;
    }

    public List<InteresesPorPerfilDTO> getInteresesPorPerfilByAdmin(Long codigo) {
        List<Tuple> tuplas = interesesPorUsuariosRepository.obtenerInteresesPorUsuarioByAdmin(codigo);
        List<InteresesPorPerfilDTO> listPerfil = new ArrayList<>();
        InteresesPorPerfilDTO Perfil;
        for (Tuple tuple : tuplas) {
            Perfil = new InteresesPorPerfilDTO(
                    tuple.get("usuario_codigo", Long.class),
                    tuple.get("usuario_nombre", String.class),
                    tuple.get("interes_codigo", Long.class),
                    tuple.get("interes_nombre", String.class)
            );
            listPerfil.add(Perfil);
        }
        return listPerfil;
    }
}
