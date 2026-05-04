package models;

public class Organizador extends Persona {
    private int idOrganizador;
    private String empresa;
    private String telefonoEmpresa;
    private String emailEmpresa;
    private int numeroEventos;

    public Organizador() {
    }

    public Organizador(String nombre, String apellido, String email, String telefono,
                      String documento, String tipoDocumento, String empresa) {
        super(nombre, apellido, email, telefono, documento, tipoDocumento, null, null);
        this.empresa = empresa;
        this.numeroEventos = 0;
    }

    public int getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(int idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public int getNumeroEventos() {
        return numeroEventos;
    }

    public void setNumeroEventos(int numeroEventos) {
        this.numeroEventos = numeroEventos;
    }

    @Override
    public String toString() {
        return "Organizador{" +
                "idOrganizador=" + idOrganizador +
                ", nombre='" + getNombre() + '\'' +
                ", empresa='" + empresa + '\'' +
                ", numeroEventos=" + numeroEventos +
                '}';
    }
}
