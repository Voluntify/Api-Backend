package com.upc.avancetp.service;

import com.upc.avancetp.dto.HabilidadesDTO;
import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.model.Intereses;
import com.upc.avancetp.repository.InteresRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InteresService {
    final InteresRepository interesRepository;

    public InteresService(InteresRepository interesRepository) {
        this.interesRepository = interesRepository;
    }

    public InteresDTO save(InteresDTO interesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Intereses intereses = modelMapper.map(interesDTO, Intereses.class);
        intereses = interesRepository.save(intereses);
        return modelMapper.map(intereses, InteresDTO.class);
    }

    public List<InteresDTO> interesMostrar() {
        List<Tuple> tuplas = interesRepository.interesesTotal();
        List<InteresDTO> listRecaud = new ArrayList<>();
        InteresDTO recaud;
        for (Tuple tuple : tuplas) {
            recaud = new InteresDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class)
            );
            listRecaud.add(recaud);
        }
        return listRecaud;
    }
}
