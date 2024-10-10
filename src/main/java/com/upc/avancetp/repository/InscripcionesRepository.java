package com.upc.avancetp.repository;

import com.upc.avancetp.model.Inscripciones;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscripcionesRepository extends JpaRepository<Inscripciones, Long> {
    @Query(value="SELECT i.* from inscripciones i\n" +
            "JOIN voluntariados v ON i.id_voluntariados = v.codigo \n" +
            "where v.titulo = :name", nativeQuery = true)
    List<Tuple> inscripcionesPorVoluntariado(@Param("name") String name);

    @Query(value="SELECT i.* from inscripciones i\n" +
            "JOIN usuarios u ON i.id_usuarios = u.codigo \n" +
            "where u.nombre = :name", nativeQuery = true)
    List<Tuple> inscripcionesPorUsuario(@Param("name") String name);
}
