package models;

public class Asistente extends Persona {
    private int idAsistente;
    private String interesCategorias;
    private int historialAsistencias;

    public Asistente() {
    }

    public Asistente(String nombre, String apellido, String email, String telefono,
                    String documento, String tipoDocumento) {
        super(nombre, apellido, email, telefono, documento, tipoDocumento, null, null);
        this.historialAsistencias = 0;
    }

    public int getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    public String getInteresCategorias() {
        return interesCategorias;
    }

    public void setInteresCategorias(String interesCategorias) {
        this.interesCategorias = interesCategorias;
    }

    public int getHistorialAsistencias() {
        return historialAsistencias;
    }

    public void setHistorialAsistencias(int historialAsistencias) {
        this.historialAsistencias = historialAsistencias;
    }

    @Override
    public String toString() {
        return "Asistente{" +
                "idAsistente=" + idAsistente +
                ", nombre='" + getNombre() + '\'' +
                ", historialAsistencias=" + historialAsistencias +
                '}';
    }
}
