package interface;

import java.util.List;
import exceptions.DAOException;

public interface IPersonaDAO {
    void crear(models.Persona persona) throws DAOException;
    models.Persona obtenerPorId(int id) throws DAOException;
    models.Persona obtenerPorEmail(String email) throws DAOException;
    List<models.Persona> obtenerTodos() throws DAOException;
    void actualizar(models.Persona persona) throws DAOException;
    void eliminar(int id) throws DAOException;
}
