package com.upc.avancetp.securities;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String nombre;
    private String contrasena;
    public JwtRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
    public JwtRequest(String nombre, String contrasena) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getNombre() {
        return nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setUsername(String nombre) {this.nombre = nombre;}
    public void setPassword(String contrasena) {
        this.contrasena = contrasena;
    }
}