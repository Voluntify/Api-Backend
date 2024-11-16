package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class VoluntariadosPorOrganizacionDTO {
    private Long codigo;
    private String titulo;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String ubicacion;
    private String requisitos;
    private Long id_organizaciones;
    private Long id_categorias;
}