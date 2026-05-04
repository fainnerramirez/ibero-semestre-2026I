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
import models.Ubicacion;

public class UbicacionDAO {

    public void crear(Ubicacion ubicacion) throws DAOException {
        String sql = "INSERT INTO Ubicacion (direccion, ciudad, pais, capacidad) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, ubicacion.getDireccion());
            pst.setString(2, ubicacion.getCiudad());
            pst.setString(3, ubicacion.getPais());
            pst.setInt(4, ubicacion.getCapacidad());
            
            pst.executeUpdate();
            System.out.println("✓ Ubicación creada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al crear ubicación: " + e.getMessage(), e);
        }
    }

    public Ubicacion obtenerPorId(int id) throws DAOException {
        String sql = "SELECT * FROM Ubicacion WHERE idUbicacion = ?";
        Ubicacion ubicacion = null;
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                ubicacion = mapResultSetToUbicacion(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener ubicación: " + e.getMessage(), e);
        }
        
        return ubicacion;
    }

    public List<Ubicacion> obtenerTodas() throws DAOException {
        String sql = "SELECT * FROM Ubicacion";
        List<Ubicacion> ubicaciones = new ArrayList<>();
        
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                ubicaciones.add(mapResultSetToUbicacion(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener ubicaciones: " + e.getMessage(), e);
        }
        
        return ubicaciones;
    }

    public void actualizar(Ubicacion ubicacion) throws DAOException {
        String sql = "UPDATE Ubicacion SET direccion = ?, ciudad = ?, pais = ?, capacidad = ? WHERE idUbicacion = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, ubicacion.getDireccion());
            pst.setString(2, ubicacion.getCiudad());
            pst.setString(3, ubicacion.getPais());
            pst.setInt(4, ubicacion.getCapacidad());
            pst.setInt(5, ubicacion.getIdUbicacion());
            
            pst.executeUpdate();
            System.out.println("✓ Ubicación actualizada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al actualizar ubicación: " + e.getMessage(), e);
        }
    }

    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM Ubicacion WHERE idUbicacion = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✓ Ubicación eliminada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al eliminar ubicación: " + e.getMessage(), e);
        }
    }

    private Ubicacion mapResultSetToUbicacion(ResultSet rs) throws SQLException {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setIdUbicacion(rs.getInt("idUbicacion"));
        ubicacion.setDireccion(rs.getString("direccion"));
        ubicacion.setCiudad(rs.getString("ciudad"));
        ubicacion.setPais(rs.getString("pais"));
        ubicacion.setCapacidad(rs.getInt("capacidad"));
        return ubicacion;
    }
}
