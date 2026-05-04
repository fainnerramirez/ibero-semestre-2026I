package models;

import java.time.LocalDateTime;

public class Notificacion {
    private int idNotificacion;
    private int idPersona;
    private int idEvento;
    private String mensaje;
    private String tipo;
    private LocalDateTime fechaEnvio;
    private boolean leida;

    public Notificacion() {
    }

    public Notificacion(int idPersona, int idEvento, String mensaje, String tipo) {
        this.idPersona = idPersona;
        this.idEvento = idEvento;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fechaEnvio = LocalDateTime.now();
        this.leida = false;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "idNotificacion=" + idNotificacion +
                ", tipo='" + tipo + '\'' +
                ", leida=" + leida +
                '}';
    }
}
