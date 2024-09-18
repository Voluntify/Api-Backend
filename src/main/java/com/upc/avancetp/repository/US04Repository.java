package com.upc.avancetp.repository;

import com.upc.avancetp.model.Voluntariados;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface US04Repository extends JpaRepository<Voluntariados, Long> {
    @Query(value="select titulo as nombre, descripcion as descripcion, ubicacion as ubicacion, requisitos as requisitos from voluntariados", nativeQuery = true)
    List<Tuple> VoluntariadosTodos();

    @Query(value="SELECT v.titulo AS nombre, v.descripcion AS descripcion\n" +
            "FROM voluntariados v\n" +
            "JOIN asistencias a ON v.codigo = a.id_voluntariados\n" +
            "JOIN usuarios u ON a.id_usuarios = u.codigo\n" +
            "JOIN intereses_por_usuarios ipu ON u.codigo = ipu.id_usuarios\n" +
            "JOIN intereses i ON ipu.id_intereses = i.codigo\n" +
            "WHERE v.titulo = :name;", nativeQuery = true)
    List<Tuple> VoluntariadoPorNombre(@Param("name") String name);
}
