package com.upc.avancetp.model;

public class VoluntariadosPorHabilidadesId {
    private Long voluntariados;
    private Long habilidades;

    public VoluntariadosPorHabilidadesId() {}

    public VoluntariadosPorHabilidadesId(Long voluntariados, Long habilidades) {
        this.voluntariados = voluntariados;
        this.habilidades = voluntariados;
    }

    public Long getVoluntariados() {
        return voluntariados;
    }

    public void setVoluntariados(Long voluntariados) {
        this.voluntariados = voluntariados;
    }

    public Long getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Long habilidades) {
        this.habilidades = habilidades;
    }
}
