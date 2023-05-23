package repository.impl;

import config.DatabaseConfiguration;
import mapper.GrupaMapper;
import model.Grupa;
import repository.GrupaRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GrupaRepositoryImpl implements GrupaRepository {
    private static final GrupaMapper grupaMapper = GrupaMapper.getInstance();
    public Optional<Grupa> getObjectById(int id) {
        String selectSql = "SELECT * FROM grupa WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return grupaMapper.mapToGrupa(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public void deleteObjectById(int id) {
        String deleteGrupaSql = "DELETE FROM grupa WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteGrupaSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(int id, Grupa newObject) {
        String updateGrupaSql = "UPDATE grupa \n" +
                "SET numargrupa=?\n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateGrupaSql);
            preparedStatement.setString(1, newObject.getNumarGrupaString());
            preparedStatement.setObject(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Grupa grupa) {
        String insertSql = "INSERT INTO grupa (id, idlocatie, numargrupa) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, grupa.getId());
            preparedStatement.setInt(2, grupa.getLocatie().getId());
            preparedStatement.setString(3, grupa.getNumarGrupaString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAllFromGivenList(List<Grupa> grupeList) {
        grupeList.forEach(this::addNewObject);
    }
}
