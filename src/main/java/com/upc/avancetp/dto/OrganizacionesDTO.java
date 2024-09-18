package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizacionesDTO {
    private Long codigo;
    private String nombre;
    private String descripcion;
    private String correo;
    private Long telefono;
    private String direccion;
    private String sitio_web;
    private LocalDate fecha_registro;
    private boolean suscripcion_activa;
    private String nivel_suscripcion;
}
