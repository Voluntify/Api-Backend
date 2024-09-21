package com.upc.avancetp.service;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.dto.InscripcionesDTO;
import com.upc.avancetp.repository.US12Repository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class US12Service {
    final US12Repository us12Repository;

    public US12Service(US12Repository us12Repository) {
        this.us12Repository = us12Repository;
    }

    public List<InscripcionesDTO> inscripcionesMostrarPorVoluntariado(String name) {
        List<Tuple> tuplas = us12Repository.inscripcionesPorVoluntariado(name);
        List<InscripcionesDTO> listInscr = new ArrayList<>();
        InscripcionesDTO iscripcion;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateInscripcion = tuple.get("fecha_inscripcion", java.sql.Date.class);
            LocalDate fecha_inscripcion = DateInscripcion.toLocalDate();
            iscripcion = new InscripcionesDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado", Boolean.class),
                    fecha_inscripcion,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listInscr.add(iscripcion);
        }
        return listInscr;
    }

    public List<InscripcionesDTO> inscripcionesMostrarPorUsuario(String name) {
        List<Tuple> tuplas = us12Repository.inscripcionesPorUsuario(name);
        List<InscripcionesDTO> listInscr = new ArrayList<>();
        InscripcionesDTO iscripcion;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateInscripcion = tuple.get("fecha_inscripcion", java.sql.Date.class);
            LocalDate fecha_inscripcion = DateInscripcion.toLocalDate();
            iscripcion = new InscripcionesDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado", Boolean.class),
                    fecha_inscripcion,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listInscr.add(iscripcion);
        }
        return listInscr;
    }
}
