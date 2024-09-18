package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Voluntariados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String titulo;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String ubicacion;
    private String requisitos;

    @OneToMany(mappedBy = "voluntariados", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Asistencias> asistencias; //RELACION 1 A MUCHOS CON "Asistencias"

    @OneToMany(mappedBy = "voluntariados", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Inscripciones> inscripciones; //RELACION 1 A MUCHOS CON "Inscripciones"

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_categorias")
    private Categorias categorias;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_organizaciones")
    private Organizaciones organizaciones;

    @OneToMany(mappedBy = "voluntariados", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Voluntariados_Por_Habilidades> voluntariadosPorHabilidades; //RELACION 1 A MUCHOS CON "Voluntariados_Por_Habilidades"

    public Voluntariados(String titulo, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin, String ubicacion, String requisitos, Categorias categorias, Organizaciones organizaciones) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.ubicacion = ubicacion;
        this.requisitos = requisitos;
        this.categorias = categorias;
        this.organizaciones = organizaciones;
    }
}
