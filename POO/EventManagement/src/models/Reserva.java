package models;

import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private int idEvento;
    private int idAsistente;
    private int numeroAsientos;
    private LocalDateTime fechaReserva;
    private String estado;

    public Reserva() {
    }

    public Reserva(int idEvento, int idAsistente, int numeroAsientos, String estado) {
        this.idEvento = idEvento;
        this.idAsistente = idAsistente;
        this.numeroAsientos = numeroAsientos;
        this.estado = estado;
        this.fechaReserva = LocalDateTime.now();
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", idEvento=" + idEvento +
                ", numeroAsientos=" + numeroAsientos +
                ", estado='" + estado + '\'' +
                '}';
    }
}
