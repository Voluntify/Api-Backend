package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuarios_Por_Habilidades {
    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_usuarios")
    private Usuarios usuarios;

    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_habilidades")
    private Habilidades habilidades;

    public Usuarios_Por_Habilidades(Usuarios usuarios, Habilidades habilidades) {
        this.usuarios = usuarios;
        this.habilidades = habilidades;
    }
}
