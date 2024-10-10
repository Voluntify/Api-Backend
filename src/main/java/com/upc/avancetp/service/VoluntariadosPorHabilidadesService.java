package com.upc.avancetp.service;

import com.upc.avancetp.dto.VoluntariadosPorHabilidadesDTO;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.HabilidadesRepository;
import com.upc.avancetp.repository.VoluntariadosPorHabilidadesRepository;
import com.upc.avancetp.repository.VoluntariadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VoluntariadosPorHabilidadesService {
    final VoluntariadosRepository voluntariadosRepository;
    final HabilidadesRepository habilidadesRepository;
    final VoluntariadosPorHabilidadesRepository voluntariadosPorHabilidadesRepository;

    public VoluntariadosPorHabilidadesService(VoluntariadosRepository voluntariadosRepository, HabilidadesRepository habilidadesRepository, VoluntariadosPorHabilidadesRepository voluntariadosPorHabilidadesRepository) {
        this.voluntariadosRepository = voluntariadosRepository;
        this.habilidadesRepository = habilidadesRepository;
        this.voluntariadosPorHabilidadesRepository = voluntariadosPorHabilidadesRepository;
    }

    public VoluntariadosPorHabilidadesDTO save(VoluntariadosPorHabilidadesDTO voluntariadosPorHabilidadesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        VoluntariadosPorHabilidades voluntariadosPorHabilidades = modelMapper.map(voluntariadosPorHabilidadesDTO, VoluntariadosPorHabilidades.class);
        Habilidades habilidades = habilidadesRepository.findById(voluntariadosPorHabilidadesDTO.getId_habilidades()).orElse(null);
        Voluntariados voluntariados = voluntariadosRepository.findById(voluntariadosPorHabilidadesDTO.getId_voluntariados()).orElse(null);

        voluntariadosPorHabilidades.setHabilidades(habilidades);
        voluntariadosPorHabilidades.setVoluntariados(voluntariados);
        voluntariadosPorHabilidades = voluntariadosPorHabilidadesRepository.save(voluntariadosPorHabilidades);

        modelMapper.map(voluntariadosPorHabilidades, voluntariadosPorHabilidadesDTO);
        voluntariadosPorHabilidadesDTO.setId_habilidades(voluntariadosPorHabilidades.getHabilidades().getCodigo());
        voluntariadosPorHabilidadesDTO.setId_voluntariados(voluntariadosPorHabilidades.getVoluntariados().getCodigo());
        return voluntariadosPorHabilidadesDTO;
    }
}
