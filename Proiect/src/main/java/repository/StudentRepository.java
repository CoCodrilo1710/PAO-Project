package repository;

import model.Profesor;
import model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> getObjectById(int id);

    void deleteObjectById(int id);

    void updateObjectById(int id, Student newObject);

    void addNewObject(Student student);

    List<Student> getAllObjects();

}
