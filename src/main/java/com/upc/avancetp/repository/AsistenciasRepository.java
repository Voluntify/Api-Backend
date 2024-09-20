package com.upc.avancetp.repository;

import com.upc.avancetp.model.Asistencias;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsistenciasRepository extends JpaRepository<Asistencias, Long> {
    @Query(value="SELECT * from asistencias", nativeQuery= true)
    List<Tuple> asistenciasTotal();
}