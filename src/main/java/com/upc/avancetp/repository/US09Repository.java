package com.upc.avancetp.repository;

import com.upc.avancetp.model.Organizaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacionesRepository extends JpaRepository<Organizaciones, Long> {
}
