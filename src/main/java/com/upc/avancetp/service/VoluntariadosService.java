package com.upc.avancetp.service;

import com.upc.avancetp.dto.VoluntariadoPorNombreDTO;
import com.upc.avancetp.dto.VoluntariadosDTO;
import com.upc.avancetp.dto.VoluntariadosTotalDTO;
import com.upc.avancetp.model.Categorias;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Voluntariados;
import com.upc.avancetp.repository.*;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoluntariadosService {
    final VoluntariadosRepository voluntariadosRepository;
    final OrganizacionesRepository organizacionesRepository;
    private final CategoriasRepository categoriasRepository;


    public VoluntariadosService(VoluntariadosRepository voluntariadosRepository, OrganizacionesRepository organizacionesRepository, CategoriasRepository categoriasRepository) {
        this.voluntariadosRepository = voluntariadosRepository;
        this.organizacionesRepository = organizacionesRepository;
        this.categoriasRepository = categoriasRepository;
    }

    public List<VoluntariadosTotalDTO> voluntariadosTotal() {
        List<Tuple> tuplas = voluntariadosRepository.VoluntariadosTodos();
        List<VoluntariadosTotalDTO> ListVolunt = new ArrayList<>();
        VoluntariadosTotalDTO Volunt;
        for (Tuple tuple : tuplas) {
            Volunt = new VoluntariadosTotalDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("ubicacion", String.class),
                    tuple.get("requisitos", String.class)
            );
            ListVolunt.add(Volunt);
        }
        return ListVolunt;
    }

    public List<VoluntariadoPorNombreDTO> voluntariadoPorNombre(String name) {
        List<Tuple> tuplas = voluntariadosRepository.VoluntariadoPorNombre(name);
        List<VoluntariadoPorNombreDTO> ListRecaud = new ArrayList<>();
        VoluntariadoPorNombreDTO recaud;
        for (Tuple tuple : tuplas) {
            recaud = new VoluntariadoPorNombreDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class),
                    tuple.get("descripcion", String.class)
            );
            ListRecaud.add(recaud);
        }
        return ListRecaud;
    }

    public VoluntariadosDTO save(VoluntariadosDTO voluntariadosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Voluntariados voluntariados = modelMapper.map(voluntariadosDTO, Voluntariados.class);
        Organizaciones organizaciones = organizacionesRepository.findById(voluntariadosDTO.getId_organizaciones()).orElse(null);
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
