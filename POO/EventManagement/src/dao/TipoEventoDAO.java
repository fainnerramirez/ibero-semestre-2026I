package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conection.ConexionBD;
import exceptions.DAOException;
import models.TipoEvento;

public class TipoEventoDAO {

    public void crear(TipoEvento tipoEvento) throws DAOException {
        String sql = "INSERT INTO TipoEventos (nombre, descripcion) VALUES (?, ?)";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, tipoEvento.getNombre());
            pst.setString(2, tipoEvento.getDescripcion());
            pst.executeUpdate();
            System.out.println("✓ Tipo de evento creado exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al crear tipo de evento: " + e.getMessage(), e);
        }
    }

    public TipoEvento obtenerPorId(int id) throws DAOException {
        String sql = "SELECT * FROM TipoEventos WHERE idTipoEvento = ?";
        TipoEvento tipoEvento = null;
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                tipoEvento = mapResultSetToTipoEvento(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener tipo de evento: " + e.getMessage(), e);
        }
        
        return tipoEvento;
    }

    public List<TipoEvento> obtenerTodos() throws DAOException {
        String sql = "SELECT * FROM TipoEventos";
        List<TipoEvento> tiposEventos = new ArrayList<>();
        
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                tiposEventos.add(mapResultSetToTipoEvento(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener tipos de eventos: " + e.getMessage(), e);
        }
        
        return tiposEventos;
    }

    public void actualizar(TipoEvento tipoEvento) throws DAOException {
        String sql = "UPDATE TipoEventos SET nombre = ?, descripcion = ? WHERE idTipoEvento = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, tipoEvento.getNombre());
            pst.setString(2, tipoEvento.getDescripcion());
            pst.setInt(3, tipoEvento.getIdTipoEvento());
            pst.executeUpdate();
            System.out.println("✓ Tipo de evento actualizado exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al actualizar tipo de evento: " + e.getMessage(), e);
        }
    }

    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM TipoEventos WHERE idTipoEvento = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✓ Tipo de evento eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al eliminar tipo de evento: " + e.getMessage(), e);
        }
    }

    private TipoEvento mapResultSetToTipoEvento(ResultSet rs) throws SQLException {
        TipoEvento tipoEvento = new TipoEvento();
        tipoEvento.setIdTipoEvento(rs.getInt("idTipoEvento"));
        tipoEvento.setNombre(rs.getString("nombre"));
        tipoEvento.setDescripcion(rs.getString("descripcion"));
        return tipoEvento;
    }
}
