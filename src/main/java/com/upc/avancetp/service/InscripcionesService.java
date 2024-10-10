package com.upc.avancetp.service;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.model.Inscripciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.model.Voluntariados;
import com.upc.avancetp.repository.*;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionesService {
    final InscripcionesRepository inscripcionesRepository;
    final UsuariosRepository usuariosRepository;
    final VoluntariadosRepository voluntariadosRepository;

    public InscripcionesService(InscripcionesRepository inscripcionesRepository, UsuariosRepository usuariosRepository, VoluntariadosRepository voluntariadosRepository) {
        this.inscripcionesRepository = inscripcionesRepository;
        this.usuariosRepository = usuariosRepository;
        this.voluntariadosRepository = voluntariadosRepository;
    }

    public InscripcionesDTO save(InscripcionesDTO inscripcionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Inscripciones inscripciones = modelMapper.map(inscripcionesDTO, Inscripciones.class);
        Usuarios usuario = usuariosRepository.findById(inscripcionesDTO.getId_usuarios()).orElse(null);
        Voluntariados voluntariado = voluntariadosRepository.findById(inscripcionesDTO.getId_voluntariados()).orElse(null);

        inscripciones.setUsuarios(usuario);
        inscripciones.setVoluntariados(voluntariado);
        inscripciones = inscripcionesRepository.save(inscripciones);

        modelMapper.map(inscripciones, inscripcionesDTO);
        inscripcionesDTO.setId_usuarios(inscripciones.getUsuarios().getCodigo());
        inscripcionesDTO.setId_voluntariados(inscripciones.getVoluntariados().getCodigo());
        return inscripcionesDTO;
    }


    public List<InscripcionesDTO> inscripcionesMostrarPorVoluntariado(String name) {
        List<Tuple> tuplas = inscripcionesRepository.inscripcionesPorVoluntariado(name);
        List<InscripcionesDTO> listInscr = new ArrayList<>();
        InscripcionesDTO iscripcion;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateInscripcion = tuple.get("fecha_inscripcion", java.sql.Date.class);
            LocalDate fecha_inscripcion = DateInscripcion.toLocalDate();
            iscripcion = new InscripcionesDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado", Boolean.class),
                    fecha_inscripcion,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listInscr.add(iscripcion);
        }
        return listInscr;
    }

    public List<InscripcionesDTO> inscripcionesMostrarPorUsuario(String name) {
        List<Tuple> tuplas = inscripcionesRepository.inscripcionesPorUsuario(name);
        List<InscripcionesDTO> listInscr = new ArrayList<>();
        InscripcionesDTO iscripcion;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateInscripcion = tuple.get("fecha_inscripcion", java.sql.Date.class);
            LocalDate fecha_inscripcion = DateInscripcion.toLocalDate();
            iscripcion = new InscripcionesDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado", Boolean.class),
                    fecha_inscripcion,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listInscr.add(iscripcion);
        }
        return listInscr;
    }

    public InscripcionesDTO approveOrRejectInscripcion(Long inscripcionId, boolean estado) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Inscripciones> inscripcionOptional = inscripcionesRepository.findById(inscripcionId);

        if (inscripcionOptional.isPresent()) {
            Inscripciones inscripcion = inscripcionOptional.get();
            inscripcion.setEstado(estado);
            Inscripciones updatedInscripcion = inscripcionesRepository.save(inscripcion);
            return modelMapper.map(updatedInscripcion, InscripcionesDTO.class);
        }
        throw new IllegalArgumentException("Inscripción no encontrada.");
    }
}
