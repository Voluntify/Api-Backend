package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categorias", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Voluntariados> voluntariados; //RELACION 1 A MUCHOS CON "Voluntariados"

    public Categorias(String nombre, String descripcion, List<Voluntariados> voluntariados) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.voluntariados = voluntariados;
    }
}
