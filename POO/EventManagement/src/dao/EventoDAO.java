package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import conection.ConexionBD;
import exceptions.DAOException;
import models.Evento;

public class EventoDAO {

    public void crear(Evento evento) throws DAOException {
        String sql = "INSERT INTO Evento (nombre, descripcion, fechaInicio, fechaFin, idUbicacion, idTipoEvento, idModalidad, idOrganizador, estado, presupuesto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, evento.getNombre());
            pst.setString(2, evento.getDescripcion());
            pst.setTimestamp(3, Timestamp.valueOf(evento.getFechaInicio()));
            pst.setTimestamp(4, Timestamp.valueOf(evento.getFechaFin()));
            pst.setInt(5, evento.getIdUbicacion());
            pst.setInt(6, evento.getIdTipoEvento());
            pst.setInt(7, evento.getIdModalidad());
            pst.setInt(8, evento.getIdOrganizador());
            pst.setString(9, evento.getEstado());
            pst.setBigDecimal(10, evento.getPresupuesto());
            pst.executeUpdate();
            System.out.println("✓ Evento creado exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al crear evento: " + e.getMessage(), e);
        }
    }

    public Evento obtenerPorId(int id) throws DAOException {
        String sql = "SELECT * FROM Evento WHERE idEvento = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return mapResultSetToEvento(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener evento: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Evento> obtenerTodos() throws DAOException {
        String sql = "SELECT * FROM Evento ORDER BY fechaInicio DESC";
        List<Evento> eventos = new ArrayList<>();
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                eventos.add(mapResultSetToEvento(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener eventos: " + e.getMessage(), e);
        }
        return eventos;
    }

    public List<Evento> obtenerPorEstado(String estado) throws DAOException {
        String sql = "SELECT * FROM Evento WHERE estado = ? ORDER BY fechaInicio DESC";
        List<Evento> eventos = new ArrayList<>();
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, estado);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                eventos.add(mapResultSetToEvento(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener eventos por estado: " + e.getMessage(), e);
        }
        return eventos;
    }

    public void actualizar(Evento evento) throws DAOException {
        String sql = "UPDATE Evento SET nombre = ?, descripcion = ?, fechaInicio = ?, fechaFin = ?, idUbicacion = ?, " +
                "idTipoEvento = ?, idModalidad = ?, idOrganizador = ?, estado = ?, presupuesto = ? WHERE idEvento = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, evento.getNombre());
            pst.setString(2, evento.getDescripcion());
            pst.setTimestamp(3, Timestamp.valueOf(evento.getFechaInicio()));
            pst.setTimestamp(4, Timestamp.valueOf(evento.getFechaFin()));
            pst.setInt(5, evento.getIdUbicacion());
            pst.setInt(6, evento.getIdTipoEvento());
            pst.setInt(7, evento.getIdModalidad());
            pst.setInt(8, evento.getIdOrganizador());
            pst.setString(9, evento.getEstado());
            pst.setBigDecimal(10, evento.getPresupuesto());
            pst.setInt(11, evento.getIdEvento());
            pst.executeUpdate();
            System.out.println("✓ Evento actualizado exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al actualizar evento: " + e.getMessage(), e);
        }
    }

    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM Evento WHERE idEvento = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✓ Evento eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al eliminar evento: " + e.getMessage(), e);
        }
    }

    private Evento mapResultSetToEvento(ResultSet rs) throws SQLException {
        Evento evento = new Evento();
        evento.setIdEvento(rs.getInt("idEvento"));
        evento.setNombre(rs.getString("nombre"));
        evento.setDescripcion(rs.getString("descripcion"));
        evento.setFechaInicio(rs.getTimestamp("fechaInicio").toLocalDateTime());
        evento.setFechaFin(rs.getTimestamp("fechaFin").toLocalDateTime());
        evento.setIdUbicacion(rs.getInt("idUbicacion"));
        evento.setIdTipoEvento(rs.getInt("idTipoEvento"));
        evento.setIdModalidad(rs.getInt("idModalidad"));
        evento.setIdOrganizador(rs.getInt("idOrganizador"));
        evento.setEstado(rs.getString("estado"));
        evento.setPresupuesto(rs.getBigDecimal("presupuesto"));
        return evento;
    }
}
