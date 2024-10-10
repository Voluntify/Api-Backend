package com.upc.avancetp.service;

import com.upc.avancetp.dto.CertificadosDTO;
import com.upc.avancetp.dto.CertificadosPorUsuarioDTO;
import com.upc.avancetp.model.Certificados;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.*;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CertificadosService {
    final CertificadosRepository certificadosRepository;
    final OrganizacionesRepository organizacionesRepository;
    final UsuariosRepository usuariosRepository;

    public CertificadosService(CertificadosRepository certificadosRepository, OrganizacionesRepository organizacionesRepository, UsuariosRepository usuariosRepository) {
        this.certificadosRepository = certificadosRepository;
        this.organizacionesRepository = organizacionesRepository;
        this.usuariosRepository = usuariosRepository;
    }

    public List<CertificadosPorUsuarioDTO> certificadosPorUsuarioList(Long Codigo_Usuario) {
        List<Tuple> tuplas = certificadosRepository.certificadosPorUsuario(Codigo_Usuario);
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

    public CertificadosDTO save(CertificadosDTO certificadosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Certificados certificados = modelMapper.map(certificadosDTO, Certificados.class);
        Organizaciones organizaciones = organizacionesRepository.findById(certificadosDTO.getId_organizaciones()).orElse(null);
        Usuarios usuarios = usuariosRepository.findById(certificadosDTO.getId_usuarios()).orElse(null);

        certificados.setOrganizaciones(organizaciones);
        certificados.setUsuarios(usuarios);
        certificados = certificadosRepository.save(certificados);

        modelMapper.map(certificados, certificadosDTO);
        certificadosDTO.setId_organizaciones(certificados.getOrganizaciones().getCodigo());
        certificadosDTO.setId_usuarios(certificados.getUsuarios().getCodigo());
        return certificadosDTO;
    }
}
