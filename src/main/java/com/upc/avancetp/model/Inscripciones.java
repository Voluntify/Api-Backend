package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private boolean estado;
    private LocalDate fecha_inscripcion;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_usuarios")
    private Usuarios usuarios;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_voluntariados")
    private Voluntariados voluntariados;

    public Inscripciones(boolean estado, LocalDate fecha_inscripcion, Usuarios usuarios, Voluntariados voluntariados) {
        this.estado = estado;
        this.fecha_inscripcion = fecha_inscripcion;
        this.usuarios = usuarios;
        this.voluntariados = voluntariados;
    }
}
