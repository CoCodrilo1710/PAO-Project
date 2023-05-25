package service;

import model.Materie;
import model.Student;

import java.time.LocalDate;

public interface StudentService {

    void setMedieStudent(Student x);

    void setMediePerMaterie(Student x, Materie y);

    void setRestantaMaterii(Student x);

    void afisareStudent(Student x);

    void adaugaNota(Student x, int y, int nota, LocalDate data);

    void stergeNota(Student x, int y, int nota, LocalDate data);

    Student returnStudent();

    Materie getMateriebyId(Student x, int id);

}
