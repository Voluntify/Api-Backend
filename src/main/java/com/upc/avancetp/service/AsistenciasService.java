package com.upc.avancetp.service;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.model.Asistencias;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.model.Voluntariados;
import com.upc.avancetp.repository.AsistenciasRepository;
import com.upc.avancetp.repository.US01Repository;
import com.upc.avancetp.repository.US04Repository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class AsistenciasService {
    final AsistenciasRepository asistenciasRepository;
    final US01Repository us01Repository;
    final US04Repository us04Repository;

    public AsistenciasService(AsistenciasRepository asistenciasRepository, US01Repository us01Repository, US04Repository us04Repository) {
        this.asistenciasRepository = asistenciasRepository;
        this.us01Repository = us01Repository;
        this.us04Repository = us04Repository;
    }

    public AsistenciasDTO save(AsistenciasDTO asistenciasDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Asistencias asistencias = modelMapper.map(asistenciasDTO, Asistencias.class);
        Usuarios usuario = us01Repository.findById(asistenciasDTO.getId_usuarios()).orElse(null);
        Voluntariados voluntariado = us04Repository.findById(asistenciasDTO.getId_voluntariados()).orElse(null);

        asistencias.setUsuarios(usuario);
        asistencias.setVoluntariados(voluntariado);
        asistencias = asistenciasRepository.save(asistencias);

        modelMapper.map(asistencias, asistenciasDTO);
        asistenciasDTO.setId_usuarios(asistencias.getUsuarios().getCodigo());
        asistenciasDTO.setId_voluntariados(asistencias.getVoluntariados().getCodigo());
        return asistenciasDTO;
    }
}

