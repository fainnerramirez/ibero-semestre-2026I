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
import models.ModalidadEvento;

public class ModalidadEventoDAO {

    public void crear(ModalidadEvento modalidad) throws DAOException {
        String sql = "INSERT INTO ModalidadEvento (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, modalidad.getNombre());
            pst.setString(2, modalidad.getDescripcion());
            pst.executeUpdate();
            System.out.println("✓ Modalidad creada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al crear modalidad: " + e.getMessage(), e);
        }
    }

    public ModalidadEvento obtenerPorId(int id) throws DAOException {
        String sql = "SELECT * FROM ModalidadEvento WHERE idModalidad = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return mapResultSetToModalidad(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener modalidad: " + e.getMessage(), e);
        }
        return null;
    }

    public List<ModalidadEvento> obtenerTodas() throws DAOException {
        String sql = "SELECT * FROM ModalidadEvento";
        List<ModalidadEvento> modalidades = new ArrayList<>();
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                modalidades.add(mapResultSetToModalidad(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener modalidades: " + e.getMessage(), e);
        }
        return modalidades;
    }

    public void actualizar(ModalidadEvento modalidad) throws DAOException {
        String sql = "UPDATE ModalidadEvento SET nombre = ?, descripcion = ? WHERE idModalidad = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, modalidad.getNombre());
            pst.setString(2, modalidad.getDescripcion());
            pst.setInt(3, modalidad.getIdModalidad());
            pst.executeUpdate();
            System.out.println("✓ Modalidad actualizada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al actualizar modalidad: " + e.getMessage(), e);
        }
    }

    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM ModalidadEvento WHERE idModalidad = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✓ Modalidad eliminada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al eliminar modalidad: " + e.getMessage(), e);
        }
    }

    private ModalidadEvento mapResultSetToModalidad(ResultSet rs) throws SQLException {
        ModalidadEvento modalidad = new ModalidadEvento();
        modalidad.setIdModalidad(rs.getInt("idModalidad"));
        modalidad.setNombre(rs.getString("nombre"));
        modalidad.setDescripcion(rs.getString("descripcion"));
        return modalidad;
    }
}
