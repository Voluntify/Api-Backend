package com.upc.avancetp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabilidadesPorPerfilDTO {
    private Long usuario_codigo;
    private String usuario_nombre;
    private Long habilidad_codigo;
    private String habilidad_nombre;
}