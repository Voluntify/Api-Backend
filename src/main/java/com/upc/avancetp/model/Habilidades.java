package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "habilidades", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Usuarios_Por_Habilidades> usuariosPorHabilidades; //RELACION 1 A MUCHOS CON "Usuarios_Por_Habilidades"

    @OneToMany(mappedBy = "habilidades", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Voluntariados_Por_Habilidades> voluntariadosPorHabilidades; //RELACION 1 A MUCHOS CON "Voluntariados_Por_Habilidades"

    public Habilidades(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
