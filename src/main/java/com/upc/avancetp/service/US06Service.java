package com.upc.avancetp.service;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.dto.OrganizacionesTotalDTO;
import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.model.Inscripciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.model.Voluntariados;
import com.upc.avancetp.repository.US01Repository;
import com.upc.avancetp.repository.US04Repository;
import com.upc.avancetp.repository.US06Repository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class US06Service {
    final US06Repository us06Repository;
    final US01Repository us01Repository;
    final US04Repository us04Repository;

    public US06Service(US06Repository us06Repository, US01Repository us01Repository, US04Repository us04Repository) {
        this.us06Repository = us06Repository;
        this.us01Repository = us01Repository;
        this.us04Repository = us04Repository;
    }

    public InscripcionesDTO save(InscripcionesDTO inscripcionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Inscripciones inscripciones = modelMapper.map(inscripcionesDTO, Inscripciones.class);
        Usuarios usuario = us01Repository.findById(inscripcionesDTO.getId_usuarios()).orElse(null);
        Voluntariados voluntariado = us04Repository.findById(inscripcionesDTO.getId_voluntariados()).orElse(null);

        inscripciones.setUsuarios(usuario);
        inscripciones.setVoluntariados(voluntariado);
        inscripciones = us06Repository.save(inscripciones);

        modelMapper.map(inscripciones, inscripcionesDTO);
        inscripcionesDTO.setId_usuarios(inscripciones.getUsuarios().getCodigo());
        inscripcionesDTO.setId_voluntariados(inscripciones.getVoluntariados().getCodigo());
        return inscripcionesDTO;
    }
}
