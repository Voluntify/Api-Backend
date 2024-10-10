package com.upc.avancetp.service;

import com.upc.avancetp.dto.InteresesPorUsuariosDTO;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.InteresRepository;
import com.upc.avancetp.repository.InteresesPorUsuariosRepository;
import com.upc.avancetp.repository.UsuariosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
