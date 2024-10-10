package com.upc.avancetp.model;


public class InteresesPorUsuariosId{
    private Long usuarios;
    private Long intereses;

    public InteresesPorUsuariosId() {}

    public InteresesPorUsuariosId(Long usuarios, Long intereses) {
        this.usuarios = usuarios;
        this.intereses = intereses;
    }

    public Long getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Long usuarios) {
        this.usuarios = usuarios;
    }

    public Long getIntereses() {
        return intereses;
    }

    public void setIntereses(Long intereses) {
        this.intereses = intereses;
    }
}
