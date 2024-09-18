package com.upc.avancetp.service;

import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.US01Repository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class US01Service {
    final US01Repository us01Repository;

    public US01Service(US01Repository us01Repository) {
        this.us01Repository = us01Repository;
    }

    public UsuarioDTO save (UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuarios usuarios = modelMapper.map(usuarioDTO, Usuarios.class);
        usuarios = us01Repository.save(usuarios);
        return modelMapper.map(usuarios, UsuarioDTO.class);
    }
}
