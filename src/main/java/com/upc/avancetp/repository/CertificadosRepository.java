package com.upc.avancetp.repository;

import com.upc.avancetp.model.Certificados;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificadosRepository extends JpaRepository<Certificados, Long> {
    @Query(value="SELECT cr.codigo as codigo, cr.fecha_emision as fecha, cr.estado as estado, o.nombre as nombre_organizacion FROM certificados cr\n" +
            "JOIN usuarios u ON cr.id_usuarios = u.codigo\n" +
            "JOIN organizaciones o ON cr.id_organizaciones = o.codigo\n" +
            "WHERE cr.id_usuarios = :Codigo_Usuario", nativeQuery = true)
    List<Tuple> certificadosPorUsuario(@Param("Codigo_Usuario") Long Codigo_Usuario);
}
