package com.upc.avancetp.service;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.dto.CategoriasDTO;
import com.upc.avancetp.model.Categorias;
import com.upc.avancetp.repository.CategoriasRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriasService {
    final CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public CategoriasDTO save(CategoriasDTO categoriasDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Categorias categorias = modelMapper.map(categoriasDTO, Categorias.class);
        categorias = categoriasRepository.save(categorias);
        return modelMapper.map(categorias, CategoriasDTO.class);
    }

    public List<CategoriasDTO> categoriasMostrar() {
        List<Tuple> tuplas = categoriasRepository.categoriasTotal();
        List<CategoriasDTO> listRecaud = new ArrayList<>();
        CategoriasDTO recaud;

        for (Tuple tuple : tuplas) {
            recaud = new CategoriasDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("nombre", String.class)
            );

            listRecaud.add(recaud);
        }
        return listRecaud;
    }
}
