package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import conection.ConexionBD;
import exceptions.DAOException;
import models.Persona;
import interface.IPersonaDAO;

public class PersonaDAO implements IPersonaDAO {

    @Override
    public void crear(Persona persona) throws DAOException {
        String sql = "INSERT INTO Persona (nombre, apellido, email, telefono, documento, tipoDocumento, fechaNacimiento, genero) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmail());
            pst.setString(4, persona.getTelefono());
            pst.setString(5, persona.getDocumento());
            pst.setString(6, persona.getTipoDocumento());
            pst.setDate(7, persona.getFechaNacimiento() != null ? Date.valueOf(persona.getFechaNacimiento()) : null);
            pst.setString(8, persona.getGenero());
            
            pst.executeUpdate();
            System.out.println("✓ Persona creada exitosamente");
        } catch (SQLException e) {
            throw new DAOException("Error al crear persona: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Error de conexión: " + e.getMessage(), e);
        }
    }

    @Override
    public Persona obtenerPorId(int id) throws DAOException {
        String sql = "SELECT * FROM Persona WHERE idPersona = ?";
        Persona persona = null;
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                persona = mapResultSetToPersona(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al obtener persona: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Error de conexión: " + e.getMessage(), e);
        }
        
        return persona;
    }

    @Override
    public Persona obtenerPorEmail(String email) throws DAOException {
        String sql = "SELECT * FROM Persona WHERE email = ?";
        Persona persona = null;
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                persona = mapResultSetToPersona(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al obtener persona: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Error de conexión: " + e.getMessage(), e);
        }
        
        return persona;
    }

    @Override
    public List<Persona> obtenerTodos() throws DAOException {
        String sql = "SELECT * FROM Persona";
        List<Persona> personas = new ArrayList<>();
        
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                personas.add(mapResultSetToPersona(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error al obtener personas: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Error de conexión: " + e.getMessage(), e);
        }
        
        return personas;
    }

    @Override
    public void actualizar(Persona persona) throws DAOException {
        String sql = "UPDATE Persona SET nombre = ?, apellido = ?, email = ?, telefono = ?, documento = ?, tipoDocumento = ?, fechaNacimiento = ?, genero = ? WHERE idPersona = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmail());
            pst.setString(4, persona.getTelefono());
            pst.setString(5, persona.getDocumento());
            pst.setString(6, persona.getTipoDocumento());
            pst.setDate(7, persona.getFechaNacimiento() != null ? Date.valueOf(persona.getFechaNacimiento()) : null);
            pst.setString(8, persona.getGenero());
            pst.setInt(9, persona.getIdPersona());
            
            pst.executeUpdate();
            System.out.println("✓ Persona actualizada exitosamente");
        } catch (SQLException e) {
            throw new DAOException("Error al actualizar persona: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Error de conexión: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM Persona WHERE idPersona = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✓ Persona eliminada exitosamente");
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar persona: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Error de conexión: " + e.getMessage(), e);
        }
    }

    private Persona mapResultSetToPersona(ResultSet rs) throws SQLException {
        Persona persona = new Persona();
        persona.setIdPersona(rs.getInt("idPersona"));
        persona.setNombre(rs.getString("nombre"));
        persona.setApellido(rs.getString("apellido"));
        persona.setEmail(rs.getString("email"));
        persona.setTelefono(rs.getString("telefono"));
        persona.setDocumento(rs.getString("documento"));
        persona.setTipoDocumento(rs.getString("tipoDocumento"));
        
        Date fechaBD = rs.getDate("fechaNacimiento");
        if (fechaBD != null) {
            persona.setFechaNacimiento(fechaBD.toLocalDate());
        }
        
        persona.setGenero(rs.getString("genero"));
        return persona;
    }
}
