package com.upc.avancetp.repository;

import com.upc.avancetp.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface US01Repository extends JpaRepository<Usuarios, Long> {
    public Usuarios findByNombre(String nombre);
}
