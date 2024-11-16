package com.upc.avancetp.service;

import com.upc.avancetp.dto.*;
import com.upc.avancetp.model.Categorias;
import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.model.Voluntariados;
import com.upc.avancetp.repository.*;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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

    public List<VoluntariadoPorNombreAdminDTODTO> VoluntariadosPorNombreAdmin(String name) {
        List<Tuple> tuplas = voluntariadosRepository.VoluntariadosPorNombreAdmin(name);
        List<VoluntariadoPorNombreAdminDTODTO> ListRecaud = new ArrayList<>();
        VoluntariadoPorNombreAdminDTODTO recaud;
        for (Tuple tuple : tuplas) {
            java.sql.Date fechaInicioD = tuple.get("fecha_inicio", java.sql.Date.class);
            java.sql.Date fechaFinD = tuple.get("fecha_fin", java.sql.Date.class);
            LocalDate fecha_inicio = fechaInicioD != null ? fechaInicioD.toLocalDate() : null;
            LocalDate fecha_fin = fechaFinD != null ? fechaFinD.toLocalDate() : null;
            recaud = new VoluntariadoPorNombreAdminDTODTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("titulo", String.class),
                    tuple.get("descripcion", String.class),
                    fecha_inicio,
                    fecha_fin,
                    tuple.get("ubicacion", String.class),
                    tuple.get("requisitos", String.class)
            );
            ListRecaud.add(recaud);
        }
        return ListRecaud;
    }

    public List<VoluntariadosPorNombreTotalDTO> voluntariadoPorNombreTotal(String name) {
        List<Tuple> tuplas = voluntariadosRepository.InformacionTotalDeVoluntariadoPorNombre(name);
        List<VoluntariadosPorNombreTotalDTO> ListRecaud = new ArrayList<>();
        VoluntariadosPorNombreTotalDTO recaud;
        for (Tuple tuple : tuplas) {
            java.sql.Date fechaInicioD = tuple.get("fecha_inicio", java.sql.Date.class);
            java.sql.Date fechaFinD = tuple.get("fecha_fin", java.sql.Date.class);
            LocalDate fechaInicio = fechaInicioD != null ? fechaInicioD.toLocalDate() : null;
            LocalDate fechaFin = fechaFinD != null ? fechaFinD.toLocalDate() : null;

            recaud = new VoluntariadosPorNombreTotalDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("nombre", String.class),
                    tuple.get("descripcion", String.class),
                    fechaInicio,
                    fechaFin,
                    tuple.get("ubicacion", String.class),
                    tuple.get("requisitos", String.class)
            );
            ListRecaud.add(recaud);
        }
        return ListRecaud;
    }

    public List<VoluntariadosPorOrganizacionDTO> voluntariadoPorOrganizacion(String name) {
        List<Tuple> tuplas = voluntariadosRepository.VoluntariadosPorOrganzacion(name);
        List<VoluntariadosPorOrganizacionDTO> ListRecaud = new ArrayList<>();
        VoluntariadosPorOrganizacionDTO recaud;
        for (Tuple tuple : tuplas) {
            java.sql.Date fechaInicioD = tuple.get("fecha_inicio", java.sql.Date.class);
            java.sql.Date fechaFinD = tuple.get("fecha_fin", java.sql.Date.class);
            LocalDate fechaInicio = fechaInicioD != null ? fechaInicioD.toLocalDate() : null;
            LocalDate fechaFin = fechaFinD != null ? fechaFinD.toLocalDate() : null;

            recaud = new VoluntariadosPorOrganizacionDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("titulo", String.class),
                    tuple.get("descripcion", String.class),
                    fechaInicio,
                    fechaFin,
                    tuple.get("ubicacion", String.class),
                    tuple.get("requisitos", String.class),
                    tuple.get("id_organizaciones", Long.class),
                    tuple.get("id_categorias", Long.class)
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

    public VoluntariadosDTO eliminarVoluntariadoPorId(Long id) {
        Optional<Voluntariados> voluntariadosList = voluntariadosRepository.findById(id);

        if (voluntariadosList.isPresent()) {
            Voluntariados voluntariados = voluntariadosList.get();
            voluntariadosRepository.delete(voluntariados);
            voluntariadosRepository.delete(voluntariados);
            return null;
        } else {
            throw new NoSuchElementException("No existe un voluntariado con el ID: " + id);
        }
    }

    public VoluntariadosDTO DescripcionModificacion(Long Id, String descripcion) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Voluntariados> DescripcipnNew = voluntariadosRepository.findById(Id);

        if (DescripcipnNew.isPresent()) {
            Voluntariados voluntariados = DescripcipnNew.get();
            voluntariados.setDescripcion(descripcion);
            Voluntariados updatedDesc = voluntariadosRepository.save(voluntariados);
            return modelMapper.map(updatedDesc, VoluntariadosDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    public VoluntariadosDTO fecha_inicioModificacion(Long Id, LocalDate fecha_inicio) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Voluntariados> fecha_inicioNew = voluntariadosRepository.findById(Id);

        if (fecha_inicioNew.isPresent()) {
            Voluntariados voluntariados = fecha_inicioNew.get();
            voluntariados.setFecha_inicio(fecha_inicio);
            Voluntariados updatedF = voluntariadosRepository.save(voluntariados);
            return modelMapper.map(updatedF, VoluntariadosDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    public VoluntariadosDTO fecha_finModificacion(Long Id, LocalDate fecha_fin) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Voluntariados> fecha_finNew = voluntariadosRepository.findById(Id);

        if (fecha_finNew.isPresent()) {
            Voluntariados voluntariados = fecha_finNew.get();
            voluntariados.setFecha_fin(fecha_fin);
            Voluntariados updatedF = voluntariadosRepository.save(voluntariados);
            return modelMapper.map(updatedF, VoluntariadosDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    public VoluntariadosDTO ubicacionModificacion(Long Id, String ubicacion) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Voluntariados> ubicacionNew = voluntariadosRepository.findById(Id);

        if (ubicacionNew.isPresent()) {
            Voluntariados voluntariados = ubicacionNew.get();
            voluntariados.setUbicacion(ubicacion);
            Voluntariados updatedDesc = voluntariadosRepository.save(voluntariados);
            return modelMapper.map(updatedDesc, VoluntariadosDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    public VoluntariadosDTO requisitosModificacion(Long Id, String requisitos) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Voluntariados> requisitosNew = voluntariadosRepository.findById(Id);

        if (requisitosNew.isPresent()) {
            Voluntariados voluntariados = requisitosNew.get();
            voluntariados.setRequisitos(requisitos);
            Voluntariados updatedReq = voluntariadosRepository.save(voluntariados);
            return modelMapper.map(updatedReq, VoluntariadosDTO.class);
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }
}
