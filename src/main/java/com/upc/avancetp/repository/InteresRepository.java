package com.upc.avancetp.repository;

import com.upc.avancetp.model.Intereses;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InteresRepository extends JpaRepository<Intereses, Long> {
    @Query(value="SELECT * from intereses", nativeQuery= true)
    List<Tuple> interesesTotal();
}
