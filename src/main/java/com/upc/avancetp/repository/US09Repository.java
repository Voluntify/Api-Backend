package com.upc.avancetp.repository;

import com.upc.avancetp.model.Organizaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface US09Repository extends JpaRepository<Organizaciones, Long> {
    public Organizaciones findByNombre(String nombre);
}
