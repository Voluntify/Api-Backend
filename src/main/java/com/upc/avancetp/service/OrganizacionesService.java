package com.upc.avancetp.service;

import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.model.Intereses;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.repository.OrganizacionesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrganizacionesService {
    final OrganizacionesRepository organizacionesRepository;

    public OrganizacionesService(OrganizacionesRepository organizacionesRepository) {
        this.organizacionesRepository = organizacionesRepository;
    }

    public OrganizacionesDTO save(OrganizacionesDTO organizacionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Organizaciones organizaciones = modelMapper.map(organizacionesDTO, Organizaciones.class);
        organizaciones = organizacionesRepository.save(organizaciones);
        return modelMapper.map(organizaciones, OrganizacionesDTO.class);
    }
}
