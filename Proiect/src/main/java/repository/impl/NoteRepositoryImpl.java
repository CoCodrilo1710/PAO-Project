package repository.impl;

import config.DatabaseConfiguration;
import mapper.NoteMapper;
import model.FormaNota;
import model.Locatie;
import model.Materie;
import model.Student;
import repository.NoteRepository;

import java.sql.*;
import java.util.ArrayList;

public class NoteRepositoryImpl implements NoteRepository {
    private static final NoteMapper noteMapper = NoteMapper.getInstance();
    @Override
    public ArrayList<FormaNota> getNoteByIdMaterieStudent(int idMaterieStudent) {
        String selectSql = "SELECT * FROM nota WHERE id_materie_student=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, idMaterieStudent);
            ResultSet resultSet = preparedStatement.executeQuery();
            return noteMapper.mapResultToArray(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNewObject(Student x, Materie y, FormaNota formaNota) {
        String insertSql = "INSERT INTO nota (id, id_materie_student, nota, data) VALUES (?, ?, ?, ?)";
        String selectSql = "SELECT MAX(id) FROM nota";
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

        MateriiRepositoryImpl materiiRepository = new MateriiRepositoryImpl();

        int idMaterieStudentLocal = 0;

        if (materiiRepository.existsEntry(x.getId(), y.getId())) {
            idMaterieStudentLocal = materiiRepository.updateObject(x.getId(), y.getId(), y.getNrNote()+1);
        }
        else {
            idMaterieStudentLocal = materiiRepository.addNewObject(0, y.getNrNote(), x.getId(), y.getId());
            idMaterieStudentLocal+=1;
        }

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, lastId + 1);
            preparedStatement.setInt(2, idMaterieStudentLocal);
            preparedStatement.setInt(3, formaNota.getNota());
            preparedStatement.setDate(4, Date.valueOf(formaNota.getData()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
