package com.upc.avancetp.repository;

import com.upc.avancetp.model.Habilidades;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabilidadesRepository extends JpaRepository<Habilidades, Long> {
    @Query(value="SELECT * from habilidades", nativeQuery= true)
    List<Tuple> habilidadesTotal();
}
