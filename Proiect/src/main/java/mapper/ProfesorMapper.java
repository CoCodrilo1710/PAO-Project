package mapper;

import model.Profesor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfesorMapper {

    private static final ProfesorMapper INSTANCE = new ProfesorMapper();

    private ProfesorMapper() {
    }

    public static ProfesorMapper getInstance() {
        return INSTANCE;
    }


    public List<Profesor> mapListToProfesor(ResultSet resultSet) throws SQLException {

        ArrayList<Profesor> profesorList = new ArrayList<>();
        while (resultSet.next()) {
            profesorList.add(Profesor.builder()
                    .id(resultSet.getInt(1))
                    .cnp(resultSet.getString(2))
                    .nume(resultSet.getString(3))
                    .prenume(resultSet.getString(4))
                    .email(resultSet.getString(5))
                    .rank(resultSet.getString(7))
                    .salariu(resultSet.getInt(8))
                    .build()
            );

        }
        return profesorList;

    }

    public Optional<Profesor> mapToProfesor(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return Optional.of(Profesor.builder()
                        .id(resultSet.getInt(1))
                        .cnp(resultSet.getString(2))
                        .nume(resultSet.getString(3))
                        .prenume(resultSet.getString(4))
                        .email(resultSet.getString(5))
                        .rank(resultSet.getString(7))
                        .salariu(resultSet.getInt(8))
                        .build()
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }
}
