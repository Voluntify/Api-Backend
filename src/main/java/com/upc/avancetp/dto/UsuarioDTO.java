package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private Long telefono;
    private String direccion;
    private LocalDate fecha_registro;
}
