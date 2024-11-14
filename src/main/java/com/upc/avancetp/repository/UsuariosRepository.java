package com.upc.avancetp.repository;

import com.upc.avancetp.model.Usuarios;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    public Usuarios findByNombre(String nombre);

    @Query(value = "SELECT * from usuarios u WHERE u.nombre = :name", nativeQuery = true)
    List<Tuple> ObtenerPerfil(@Param("name") String name);
}
