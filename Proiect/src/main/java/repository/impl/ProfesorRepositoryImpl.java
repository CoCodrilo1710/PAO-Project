package repository.impl;

import config.DatabaseConfiguration;
import mapper.ProfesorMapper;
import model.Profesor;
import org.apache.commons.lang3.ObjectUtils;
import repository.ProfesorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProfesorRepositoryImpl implements ProfesorRepository {
    private static final ProfesorMapper profesorMapper = ProfesorMapper.getInstance();
    @Override
    public Optional<Profesor> getObjectById(int id) {
        String selectSql = "SELECT * FROM persoana WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return profesorMapper.mapToProfesor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteObjectById(int id) {
        String deleteLocatieSql = "DELETE FROM persoana WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteLocatieSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(int id, Profesor newObject) {
        String updateLocatieSql = "UPDATE locatie \n" +
                "SET cnp=? ,\n" +
                "nume=? ,\n" +
                "prenume=? ,\n" +
                "email=? ,\n" +
                "rank=? ,\n" +
                "salariu=?\n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateLocatieSql);
            preparedStatement.setString(1, newObject.getCnp());
            preparedStatement.setString(2, newObject.getNume());
            preparedStatement.setString(3, newObject.getPrenume());
            preparedStatement.setString(4, newObject.getEmail());
            preparedStatement.setString(5, newObject.getRank());
            preparedStatement.setInt(6, newObject.getSalariu());
            preparedStatement.setObject(7, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Profesor profesor) {
        String insertSql = "INSERT INTO persoana (id, cnp, nume, prenume, email, telefon, rank, salariu, semestru, andestudiu, idgrupa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, profesor.getId());
            preparedStatement.setString(2, profesor.getCnp());
            preparedStatement.setString(3, profesor.getNume());
            preparedStatement.setString(4, profesor.getPrenume());
            preparedStatement.setString(5, profesor.getEmail());
            preparedStatement.setString(6, "");
            preparedStatement.setString(7, profesor.getRank());
            preparedStatement.setInt(8, profesor.getSalariu());
            preparedStatement.setObject(9, null);
            preparedStatement.setObject(10, null);
            preparedStatement.setInt(11, 1);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Profesor> getAllObjects()
    {
        String selectSql = "SELECT * FROM persoana WHERE rank is not NULL";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return profesorMapper.mapListToProfesor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
