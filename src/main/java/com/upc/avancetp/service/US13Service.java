package com.upc.avancetp.service;

import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.model.Inscripciones;
import com.upc.avancetp.repository.US13Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class US13Service {

    final US13Repository us13Repository;

    public US13Service(US13Repository us13Repository) {
        this.us13Repository = us13Repository;
    }

    public InscripcionesDTO approveOrRejectInscripcion(Long inscripcionId, boolean estado) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Inscripciones> inscripcionOptional = us13Repository.findById(inscripcionId);

        if (inscripcionOptional.isPresent()) {
            Inscripciones inscripcion = inscripcionOptional.get();
            inscripcion.setEstado(estado);
            Inscripciones updatedInscripcion = us13Repository.save(inscripcion);
            return modelMapper.map(updatedInscripcion, InscripcionesDTO.class);
        }
        throw new IllegalArgumentException("Inscripción no encontrada.");
    }
}
