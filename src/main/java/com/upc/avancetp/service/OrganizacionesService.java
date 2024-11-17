package com.upc.avancetp.service;

import com.upc.avancetp.dto.OrganizacionesDTO;
import com.upc.avancetp.dto.OrganizacionesPorNombreDTO;
import com.upc.avancetp.dto.OrganizacionesTotalDTO;
import com.upc.avancetp.dto.UsuarioDTO;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.OrganizacionesRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizacionesService {
    final OrganizacionesRepository organizacionesRepository;
    private final PasswordEncoder passwordEncoder;

    public OrganizacionesService(OrganizacionesRepository organizacionesRepository) {
        this.organizacionesRepository = organizacionesRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public OrganizacionesDTO save(OrganizacionesDTO organizacionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Organizaciones organizaciones = modelMapper.map(organizacionesDTO, Organizaciones.class);
        organizaciones.setContrasena(passwordEncoder.encode(organizaciones.getContrasena()));
        organizaciones = organizacionesRepository.save(organizaciones);
        return modelMapper.map(organizaciones, OrganizacionesDTO.class);
    }

    public List<OrganizacionesTotalDTO> organizacionesTotal() {
        List<Tuple> tuplas = organizacionesRepository.OrganizacionesTodos();
        List<OrganizacionesTotalDTO> ListOrg = new ArrayList<>();
        OrganizacionesTotalDTO Org;
        for (Tuple tuple : tuplas) {
            Org = new OrganizacionesTotalDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("sitio_web", String.class)
            );
            ListOrg.add(Org);
        }
        return ListOrg;
    }

    public List<OrganizacionesPorNombreDTO> organizacionesPorNombre(String name) {
        List<Tuple> tuplas = organizacionesRepository.OrganizacionesPorNombre(name);
        List<OrganizacionesPorNombreDTO> ListOrg = new ArrayList<>();
        OrganizacionesPorNombreDTO Org;
        for (Tuple tuple : tuplas) {
            Org = new OrganizacionesPorNombreDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("correo", String.class),
                    tuple.get("telefono", Long.class)
            );
            ListOrg.add(Org);
        }
        return ListOrg;
    }

    public OrganizacionesDTO suscripcionDeOrganizacion(Long organizacionId, boolean suscripcion_activa) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Organizaciones> suscripcionList = organizacionesRepository.findById(organizacionId);

        if (suscripcionList.isPresent()) {
            Organizaciones organizacion = suscripcionList.get();
            organizacion.setSuscripcion_activa(suscripcion_activa);
            Organizaciones updatedSuscripcion = organizacionesRepository.save(organizacion);
            return modelMapper.map(updatedSuscripcion, OrganizacionesDTO.class);
        }
        throw new IllegalArgumentException("Organizacion no encontrada");
    }

    public UsuarioDTO ContrasenaModificacion(Long codigo, String contrasena) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Organizaciones> ContrasenaNew = organizacionesRepository.findById(codigo);

        if (ContrasenaNew.isPresent()) {
            Organizaciones organizaciones = ContrasenaNew.get();
            organizaciones.setContrasena(contrasena);
            Organizaciones updatedConstrasena = organizacionesRepository.save(organizaciones);
            return modelMapper.map(updatedConstrasena, UsuarioDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }
}
