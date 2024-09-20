package com.upc.avancetp.repository;

import com.upc.avancetp.model.Asistencias;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface US17Repository extends JpaRepository<Asistencias, Long> {
    @Query(value="SELECT * from asistencias", nativeQuery= true)
    List<Tuple> asistenciasTotalVoluntariado();

    @Query(value="SELECT a.* from asistencias a\n" +
            "JOIN voluntariados v ON a.id_voluntariados = v.codigo\n" +
            "where v.titulo = :name", nativeQuery= true)
    List<Tuple> asistenciasPorVoluntariado(@Param("name") String name);
}
