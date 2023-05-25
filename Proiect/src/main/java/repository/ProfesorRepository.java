package repository;

import model.abstractsSealed.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepository {

    Optional<Profesor> getObjectById(int id);

    void deleteObjectById(int id);

    void updateObjectById(int id, Profesor newObject);

    void addNewObject(Profesor profesor);

    List<Profesor> getAllObjects();

}