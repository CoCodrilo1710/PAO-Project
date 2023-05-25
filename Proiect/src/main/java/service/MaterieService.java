package service;

import model.Materie;
import model.abstractsSealed.Profesor;

import java.time.LocalDate;
import java.util.ArrayList;

public interface MaterieService {
    void setterMateri(ArrayList<Materie> localVector);

    void afisareMaterii();

    void add_nota(ArrayList<Materie> local, int materie, int nota, LocalDate data);

    int return_nota(ArrayList<Materie> local, int materie, int pozitie);

    LocalDate return_data(ArrayList<Materie> local, int materie, int pozitie);

    String numeMaterie(ArrayList<Materie> local, int materie);

    void addAbsenta(ArrayList<Materie> localVector, int optiune, LocalDate final1);

    void afisare_absente(ArrayList<Materie> localVector, int materie);

    int returnPozitieNota(ArrayList<Materie> local, int materie, int nota, LocalDate data);

    void removeNotaByNota(ArrayList<Materie> local, int materie, int nota, LocalDate data);

    LocalDate existaAbsenta(ArrayList<Materie> local, int materie, LocalDate data);

    void removeAbsentaByData(ArrayList<Materie> local, int materie, LocalDate data);

    void seteazaProfesor(Profesor x, ArrayList<Materie> local, int materie);

    void afisareProfesori(ArrayList<Materie> local);

}
