package Servicii.Interfete;

import entitati.Materie;
import entitati.Student;

import java.time.LocalDate;

public interface StudentInterfata {

    void setMedieStudent(Student x);

    void setMediePerMaterie(Student x, Materie y);

    void setRestantaMaterii(Student x);

    void afisareStudent(Student x);

    void adaugaNota(Student x, int y, int nota, LocalDate data);

    void stergeNota(Student x, int y, int nota, LocalDate data);

    Student returnStudent();

}
