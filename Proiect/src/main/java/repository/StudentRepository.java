package repository;

import model.abstractsSealed.Student;

import java.util.Optional;
import java.util.TreeSet;

public interface StudentRepository {
    Optional<Student> getObjectById(int id);

    void deleteObjectById(int id);

    void updateObjectById(int id, Student newObject);

    void addNewObject(Student student);

    TreeSet<Student> getAllObjects();

    int getLastId();
}
