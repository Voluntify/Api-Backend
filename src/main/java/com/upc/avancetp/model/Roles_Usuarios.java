package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Roles_Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String role;

    @ManyToOne
    @JoinColumn(name="id_usuarios", nullable=false)
    private Usuarios usuarios;

    public Roles_Usuarios(String role, Usuarios usuarios) {
        this.role = role;
        this.usuarios = usuarios;
    }
}