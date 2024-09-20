package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificadosDTO {
    private Long codigo;
    private LocalDate fecha_emision;
    private String estado;
    private Long id_organizaciones;
    private Long id_usuarios;
}
