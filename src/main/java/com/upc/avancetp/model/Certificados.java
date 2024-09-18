package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Certificados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private LocalDate fecha_emision;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_organizaciones")
    private Organizaciones organizaciones;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_usuarios")
    private Usuarios usuarios;

    public Certificados(LocalDate fecha_emision, String estado, Organizaciones organizaciones, Usuarios usuarios) {
        this.fecha_emision = fecha_emision;
        this.estado = estado;
        this.organizaciones = organizaciones;
        this.usuarios = usuarios;
    }
}
