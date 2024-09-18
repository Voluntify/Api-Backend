package com.upc.avancetp.repository;

import com.upc.avancetp.model.Voluntariados;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface US04Repository extends JpaRepository<Voluntariados, Long> {
    @Query(value="select codigo as codigo, titulo as nombre, descripcion as descripcion, ubicacion as ubicacion, requisitos as requisitos from voluntariados", nativeQuery = true)
    List<Tuple> VoluntariadosTodos();

    @Query(value="SELECT v.codigo as codigo, v.titulo AS nombre, v.descripcion AS descripcion FROM voluntariados v WHERE v.titulo = :name;", nativeQuery = true)
    List<Tuple> VoluntariadoPorNombre(@Param("name") String name);
}
