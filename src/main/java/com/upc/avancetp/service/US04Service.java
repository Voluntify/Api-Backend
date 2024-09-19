package com.upc.avancetp.service;

import com.upc.avancetp.dto.VoluntariadoPorNombreDTO;
import com.upc.avancetp.dto.VoluntariadosTotalDTO;
import com.upc.avancetp.repository.US04Repository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class US04Service {
    final US04Repository us04Repository;

    public US04Service(US04Repository us04Repository) {
        this.us04Repository = us04Repository;
    }

    public List<VoluntariadosTotalDTO> voluntariadosTotal() {
        List<Tuple> tuplas = us04Repository.VoluntariadosTodos();
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
        List<Tuple> tuplas = us04Repository.VoluntariadoPorNombre(name);
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
}