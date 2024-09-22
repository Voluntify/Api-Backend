package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionesDTO {
    private Long codigo;
    private String mensaje;
    private LocalDate fecha_envio;
    @NonNull
    private boolean estado;
    private Long id_usuarios;
}
