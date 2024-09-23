package com.upc.avancetp.service;

import com.upc.avancetp.dto.CertificadosDTO;
import com.upc.avancetp.model.Certificados;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.US09Repository;
import com.upc.avancetp.repository.US01Repository;
import com.upc.avancetp.repository.US15Repository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class US15Service {
    final US15Repository us15Repository;
    final US09Repository us09Repository;
    final US01Repository us01Repository;

    public US15Service(US15Repository us15Repository, US09Repository us09Repository, US01Repository us01Repository) {
        this.us15Repository = us15Repository;
        this.us09Repository = us09Repository;
        this.us01Repository = us01Repository;
    }

    public CertificadosDTO save(CertificadosDTO certificadosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Certificados certificados = modelMapper.map(certificadosDTO, Certificados.class);
        Organizaciones organizaciones = us09Repository.findById(certificadosDTO.getId_organizaciones()).orElse(null);
        Usuarios usuarios = us01Repository.findById(certificadosDTO.getId_usuarios()).orElse(null);

        certificados.setOrganizaciones(organizaciones);
        certificados.setUsuarios(usuarios);
        certificados = us15Repository.save(certificados);

        modelMapper.map(certificados, certificadosDTO);
        certificadosDTO.setId_organizaciones(certificados.getOrganizaciones().getCodigo());
        certificadosDTO.setId_usuarios(certificados.getUsuarios().getCodigo());
        return certificadosDTO;
    }
}
