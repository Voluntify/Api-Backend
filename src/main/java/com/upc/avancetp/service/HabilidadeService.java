package com.upc.avancetp.service;

import com.upc.avancetp.dto.HabilidadesDTO;
import com.upc.avancetp.model.Habilidades;
import com.upc.avancetp.repository.HabilidadesRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<HabilidadesDTO> habilidadesMostrar() {
        List<Tuple> tuplas = habilidadesRepository.habilidadesTotal();
        List<HabilidadesDTO> listRecaud = new ArrayList<>();
        HabilidadesDTO recaud;
        for (Tuple tuple : tuplas) {
            recaud = new HabilidadesDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("nombre", String.class)
            );
            listRecaud.add(recaud);
        }
        return listRecaud;
    }
}
