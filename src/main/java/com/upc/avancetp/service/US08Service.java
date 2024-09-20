package com.upc.avancetp.service;

import com.upc.avancetp.dto.*;
import com.upc.avancetp.model.*;
import com.upc.avancetp.repository.OrganizacionesRepository;
import com.upc.avancetp.repository.US01Repository;
import com.upc.avancetp.repository.US08Repository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class US08Service {
    final US08Repository us08Repository;
    final OrganizacionesRepository organizacionesRepository;
    final US01Repository us01Repository;

    public US08Service(US08Repository us08Repository, OrganizacionesRepository organizacionesRepository, US01Repository us01Repository) {
        this.us08Repository = us08Repository;
        this.organizacionesRepository = organizacionesRepository;
        this.us01Repository = us01Repository;
    }

    public CertificadosDTO save(CertificadosDTO certificadosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Certificados certificados = modelMapper.map(certificadosDTO, Certificados.class);
        Organizaciones organizaciones = organizacionesRepository.findById(certificadosDTO.getId_organizaciones()).orElse(null);
        Usuarios usuarios = us01Repository.findById(certificadosDTO.getId_usuarios()).orElse(null);

        certificados.setOrganizaciones(organizaciones);
        certificados.setUsuarios(usuarios);
        certificados = us08Repository.save(certificados);

        modelMapper.map(certificadosDTO, certificadosDTO);
        certificadosDTO.setId_organizaciones(certificados.getOrganizaciones().getCodigo());
        certificadosDTO.setId_usuarios(certificados.getUsuarios().getCodigo());
        return certificadosDTO;
    }

    public List<CertificadosPorUsuarioDTO> certificadosPorUsuarioList(Long Codigo_Usuario) {
        List<Tuple> tuplas = us08Repository.certificadosPorUsuario(Codigo_Usuario);
        List<CertificadosPorUsuarioDTO> ListC = new ArrayList<>();
        CertificadosPorUsuarioDTO Cert;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateCertificado = tuple.get("fecha", java.sql.Date.class);
            LocalDate fecha = DateCertificado.toLocalDate();
            Cert = new CertificadosPorUsuarioDTO(
                    tuple.get("codigo", Long.class),
                    fecha,
                    tuple.get("estado", String.class),
                    tuple.get("nombre_organizacion", String.class)
            );

            ListC.add(Cert);
        }
        return ListC;
    }
}