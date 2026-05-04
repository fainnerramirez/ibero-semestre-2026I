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
import models.Categoria;

public class CategoriaDAO {

    public void crear(Categoria categoria) throws DAOException {
        String sql = "INSERT INTO Categoria (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, categoria.getNombre());
            pst.setString(2, categoria.getDescripcion());
            pst.executeUpdate();
            System.out.println("✓ Categoría creada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al crear categoría: " + e.getMessage(), e);
        }
    }

    public Categoria obtenerPorId(int id) throws DAOException {
        String sql = "SELECT * FROM Categoria WHERE idCategoria = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return mapResultSetToCategoria(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener categoría: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Categoria> obtenerTodas() throws DAOException {
        String sql = "SELECT * FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                categorias.add(mapResultSetToCategoria(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al obtener categorías: " + e.getMessage(), e);
        }
        return categorias;
    }

    public void actualizar(Categoria categoria) throws DAOException {
        String sql = "UPDATE Categoria SET nombre = ?, descripcion = ? WHERE idCategoria = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, categoria.getNombre());
            pst.setString(2, categoria.getDescripcion());
            pst.setInt(3, categoria.getIdCategoria());
            pst.executeUpdate();
            System.out.println("✓ Categoría actualizada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al actualizar categoría: " + e.getMessage(), e);
        }
    }

    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM Categoria WHERE idCategoria = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✓ Categoría eliminada exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error al eliminar categoría: " + e.getMessage(), e);
        }
    }

    private Categoria mapResultSetToCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("idCategoria"));
        categoria.setNombre(rs.getString("nombre"));
        categoria.setDescripcion(rs.getString("descripcion"));
        return categoria;
    }
}
