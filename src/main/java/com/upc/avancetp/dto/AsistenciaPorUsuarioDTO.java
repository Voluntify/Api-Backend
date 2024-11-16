package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaPorUsuarioDTO {
    private String titulo;
    private String descripcion;
}