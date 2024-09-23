package com.upc.avancetp.repository;

import com.upc.avancetp.model.Inscripciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface US13Repository extends JpaRepository<Inscripciones, Long> {
}
