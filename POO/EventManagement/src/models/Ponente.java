package models;

public class Ponente extends Persona {
    private int idPonente;
    private String especialidad;
    private String biografia;
    private int experienciaAnios;

    public Ponente() {
    }

    public Ponente(String nombre, String apellido, String email, String telefono,
                  String documento, String tipoDocumento, String especialidad) {
        super(nombre, apellido, email, telefono, documento, tipoDocumento, null, null);
        this.especialidad = especialidad;
        this.experienciaAnios = 0;
    }

    public int getIdPonente() {
        return idPonente;
    }

    public void setIdPonente(int idPonente) {
        this.idPonente = idPonente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getExperienciaAnios() {
        return experienciaAnios;
    }

    public void setExperienciaAnios(int experienciaAnios) {
        this.experienciaAnios = experienciaAnios;
    }

    @Override
    public String toString() {
        return "Ponente{" +
                "idPonente=" + idPonente +
                ", nombre='" + getNombre() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", experienciaAnios=" + experienciaAnios +
                '}';
    }
}
