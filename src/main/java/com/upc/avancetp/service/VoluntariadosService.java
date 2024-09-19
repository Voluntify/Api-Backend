package com.upc.avancetp.service;

import com.upc.avancetp.dto.VoluntariadosDTO;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Voluntariados;
import com.upc.avancetp.repository.OrganizacionesRepository;
import com.upc.avancetp.repository.VoluntariadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VoluntariadosService {
    private final VoluntariadosRepository voluntariadosRepository;
    private final OrganizacionesRepository organizacionesRepository;
    private final ModelMapper modelMapper;

    public VoluntariadosService(VoluntariadosRepository voluntariadosRepository, OrganizacionesRepository organizacionesRepository, ModelMapper modelMapper) {
        this.voluntariadosRepository = voluntariadosRepository;
        this.organizacionesRepository = organizacionesRepository;
        this.modelMapper = modelMapper;
    }

    public VoluntariadosDTO save(VoluntariadosDTO voluntariadosDTO) {

        Organizaciones organizaciones = organizacionesRepository.findById(voluntariadosDTO.getId_organizaciones())
                .orElseThrow(() -> new RuntimeException("Organización no encontrada"));
        Voluntariados voluntariados = modelMapper.map(voluntariadosDTO, Voluntariados.class);
        voluntariados.setOrganizaciones(organizaciones); // Asignamos la organización existente
        voluntariados = voluntariadosRepository.save(voluntariados);
        return modelMapper.map(voluntariados, VoluntariadosDTO.class);
    }
}
