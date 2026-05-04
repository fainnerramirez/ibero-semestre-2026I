package models;

import java.time.LocalDateTime;

public class Inscripcion {
    private int idInscripcion;
    private int idAsistente;
    private int idEvento;
    private LocalDateTime fechaInscripcion;
    private String estado;

    public Inscripcion() {
    }

    public Inscripcion(int idAsistente, int idEvento, String estado) {
        this.idAsistente = idAsistente;
        this.idEvento = idEvento;
        this.estado = estado;
        this.fechaInscripcion = LocalDateTime.now();
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
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

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "idInscripcion=" + idInscripcion +
                ", idAsistente=" + idAsistente +
                ", idEvento=" + idEvento +
                ", estado='" + estado + '\'' +
                '}';
    }
}
