package repository.impl;

import config.DatabaseConfiguration;
import mapper.StudentMapper;
import model.Student;
import repository.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.TreeSet;

public class StudentRepositoryImpl implements StudentRepository {
    private static final StudentMapper studentMapper = StudentMapper.getInstance();
    @Override
    public Optional<Student> getObjectById(int id) {
        String selectSql = "SELECT * FROM persoana WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return studentMapper.mapToStudent(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteObjectById(int id) {
        String deleteStudentSql = "DELETE FROM persoana WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(int id, Student newObject) {
        String updateStudentSql = "UPDATE locatie \n" +
                "SET cnp=? ,\n" +
                "nume=? ,\n" +
                "prenume=? ,\n" +
                "email=? ,\n" +
                "telefon=? ,\n" +
                "semestru=? ,\n" +
                "andestudiu=?\n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateStudentSql);
            preparedStatement.setString(1, newObject.getCnp());
            preparedStatement.setString(2, newObject.getNume());
            preparedStatement.setString(3, newObject.getPrenume());
            preparedStatement.setString(4, newObject.getStudentEmail());
            preparedStatement.setString(5, newObject.getNrTelefon());
            preparedStatement.setInt(6, newObject.getsemestru());
            preparedStatement.setInt(7, newObject.getAndeStudiu());
            preparedStatement.setObject(8, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastId() {
        String selectSql = "SELECT MAX(id) FROM persoana";

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
        return lastId;
    }

    @Override
    public void addNewObject(Student student) {
        String insertSql = "INSERT INTO persoana (id, cnp, nume, prenume, email, telefon, rank, salariu, semestru, andestudiu, idgrupa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int lastId = getLastId();
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, lastId+1);
            preparedStatement.setString(2, student.getCnp());
            preparedStatement.setString(3, student.getNume());
            preparedStatement.setString(4, student.getPrenume());
            preparedStatement.setString(5, student.getStudentEmail());
            preparedStatement.setString(6, student.getNrTelefon());
            preparedStatement.setObject(7, null);
            preparedStatement.setObject(8, null);
            preparedStatement.setInt(9, student.getsemestru());
            preparedStatement.setInt(10, student.getAndeStudiu());
            preparedStatement.setInt(11, 1);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TreeSet<Student> getAllObjects() {

        String selectSql = "SELECT * FROM persoana WHERE andestudiu is not NULL";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return studentMapper.listMapToStudent(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
