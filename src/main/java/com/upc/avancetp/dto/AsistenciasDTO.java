package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciasDTO {
    private Long codigo;
    private boolean estado_asistencia;
    private LocalDate fecha;
    private Long id_usuarios;
    private Long id_voluntariados;
}
