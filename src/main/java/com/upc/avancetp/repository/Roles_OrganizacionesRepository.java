package com.upc.avancetp.repository;

import com.upc.avancetp.model.Roles_Organizaciones;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Roles_OrganizacionesRepository extends JpaRepository<Roles_Organizaciones, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO roles_organizaciones (role, id_organizaciones) VALUES ('ADMIN', :id_organizacion)", nativeQuery = true)
    void insertAdminRole(@Param("id_organizacion") Long id_organizacion);
}
