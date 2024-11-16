package com.upc.avancetp.service;

import com.upc.avancetp.dto.HabilidadesDTO;
import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.dto.UsuarioCodigoDTO;
import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.UsuariosRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<UsuarioDTO> getPerfil(String name) {
        List<Tuple> tuplas = usuariosRepository.ObtenerPerfil(name);
        List<UsuarioDTO> listPerfil = new ArrayList<>();
        UsuarioDTO Perfil;
        for (Tuple tuple : tuplas) {
            java.sql.Date DatePerfil = tuple.get("fecha_registro", java.sql.Date.class);
            LocalDate fecha = DatePerfil.toLocalDate();
            Perfil = new UsuarioDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class),
                    tuple.get("apellido", String.class),
                    tuple.get("correo", String.class),
                    tuple.get("contrasena", String.class),
                    tuple.get("telefono", Long.class),
                    tuple.get("direccion", String.class),
                    fecha
            );
            listPerfil.add(Perfil);
        }
        return listPerfil;
    }

    public List<UsuarioDTO> ObtenerPerfilByAdmin(Long codigo) {
        List<Tuple> tuplas = usuariosRepository.ObtenerPerfilByAdmin(codigo);
        List<UsuarioDTO> listPerfil = new ArrayList<>();
        UsuarioDTO Perfil;
        for (Tuple tuple : tuplas) {
            java.sql.Date DatePerfil = tuple.get("fecha_registro", java.sql.Date.class);
            LocalDate fecha = DatePerfil.toLocalDate();
            Perfil = new UsuarioDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class),
                    tuple.get("apellido", String.class),
                    tuple.get("correo", String.class),
                    tuple.get("contrasena", String.class),
                    tuple.get("telefono", Long.class),
                    tuple.get("direccion", String.class),
                    fecha
            );
            listPerfil.add(Perfil);
        }
        return listPerfil;
    }

    public List<UsuarioCodigoDTO> getUsuarioCodigo(String name) {
        List<Tuple> tuplas = usuariosRepository.ObtenerCodigoUsuario(name);
        List<UsuarioCodigoDTO> listPerfil = new ArrayList<>();
        UsuarioCodigoDTO Perfil;
        for (Tuple tuple : tuplas) {
            Perfil = new UsuarioCodigoDTO(
                    tuple.get("codigo", Long.class)
            );
            listPerfil.add(Perfil);
        }
        return listPerfil;
    }

    public UsuarioDTO CorreoModificacion(Long usuarioId, String correo) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Usuarios> correoNew = usuariosRepository.findById(usuarioId);

        if (correoNew.isPresent()) {
            Usuarios usuarios = correoNew.get();
            usuarios.setCorreo(correo);
            Usuarios updatedCorreo = usuariosRepository.save(usuarios);
            return modelMapper.map(updatedCorreo, UsuarioDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    public UsuarioDTO TelefonoModificacion(Long usuarioId, Long telefono) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Usuarios> TelefonoNew = usuariosRepository.findById(usuarioId);

        if (TelefonoNew.isPresent()) {
            Usuarios usuarios = TelefonoNew.get();
            usuarios.setTelefono(telefono);
            Usuarios updatedTelefono = usuariosRepository.save(usuarios);
            return modelMapper.map(updatedTelefono, UsuarioDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    public UsuarioDTO DireccionModificacion(Long usuarioId, String direccion) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Usuarios> DireccionNew = usuariosRepository.findById(usuarioId);

        if (DireccionNew.isPresent()) {
            Usuarios usuarios = DireccionNew.get();
            usuarios.setDireccion(direccion);
            Usuarios updatedDireccion = usuariosRepository.save(usuarios);
            return modelMapper.map(updatedDireccion, UsuarioDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }
}
