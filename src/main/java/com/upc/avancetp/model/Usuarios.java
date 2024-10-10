package com.upc.avancetp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Usuarios{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private Long telefono;
    private String direccion;
    private LocalDate fecha_registro;

    @OneToMany(mappedBy = "usuarios", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InteresesPorUsuarios> interesesPorUsuarios; //RELACION 1 A MUCHOS CON "Intereses_Por_Usuarios"

    @OneToMany(mappedBy = "usuarios", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Notificaciones> notificaciones; //RELACION 1 A MUCHOS CON "Notificaciones"

    @OneToMany(mappedBy = "usuarios", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Asistencias> asistencias; //RELACION 1 A MUCHOS CON "Asistencias"

    @OneToMany(mappedBy = "usuarios", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Inscripciones> inscripciones; //RELACION 1 A MUCHOS CON "Inscripciones"

    @OneToMany(mappedBy = "usuarios", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Certificados> certificados; //RELACION 1 A MUCHOS CON "Certificados"

    @OneToMany(mappedBy = "usuarios", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UsuariosPorHabilidades> usuariosPorHabilidades; //RELACION 1 A MUCHOS CON "Usuarios_Por_Habilidades"

    @OneToMany(mappedBy = "usuarios", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Roles_Usuarios> role;

    public Usuarios(String nombre, String apellido, String correo, String contrasena, Long telefono, String direccion, LocalDate fecha_registro, List<Roles_Usuarios> role) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_registro = fecha_registro;
        this.role = role;
    }
}