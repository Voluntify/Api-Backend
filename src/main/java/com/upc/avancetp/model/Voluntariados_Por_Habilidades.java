package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Voluntariados_Por_Habilidades {
    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_habilidades")
    private Habilidades habilidades;

    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_voluntariados")
    private Voluntariados voluntariados;

    public Voluntariados_Por_Habilidades(Habilidades habilidades, Voluntariados voluntariados) {
        this.habilidades = habilidades;
        this.voluntariados = voluntariados;
    }
}
