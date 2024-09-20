package com.upc.avancetp.service;

import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.repository.US09Repository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class US09Service {
    final US09Repository us09Repository;

    public US09Service(US09Repository us09Repository) {
        this.us09Repository = us09Repository;
    }

    public OrganizacionesDTO save(OrganizacionesDTO organizacionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Organizaciones organizaciones = modelMapper.map(organizacionesDTO, Organizaciones.class);
        organizaciones = us09Repository.save(organizaciones);
        return modelMapper.map(organizaciones, OrganizacionesDTO.class);
    }

}
