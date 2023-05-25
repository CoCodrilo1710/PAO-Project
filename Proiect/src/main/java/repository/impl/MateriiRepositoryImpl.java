package repository.impl;

import config.DatabaseConfiguration;
import mapper.MateriiMapper;
import mapper.ProfesorMapper;
import model.Grupa;
import model.Materie;
import repository.MateriiRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MateriiRepositoryImpl implements MateriiRepository {

    private static final MateriiMapper materiiMapper = MateriiMapper.getInstance();
    @Override
    public List<Integer> getIdMateriiByIdStudent(int idStudent, int idMaterie) {
            String selectSql = "SELECT * FROM materie_student WHERE idstudent=? and idmaterie=?";
            try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                preparedStatement.setObject(1, idStudent);
                preparedStatement.setObject(2, idMaterie);
                ResultSet resultSet = preparedStatement.executeQuery();
                return materiiMapper.mapResultToArray(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public List<String> getAllMaterii() {
        String selectSql = "SELECT * FROM materie";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return materiiMapper.allMaterii(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addNewObject(int nrAbsente, int nrNote, int idStudent, int idMaterie) {
        String insertSql = "INSERT INTO materie_student (id, nrabsente, nrnote, idmaterie, idstudent) VALUES (?, ?, ?, ?, ?)";
        String selectSql = "SELECT MAX(id) FROM materie_student";

        int lastId = 0;
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lastId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, (lastId + 1));
            preparedStatement.setInt(2, nrAbsente);
            preparedStatement.setInt(3, (nrNote+1));
            preparedStatement.setInt(4, idMaterie);
            preparedStatement.setInt(5, idStudent);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastId;
    }

    public Boolean existsEntry(int idStudent, int idMaterie) {
        String selectSql = "SELECT * FROM materie_student WHERE idstudent=? and idmaterie=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, idStudent);
            preparedStatement.setObject(2, idMaterie);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int updateObject(int idStudent, int idMaterie, int nrNote)
    {
        String updateGrupaSql = "UPDATE materie_student SET nrnote=? WHERE idstudent=? and idmaterie=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateGrupaSql);
            preparedStatement.setInt(1, nrNote);
            preparedStatement.setObject(2, idStudent);
            preparedStatement.setObject(3, idMaterie);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String selectSql = "SELECT id FROM materie_student WHERE idstudent=? and idmaterie=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, idStudent);
            preparedStatement.setObject(2, idMaterie);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 5;
    }
}

