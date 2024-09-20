package com.upc.avancetp.service;

import com.upc.avancetp.dto.AsistenciasDTO;
import com.upc.avancetp.repository.US17Repository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class US17Service {
    US17Repository us17Repository;

    public US17Service(US17Repository us17Repository) {
        this.us17Repository = us17Repository;
    }

    public List<AsistenciasDTO> asistenciasMostrarVoluntariados() {
        List<Tuple> tuplas = us17Repository.asistenciasTotalVoluntariado();
        List<AsistenciasDTO> listRecaud = new ArrayList<>();
        AsistenciasDTO recaud;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateAsistencia = tuple.get("fecha", java.sql.Date.class);
            LocalDate fecha = DateAsistencia.toLocalDate();
            recaud = new AsistenciasDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado_asistencia", Boolean.class),
                    fecha,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listRecaud.add(recaud);
        }
        return listRecaud;
    }

    public List<AsistenciasDTO> asistenciasporVoluntariadoMostrar(String name) {
        List<Tuple> tuplas = us17Repository.asistenciasPorVoluntariado(name);
        List<AsistenciasDTO> listRecaud = new ArrayList<>();
        AsistenciasDTO recaud;

        for (Tuple tuple : tuplas) {
            java.sql.Date DateAsistencia = tuple.get("fecha", java.sql.Date.class);
            LocalDate fecha = DateAsistencia.toLocalDate();
            recaud = new AsistenciasDTO(
                    tuple.get("codigo", Long.class),
                    tuple.get("estado_asistencia", Boolean.class),
                    fecha,
                    tuple.get("id_usuarios", Long.class),
                    tuple.get("id_voluntariados", Long.class)
            );

            listRecaud.add(recaud);
        }
        return listRecaud;
    }
}
