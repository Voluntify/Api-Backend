package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VoluntariadosPorNombreTotalDTO {
    private Long codigo;
    private String nombre;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String ubicacion;
    private String requisitos;
}