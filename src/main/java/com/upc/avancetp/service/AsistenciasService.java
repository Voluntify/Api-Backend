package com.upc.avancetp.service;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.model.Asistencias;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.model.Voluntariados;
import com.upc.avancetp.repository.AsistenciasRepository;

import com.upc.avancetp.repository.UsuariosRepository;
import com.upc.avancetp.repository.VoluntariadosRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class AsistenciasService {
    final AsistenciasRepository asistenciasRepository;
    final UsuariosRepository usuariosRepository;
    final VoluntariadosRepository voluntariadosRepository;

    public AsistenciasService(AsistenciasRepository asistenciasRepository, UsuariosRepository usuariosRepository, VoluntariadosRepository voluntariadosRepository) {
        this.asistenciasRepository = asistenciasRepository;
        this.usuariosRepository = usuariosRepository;
        this.voluntariadosRepository = voluntariadosRepository;
    }

    public AsistenciasDTO save(AsistenciasDTO asistenciasDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Asistencias asistencias = modelMapper.map(asistenciasDTO, Asistencias.class);
        Usuarios usuario = usuariosRepository.findById(asistenciasDTO.getId_usuarios()).orElse(null);
        Voluntariados voluntariado = voluntariadosRepository.findById(asistenciasDTO.getId_voluntariados()).orElse(null);

        asistencias.setUsuarios(usuario);
        asistencias.setVoluntariados(voluntariado);
        asistencias = asistenciasRepository.save(asistencias);

        modelMapper.map(asistencias, asistenciasDTO);
        asistenciasDTO.setId_usuarios(asistencias.getUsuarios().getCodigo());
        asistenciasDTO.setId_voluntariados(asistencias.getVoluntariados().getCodigo());
        return asistenciasDTO;
    }

    public List<AsistenciasDTO> asistenciasMostrarVoluntariados() {
        List<Tuple> tuplas = asistenciasRepository.asistenciasTotalVoluntariado();
        List<AsistenciasDTO> listRecaud = new ArrayList<>();
        AsistenciasDTO recaud;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateAsistencia = tuple.get("fecha", java.sql.Date.class);
            LocalDate fecha = DateAsistencia.toLocalDate();
            recaud = new AsistenciasDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado_asistencia", Boolean.class),
                    fecha,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listRecaud.add(recaud);
        }
        return listRecaud;
    }

    public List<AsistenciasDTO> asistenciasporVoluntariadoMostrar(String name) {
        List<Tuple> tuplas = asistenciasRepository.asistenciasPorVoluntariado(name);
        List<AsistenciasDTO> listRecaud = new ArrayList<>();
        AsistenciasDTO recaud;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateAsistencia = tuple.get("fecha", java.sql.Date.class);
            LocalDate fecha = DateAsistencia.toLocalDate();
            recaud = new AsistenciasDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado_asistencia", Boolean.class),
                    fecha,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listRecaud.add(recaud);
        }
        return listRecaud;
    }
}

