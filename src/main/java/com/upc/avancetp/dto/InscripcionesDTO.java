package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionesDTO {
    private Long codigo;
    private boolean estado;
    private LocalDate fecha_inscripcion;
    private Long id_usuarios;
    private Long id_voluntariados;
}
