package com.upc.avancetp.service;

import com.upc.avancetp.dto.VoluntariadosDTO;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.CategoriasRepository;
import com.upc.avancetp.repository.US09Repository;
import com.upc.avancetp.repository.VoluntariadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VoluntariadosService {
    private final VoluntariadosRepository voluntariadosRepository;
    private final US09Repository us09Repository;
    private final CategoriasRepository categoriasRepository;

    public VoluntariadosService(VoluntariadosRepository voluntariadosRepository, US09Repository us09Repository, CategoriasRepository categoriasRepository) {
        this.voluntariadosRepository = voluntariadosRepository;
        this.us09Repository = us09Repository;
        this.categoriasRepository = categoriasRepository;
    }

    public VoluntariadosDTO save(VoluntariadosDTO voluntariadosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Voluntariados voluntariados = modelMapper.map(voluntariadosDTO, Voluntariados.class);
        Organizaciones organizaciones = us09Repository.findById(voluntariadosDTO.getId_organizaciones()).orElse(null);
        Categorias categorias = categoriasRepository.findById(voluntariadosDTO.getId_categorias()).orElse(null);

        voluntariados.setOrganizaciones(organizaciones);
        voluntariados.setCategorias(categorias);
        voluntariados = voluntariadosRepository.save(voluntariados);

        modelMapper.map(voluntariados, voluntariadosDTO);
        voluntariadosDTO.setId_organizaciones(voluntariados.getOrganizaciones().getCodigo());
        voluntariadosDTO.setId_categorias(voluntariados.getCategorias().getCodigo());
        return voluntariadosDTO;
    }
}
