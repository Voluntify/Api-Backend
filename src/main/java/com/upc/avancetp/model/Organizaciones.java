package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Organizaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String descripcion;
    private String correo;
    private Long telefono;
    private String direccion;
    private String sitio_web;
    private LocalDate fecha_registro;
    private boolean suscripcion_activa;
    private String nivel_suscripcion;

    @OneToMany(mappedBy = "organizaciones", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Voluntariados> voluntariados; //RELACION 1 A MUCHOS CON "Voluntariados"

    @OneToMany(mappedBy = "organizaciones", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Capacitaciones> capacitaciones; //RELACION 1 A MUCHOS CON "Capacitaciones"

    @OneToMany(mappedBy = "organizaciones", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reportes> reportes; //RELACION 1 A MUCHOS CON "Reportes"

    @OneToMany(mappedBy = "organizaciones", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Certificados> certificados; //RELACION 1 A MUCHOS CON "Certificados"

    public Organizaciones(String nombre, String descripcion, String correo, Long telefono, String direccion, String sitio_web, LocalDate fecha_registro, boolean suscripcion_activa, String nivel_suscripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sitio_web = sitio_web;
        this.fecha_registro = fecha_registro;
        this.suscripcion_activa = suscripcion_activa;
        this.nivel_suscripcion = nivel_suscripcion;
    }
}
