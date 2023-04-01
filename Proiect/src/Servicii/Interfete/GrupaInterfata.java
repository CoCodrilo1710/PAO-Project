package Servicii.Interfete;

import entitati.Profesor;
import entitati.Student;
import entitati.Grupa;

public interface GrupaInterfata {

    void afisareGrupa(entitati.Grupa x);

    void setareMedieGrupa(entitati.Grupa x);

    void setareRestantaGrupa(entitati.Grupa x);

    void setareMedieMateriiGrupa(Grupa x);

    boolean exitaStudent(entitati.Grupa x, String nume, String prenume);

    Student getStudentByName(entitati.Grupa x, String nume, String prenume);

    int returnNrRestanti(entitati.Grupa x);

    void setareProfesorMass(entitati.Grupa x, Profesor y, int numarMaterie);

    void stergereProfesorMass(entitati.Grupa x, int numarMaterie);

    Grupa returnGrupaOrdonataByMedie(entitati.Grupa x);

    void adaugareStudent(Grupa x, Student y);

    void stergereStudent(Grupa x, Student y);

    boolean exitaStudent(Grupa x, String cnp);

    Student getStudentByCNP(Grupa x, String cnp);

    int getterNrStudenti(Grupa x);
}
