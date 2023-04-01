package Servicii.Interfete;

import entitati.Materie;
import entitati.Profesor;

import java.time.LocalDate;
import java.util.Vector;

public interface MateriiInterfata {
    void setterMateri(Vector<Materie> local_vector);

    void afisareMaterii();

    void add_nota(Vector<Materie> local, int materie, int nota, LocalDate data);

    int return_nota(Vector<Materie> local, int materie, int pozitie);

    LocalDate return_data(Vector<Materie> local, int materie, int pozitie);

    String numeMaterie(Vector<Materie> local, int materie);

    void addAbsenta(Vector<Materie> localVector, int optiune, LocalDate final1);

    void afisare_absente(Vector<Materie> localVector, int materie);

    int returnPozitieNota(Vector<Materie> local, int materie, int nota, LocalDate data);

    void removeNotaByNota(Vector<Materie> local, int materie, int nota, LocalDate data);

    LocalDate existaAbsenta(Vector<Materie> local, int materie, LocalDate data);

    void removeAbsentaByData(Vector<Materie> local, int materie, LocalDate data);

    void seteazaProfesor(Profesor x, Vector<Materie> local, int materie);

    void afisareProfesori(Vector<Materie> local);

}
