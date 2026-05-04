package models;

import java.time.LocalTime;

public class EventoPonente {
    private int idEventoPonente;
    private int idEvento;
    private int idPonente;
    private LocalTime horaPresentacion;
    private String tema;

    public EventoPonente() {
    }

    public EventoPonente(int idEvento, int idPonente, LocalTime horaPresentacion, String tema) {
        this.idEvento = idEvento;
        this.idPonente = idPonente;
        this.horaPresentacion = horaPresentacion;
        this.tema = tema;
    }

    public int getIdEventoPonente() {
        return idEventoPonente;
    }

    public void setIdEventoPonente(int idEventoPonente) {
        this.idEventoPonente = idEventoPonente;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdPonente() {
        return idPonente;
    }

    public void setIdPonente(int idPonente) {
        this.idPonente = idPonente;
    }

    public LocalTime getHoraPresentacion() {
        return horaPresentacion;
    }

    public void setHoraPresentacion(LocalTime horaPresentacion) {
        this.horaPresentacion = horaPresentacion;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "EventoPonente{" +
                "idEventoPonente=" + idEventoPonente +
                ", idEvento=" + idEvento +
                ", idPonente=" + idPonente +
                ", tema='" + tema + '\'' +
                '}';
    }
}
