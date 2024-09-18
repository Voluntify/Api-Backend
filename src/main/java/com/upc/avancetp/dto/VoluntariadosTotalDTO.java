package com.upc.avancetp.dto;

import com.upc.avancetp.model.Categorias;
import com.upc.avancetp.model.Organizaciones;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoluntariadosTotalDTO {
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String requisitos;
}
