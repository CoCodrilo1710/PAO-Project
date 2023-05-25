package repository;

import model.FormaNota;
import model.Materie;
import model.abstractsSealed.Student;

import java.util.ArrayList;

public interface NoteRepository {
    ArrayList<FormaNota> getNoteByIdMaterieStudent(int id_materie_student);
    public void addNewObject(Student x, Materie y, FormaNota formaNota);
}
