package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoluntariadoPorNombreDTO {
    private Long codigo;
    private String nombre;
    private String descripcion;
}
