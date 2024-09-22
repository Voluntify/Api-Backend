package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Roles_Organizaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String role;

    @ManyToOne
    @JoinColumn(name="id_organizaciones", nullable=false)
    private Organizaciones organizaciones;

    public Roles_Organizaciones(String role, Organizaciones organizaciones) {
        this.role = role;
        this.organizaciones = organizaciones;
    }
}