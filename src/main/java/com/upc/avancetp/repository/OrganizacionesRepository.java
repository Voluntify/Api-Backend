package com.upc.avancetp.repository;

import com.upc.avancetp.model.Organizaciones;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizacionesRepository extends JpaRepository<Organizaciones, Long> {
    public Organizaciones findByNombre(String nombre);

    @Query(value="select codigo as codigo, nombre as nombre, descripcion as descripcion, sitio_web as sitio_web from organizaciones", nativeQuery = true)
    List<Tuple> OrganizacionesTodos();

    @Query(value = "SELECT o.codigo as codigo, o.nombre as nombre, o.descripcion as descripcion, o.correo as correo, o.telefono as telefono FROM organizaciones o WHERE o.nombre = :name", nativeQuery = true)
    List<Tuple> OrganizacionesPorNombre(@Param("name") String name);
}
