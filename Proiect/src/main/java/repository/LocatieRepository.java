package repository;

import model.Locatie;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocatieRepository {

    Optional<Locatie> getObjectById(int id);

    void deleteObjectById(int id);

    void updateObjectById(int id, Locatie newObject);

    void addNewObject(Locatie locatie);

}