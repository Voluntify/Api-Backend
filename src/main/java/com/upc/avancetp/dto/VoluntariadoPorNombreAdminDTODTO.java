package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoluntariadoPorNombreAdminDTODTO {
    public Long codigo;
    public String titulo;
    public String descripcion;
    public LocalDate fecha_inicio;
    public LocalDate fecha_fin;
    public String ubicacion;
    public String requisitos;
}
