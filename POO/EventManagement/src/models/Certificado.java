package models;

import java.time.LocalDateTime;

public class Certificado {
    private int idCertificado;
    private int idAsistente;
    private int idEvento;
    private String numeroCertificado;
    private LocalDateTime fechaEmision;
    private String estado;

    public Certificado() {
    }

    public Certificado(int idAsistente, int idEvento, String numeroCertificado) {
        this.idAsistente = idAsistente;
        this.idEvento = idEvento;
        this.numeroCertificado = numeroCertificado;
        this.fechaEmision = LocalDateTime.now();
        this.estado = "Generado";
    }

    public int getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(int idCertificado) {
        this.idCertificado = idCertificado;
    }

    public int getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setNumeroCertificado(String numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "idCertificado=" + idCertificado +
                ", numeroCertificado='" + numeroCertificado + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
