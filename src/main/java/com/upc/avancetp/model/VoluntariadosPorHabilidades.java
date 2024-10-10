package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@IdClass(VoluntariadosPorHabilidadesId.class)

public class VoluntariadosPorHabilidades {
    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_habilidades")
    private Habilidades habilidades;

    @Id
    @ManyToOne(fetch = FetchType.LAZY) //RELACION MUCHOS a 1
    @JoinColumn(name="id_voluntariados")
    private Voluntariados voluntariados;

    public VoluntariadosPorHabilidades(Habilidades habilidades, Voluntariados voluntariados) {
        this.habilidades = habilidades;
        this.voluntariados = voluntariados;
    }
}
