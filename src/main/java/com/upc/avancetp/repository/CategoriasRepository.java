package com.upc.avancetp.repository;

import com.upc.avancetp.model.Categorias;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
    @Query(value="SELECT * from categorias", nativeQuery= true)
    List<Tuple> categoriasTotal();
}
