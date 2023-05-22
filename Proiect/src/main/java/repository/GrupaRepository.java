package repository;

import model.Grupa;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GrupaRepository {

    Optional<Grupa> getObjectById(int id);

    void deleteObjectById(int id);

    void updateObjectById(int id, Grupa newObject);

    void addNewObject(Grupa grupa);

    void addAllFromGivenList(List<Grupa> grupeList);
}