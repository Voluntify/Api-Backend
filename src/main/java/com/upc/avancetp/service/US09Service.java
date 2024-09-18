package com.upc.avancetp.service;

import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.repository.OrganizacionesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrganizacionService {

    private final OrganizacionesRepository organizacionesRepository;
    private final ModelMapper modelMapper;


    public OrganizacionService(OrganizacionesRepository organizacionesRepository) {
        this.organizacionesRepository = organizacionesRepository;
        this.modelMapper = new ModelMapper();
    }

    public OrganizacionesDTO save(OrganizacionesDTO organizacionesDTO) {

        Organizaciones organizacion = modelMapper.map(organizacionesDTO, Organizaciones.class);
        organizacion = organizacionesRepository.save(organizacion);
        return modelMapper.map(organizacion, OrganizacionesDTO.class);
    }
}
