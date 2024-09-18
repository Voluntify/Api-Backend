package com.upc.avancetp.service;

import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.model.Intereses;
import com.upc.avancetp.repository.InteresRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
