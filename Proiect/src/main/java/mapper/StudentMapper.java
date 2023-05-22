package mapper;

import model.Grupa;
import model.Locatie;
import model.Student;
import org.apache.commons.collections4.queue.PredicatedQueue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StudentMapper {
    private static final StudentMapper INSTANCE = new StudentMapper();

    private StudentMapper() {
    }

    public static StudentMapper getInstance() {
        return INSTANCE;
    }

    public ArrayList<Student> listMapToStudent(ResultSet resultSet) throws SQLException {
        ArrayList<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            studentList.add(Student.builder()
                    .id(resultSet.getInt(1))
                    .cnp(resultSet.getString(2))
                    .nume(resultSet.getString(3))
                    .prenume(resultSet.getString(4))
                    .studentEmail(resultSet.getString(5))
                    .nrTelefon(resultSet.getString(6))
                    .andeStudiu(resultSet.getInt(10))
                    .semestru(resultSet.getInt(9))
                    .build()
            );

        }
        return studentList;
    }
}
