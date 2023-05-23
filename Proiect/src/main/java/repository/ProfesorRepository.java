package repository;

import model.Profesor;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfesorRepository {

    Optional<Profesor> getObjectById(int id);

    void deleteObjectById(int id);

    void updateObjectById(int id, Profesor newObject);

    void addNewObject(Profesor profesor);

    List<Profesor> getAllObjects();

}