package repository.impl;

import config.DatabaseConfiguration;
import mapper.GrupaMapper;
import mapper.LocatieMapper;
import model.Grupa;
import model.Locatie;
import repository.LocatieRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LocatieRepositoryImpl implements LocatieRepository {
    private static final LocatieMapper locatieMapper = LocatieMapper.getInstance();

    @Override
    public Optional<Locatie> getObjectById(int id) {
        String selectSql = "SELECT * FROM locatie WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return locatieMapper.mapToLocatie(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }


    @Override
    public void deleteObjectById(int id) {
        String deleteLocatieSql = "DELETE FROM locatie WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteLocatieSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(int id, Locatie newObject) {
        String updateLocatieSql = "UPDATE locatie \n" +
                "SET nume=? ,\n" +
                "judet=? ,\n" +
                "oras=? ,\n" +
                "adresa=? ,\n" +
                "tara=?\n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateLocatieSql);
            preparedStatement.setString(1, newObject.getNume());
            preparedStatement.setString(2, newObject.getJudet());
            preparedStatement.setString(3, newObject.getOras());
            preparedStatement.setString(4, newObject.getAdresa());
            preparedStatement.setString(5, newObject.getTara());
            preparedStatement.setObject(6, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Locatie locatie) {
        String insertSql = "INSERT INTO locatie (id, nume, judet, oras, adresa, tara) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, locatie.getId());
            preparedStatement.setString(2, locatie.getNume());
            preparedStatement.setString(3, locatie.getJudet());
            preparedStatement.setString(4, locatie.getOras());
            preparedStatement.setString(5, locatie.getAdresa());
            preparedStatement.setString(6, locatie.getTara());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
