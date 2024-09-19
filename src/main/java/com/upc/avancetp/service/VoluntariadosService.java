package com.upc.avancetp.service;

import com.upc.avancetp.dto.VoluntariadosDTO;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.CategoriasRepository;
import com.upc.avancetp.repository.OrganizacionesRepository;
import com.upc.avancetp.repository.VoluntariadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VoluntariadosService {
    private final VoluntariadosRepository voluntariadosRepository;
    private final OrganizacionesRepository organizacionesRepository;
    private final CategoriasRepository categoriasRepository;

    public VoluntariadosService(VoluntariadosRepository voluntariadosRepository, OrganizacionesRepository organizacionesRepository, CategoriasRepository categoriasRepository) {
        this.voluntariadosRepository = voluntariadosRepository;
        this.organizacionesRepository = organizacionesRepository;
        this.categoriasRepository = categoriasRepository;
    }

    public VoluntariadosDTO save(VoluntariadosDTO voluntariadosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Voluntariados voluntariados = modelMapper.map(voluntariadosDTO, Voluntariados.class);
        Organizaciones organizaciones = organizacionesRepository.findById(voluntariadosDTO.getId_organizaciones()).orElse(null);
        Categorias categorias = categoriasRepository.findById(voluntariadosDTO.getId_categorias()).orElse(null);

        voluntariados.setOrganizaciones(organizaciones);
        voluntariados.setCategorias(categorias);
        voluntariados = voluntariadosRepository.save(voluntariados);
        System.out.println("Holam voluntariados " + voluntariados);

        modelMapper.map(voluntariados, voluntariadosDTO);
        voluntariadosDTO.setId_organizaciones(voluntariados.getOrganizaciones().getCodigo());
        voluntariadosDTO.setId_categorias(voluntariados.getCategorias().getCodigo());
        return voluntariadosDTO;
    }
}
