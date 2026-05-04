package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private int idEvento;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int idUbicacion;
    private int idTipoEvento;
    private int idModalidad;
    private int idOrganizador;
    private String estado;
    private BigDecimal presupuesto;
    private List<Categoria> categorias;

    public Evento() {
        this.categorias = new ArrayList<>();
    }

    public Evento(String nombre, String descripcion, LocalDateTime fechaInicio, 
                  LocalDateTime fechaFin, int idUbicacion, int idTipoEvento, 
                  int idModalidad, int idOrganizador, String estado, BigDecimal presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idUbicacion = idUbicacion;
        this.idTipoEvento = idTipoEvento;
        this.idModalidad = idModalidad;
        this.idOrganizador = idOrganizador;
        this.estado = estado;
        this.presupuesto = presupuesto;
        this.categorias = new ArrayList<>();
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public int getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(int idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(int idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento=" + idEvento +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado='" + estado + '\'' +
                '}';
    }
}
