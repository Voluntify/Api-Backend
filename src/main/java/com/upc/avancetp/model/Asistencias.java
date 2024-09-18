package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Asistencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private LocalDate fecha;
    private boolean estado_asistencia;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_usuarios")
    private Usuarios usuarios;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_voluntariados")
    private Voluntariados voluntariados;

    public Asistencias(LocalDate fecha, boolean estado_asistencia, Usuarios usuarios, Voluntariados voluntariados) {
        this.fecha = fecha;
        this.estado_asistencia = estado_asistencia;
        this.usuarios = usuarios;
        this.voluntariados = voluntariados;
    }
}
