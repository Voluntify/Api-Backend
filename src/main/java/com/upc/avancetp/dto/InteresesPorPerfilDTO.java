package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InteresesPorPerfilDTO {
    private Long usuario_codigo;
    private String usuario_nombre;
    private Long interes_codigo;
    private String interes_nombre;
}
