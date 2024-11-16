package com.upc.avancetp.repository;

import com.upc.avancetp.model.InteresesPorUsuarios;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InteresesPorUsuariosRepository extends JpaRepository<InteresesPorUsuarios, Long> {
    @Query(value = "SELECT u.codigo AS usuario_codigo, u.nombre AS usuario_nombre, " +
            "i.codigo AS interes_codigo, i.nombre AS interes_nombre " +
            "FROM Usuarios u " +
            "JOIN Intereses_Por_Usuarios upi ON u.codigo = upi.id_usuarios " +
            "JOIN Intereses i ON upi.id_intereses = i.codigo " +
            "WHERE u.nombre = :name", nativeQuery = true)
    List<Tuple> obtenerInteresesPorUsuario(@Param("name") String name);

    @Query(value = "SELECT u.codigo AS usuario_codigo, u.nombre AS usuario_nombre, " +
            "i.codigo AS interes_codigo, i.nombre AS interes_nombre " +
            "FROM Usuarios u " +
            "JOIN Intereses_Por_Usuarios upi ON u.codigo = upi.id_usuarios " +
            "JOIN Intereses i ON upi.id_intereses = i.codigo " +
            "WHERE u.codigo = :codigo", nativeQuery = true)
    List<Tuple> obtenerInteresesPorUsuarioByAdmin(@Param("codigo") Long codigo);
}
