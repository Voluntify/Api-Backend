package com.upc.avancetp.repository;

import com.upc.avancetp.model.Roles_Usuarios;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Roles_UsuariosRepository extends JpaRepository<Roles_Usuarios, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO roles_usuarios (role, id_usuarios) VALUES ('USER', :id_usuario)", nativeQuery = true)
    void insertUserRole(@Param("id_usuario") Long id_usuario);
}
