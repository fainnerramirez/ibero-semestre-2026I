package models;

public class EventoCategoria {
    private int idEventoCategoria;
    private int idEvento;
    private int idCategoria;

    public EventoCategoria() {
    }

    public EventoCategoria(int idEvento, int idCategoria) {
        this.idEvento = idEvento;
        this.idCategoria = idCategoria;
    }

    public int getIdEventoCategoria() {
        return idEventoCategoria;
    }

    public void setIdEventoCategoria(int idEventoCategoria) {
        this.idEventoCategoria = idEventoCategoria;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "EventoCategoria{" +
                "idEventoCategoria=" + idEventoCategoria +
                ", idEvento=" + idEvento +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
