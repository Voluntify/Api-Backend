package com.upc.avancetp.repository;

import com.upc.avancetp.model.UsuariosPorHabilidades;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuariosPorHabilidadesRepository extends JpaRepository<UsuariosPorHabilidades, Long> {
    @Query(value = "SELECT u.codigo AS usuario_codigo, u.nombre AS usuario_nombre, " +
            "h.codigo AS habilidad_codigo, h.nombre AS habilidad_nombre " +
            "FROM Usuarios u " +
            "JOIN Usuarios_Por_Habilidades uph ON u.codigo = uph.id_usuarios " +
            "JOIN Habilidades h ON uph.id_habilidades = h.codigo " +
            "WHERE u.nombre = :name", nativeQuery = true)
    List<Tuple> obtenerHabilidadesPorUsuario(@Param("name") String name);

    @Query(value = "SELECT u.codigo AS usuario_codigo, u.nombre AS usuario_nombre, " +
            "h.codigo AS habilidad_codigo, h.nombre AS habilidad_nombre " +
            "FROM Usuarios u " +
            "JOIN Usuarios_Por_Habilidades uph ON u.codigo = uph.id_usuarios " +
            "JOIN Habilidades h ON uph.id_habilidades = h.codigo " +
            "WHERE u.codigo = :codigo", nativeQuery = true)
    List<Tuple> obtenerHabilidadesPorUsuarioByAdmin(@Param("codigo") Long codigo);
}
