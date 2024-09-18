package com.upc.avancetp.service;

import com.upc.avancetp.dto.CategoriasDTO;
import com.upc.avancetp.dto.InteresDTO;
import com.upc.avancetp.model.Categorias;
import com.upc.avancetp.model.Intereses;
import com.upc.avancetp.repository.CategoriasRepository;
import com.upc.avancetp.repository.InteresRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
