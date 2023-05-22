package mapper;

import model.Profesor;
import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
