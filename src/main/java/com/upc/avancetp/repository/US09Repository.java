package com.upc.avancetp.repository;

import com.upc.avancetp.model.Organizaciones;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface OrganizacionesRepository extends JpaRepository<Organizaciones, Long> {
}
