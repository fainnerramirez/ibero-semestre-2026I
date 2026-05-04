package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pago {
    private int idPago;
    private int idInscripcion;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDateTime fechaPago;
    private String estado;

    public Pago() {
    }

    public Pago(int idInscripcion, BigDecimal monto, String metodoPago, String estado) {
        this.idInscripcion = idInscripcion;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.fechaPago = LocalDateTime.now();
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", monto=" + monto +
                ", metodoPago='" + metodoPago + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
