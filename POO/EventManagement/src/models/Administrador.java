package models;

public class Administrador extends Persona {
    private int idAdministrador;
    private String numeroControl;
    private int nivelAcceso;
    private String estado;

    public Administrador() {
    }

    public Administrador(String nombre, String apellido, String email, String telefono,
                        String documento, String tipoDocumento, String numeroControl) {
        super(nombre, apellido, email, telefono, documento, tipoDocumento, null, null);
        this.numeroControl = numeroControl;
        this.nivelAcceso = 1;
        this.estado = "Activo";
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador=" + idAdministrador +
                ", nombre='" + getNombre() + '\'' +
                ", numeroControl='" + numeroControl + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
