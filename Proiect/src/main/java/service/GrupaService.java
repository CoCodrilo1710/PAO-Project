package service;

import model.abstractsSealed.Profesor;
import model.abstractsSealed.Student;
import model.Grupa;

import java.util.Optional;

public interface GrupaService {

    void afisareGrupa(model.Grupa x);

    void setareMedieGrupa(model.Grupa x);

    void setareRestantaGrupa(model.Grupa x);

    void setareMedieMateriiGrupa(Grupa x);

    boolean exitaStudent(model.Grupa x, String nume, String prenume);

    Student getStudentByName(model.Grupa x, String nume, String prenume);

    int returnNrRestanti(model.Grupa x);

    void setareProfesorMass(model.Grupa x, Profesor y, int numarMaterie);

    void stergereProfesorMass(model.Grupa x, int numarMaterie);

    Grupa returnGrupaOrdonataByMedie(model.Grupa x);

    void adaugareStudent(Grupa x, Student y);

    void stergereStudent(Grupa x, Student y);

    boolean exitaStudent(Grupa x, String cnp);

    Student getStudentByCNP(Grupa x, String cnp);

    int getterNrStudenti(Grupa x);

    void firstStartDB(Optional<Grupa> grupa);
}
