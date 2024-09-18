package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Capacitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descripcion;
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_organizaciones")
    private Organizaciones organizaciones;

    public Capacitaciones(String descripcion, LocalDate fecha, Organizaciones organizaciones) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.organizaciones = organizaciones;
    }
}
