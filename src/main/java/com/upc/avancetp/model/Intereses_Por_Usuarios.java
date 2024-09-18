package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Intereses_Por_Usuarios {
    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_usuarios")
    private Usuarios usuarios;

    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_intereses")
    private Intereses intereses;

    public Intereses_Por_Usuarios(Usuarios usuarios, Intereses intereses) {
        this.usuarios = usuarios;
        this.intereses = intereses;
    }
}
