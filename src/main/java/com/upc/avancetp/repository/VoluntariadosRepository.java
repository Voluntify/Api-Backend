package com.upc.avancetp.repository;

import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Voluntariados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntariadosRepository extends JpaRepository<Voluntariados, Long> {
}
