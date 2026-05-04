package models;

public class Ubicacion {
    private int idUbicacion;
    private String direccion;
    private String ciudad;
    private String pais;
    private int capacidad;

    public Ubicacion() {
    }

    public Ubicacion(String direccion, String ciudad, String pais, int capacidad) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.capacidad = capacidad;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "idUbicacion=" + idUbicacion +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
