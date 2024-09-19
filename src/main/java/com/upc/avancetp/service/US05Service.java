package com.upc.avancetp.service;

import com.upc.avancetp.dto.OrganizacionesPorNombreDTO;
import com.upc.avancetp.dto.OrganizacionesTotalDTO;
import com.upc.avancetp.repository.US05Repository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class US05Service {
    final US05Repository us05Repository;

    public US05Service(US05Repository us05Repository) {
        this.us05Repository = us05Repository;
    }

    public List<OrganizacionesTotalDTO> organizacionesTotal() {
        List<Tuple> tuplas = us05Repository.OrganizacionesTodos();
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
        List<Tuple> tuplas = us05Repository.OrganizacionesPorNombre(name);
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
}
