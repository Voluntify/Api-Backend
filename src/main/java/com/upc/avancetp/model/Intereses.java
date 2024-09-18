package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Intereses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;

    @OneToMany(mappedBy = "intereses", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Intereses_Por_Usuarios> interesesPorUsuarios; //RELACION 1 A MUCHOS CON "Intereses_Por_Usuarios"

    public Intereses(String nombre) {
        this.nombre = nombre;
    }
}
