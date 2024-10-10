package com.upc.avancetp.model;

public class UsuariosPorHabilidadesId {
    private Long usuarios;
    private Long habilidades;

    public UsuariosPorHabilidadesId() {}

    public UsuariosPorHabilidadesId(Long usuarios, Long habilidades) {
        this.usuarios = usuarios;
        this.habilidades = habilidades;
    }

    public Long getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Long usuarios) {
        this.usuarios = usuarios;
    }

    public Long getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Long habilidades) {
        this.habilidades = habilidades;
    }
}
