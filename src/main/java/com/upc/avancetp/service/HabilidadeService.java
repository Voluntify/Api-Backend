package com.upc.avancetp.service;

import com.upc.avancetp.dto.CategoriasDTO;
import com.upc.avancetp.dto.HabilidadesDTO;
import com.upc.avancetp.model.Categorias;
import com.upc.avancetp.model.Habilidades;
import com.upc.avancetp.repository.HabilidadesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HabilidadeService {
    final HabilidadesRepository habilidadesRepository;

    public HabilidadeService(HabilidadesRepository habilidadesRepository) {
        this.habilidadesRepository = habilidadesRepository;
    }

    public HabilidadesDTO save(HabilidadesDTO habilidadesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Habilidades Habilidades = modelMapper.map(habilidadesDTO, Habilidades.class);
        Habilidades = habilidadesRepository.save(Habilidades);
        return modelMapper.map(Habilidades, HabilidadesDTO.class);
    }
}
