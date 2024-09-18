package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Reportes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private LocalDate fecha;
    private String tipo_reporte;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_organizaciones")
    private Organizaciones organizaciones;

    public Reportes(LocalDate fecha, String tipo_reporte, Organizaciones organizaciones) {
        this.fecha = fecha;
        this.tipo_reporte = tipo_reporte;
        this.organizaciones = organizaciones;
    }
}
