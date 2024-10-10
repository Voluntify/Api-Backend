package com.upc.avancetp.service;

import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.UsuariosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public UsuarioDTO save (UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuarios usuarios = modelMapper.map(usuarioDTO, Usuarios.class);
        usuarios = usuariosRepository.save(usuarios);
        return modelMapper.map(usuarios, UsuarioDTO.class);
    }
}
