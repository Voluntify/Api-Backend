package com.upc.avancetp.repository;

import com.upc.avancetp.model.Voluntariados;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoluntariadosRepository extends JpaRepository<Voluntariados, Long> {
    @Query(value="select codigo as codigo, titulo as nombre, descripcion as descripcion, ubicacion as ubicacion, requisitos as requisitos from voluntariados", nativeQuery = true)
    List<Tuple> VoluntariadosTodos();

    @Query(value="SELECT v.codigo as codigo, v.titulo AS nombre, v.descripcion AS descripcion FROM voluntariados v WHERE v.titulo = :name;", nativeQuery = true)
    List<Tuple> VoluntariadoPorNombre(@Param("name") String name);

    @Query(value="SELECT v.codigo as codigo, v.titulo AS nombre, " +
            "v.descripcion, v.fecha_inicio as fecha_inicio, v.fecha_fin as fecha_fin, v.ubicacion as ubicacion, " +
            "v.requisitos as requisitos FROM voluntariados v WHERE v.titulo = :name;", nativeQuery = true)
    List<Tuple> InformacionTotalDeVoluntariadoPorNombre(@Param("name") String name);

    @Query(value="SELECT v.codigo as codigo, v.titulo AS titulo, " +
            "v.descripcion as descripcion, v.fecha_inicio as fecha_inicio, v.fecha_fin as fecha_fin, v.ubicacion as ubicacion, " +
            "v.requisitos as requisitos, v.id_organizaciones as id_organizaciones, " +
            "v.id_categorias as id_categorias FROM voluntariados v JOIN organizaciones o " +
            "ON o.codigo = v.id_organizaciones WHERE o.nombre = :name", nativeQuery = true)
    List<Tuple> VoluntariadosPorOrganzacion(@Param("name") String name);

    @Query(value="SELECT v.codigo as codigo, v.titulo AS titulo, " +
            "v.descripcion as descripcion, v.fecha_inicio as fecha_inicio, v.fecha_fin as fecha_fin, v.ubicacion as ubicacion, " +
            "v.requisitos as requisitos FROM voluntariados v WHERE v.titulo = :name", nativeQuery = true)
    List<Tuple> VoluntariadosPorNombreAdmin(@Param("name") String name);
}
