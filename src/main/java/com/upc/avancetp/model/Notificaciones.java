package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String mensaje;
    private LocalDate fecha_envio;
    private boolean estado;

    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_usuarios")
    private Usuarios usuarios;

    public Notificaciones(String mensaje, LocalDate fecha_envio, boolean estado, Usuarios usuarios) {
        this.mensaje = mensaje;
        this.fecha_envio = fecha_envio;
        this.estado = estado;
        this.usuarios = usuarios;
    }
}
