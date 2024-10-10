package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@IdClass(InteresesPorUsuariosId.class)

public class InteresesPorUsuarios {
    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_usuarios")
    private Usuarios usuarios;

    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_intereses")
    private Intereses intereses;

    public InteresesPorUsuarios(Usuarios usuarios, Intereses intereses) {
        this.usuarios = usuarios;
        this.intereses = intereses;
    }
}
