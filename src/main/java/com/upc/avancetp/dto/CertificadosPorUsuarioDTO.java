package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificadosPorUsuarioDTO {
    private Long codigo;
    private LocalDate fecha;
    private String estado;
    private String nombre_organizacion;
}
