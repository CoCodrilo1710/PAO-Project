package service.impl;

import service.MaterieService;
import model.Materie;
import model.abstractsSealed.Profesor;
import model.enums.AllMaterii;

import java.time.LocalDate;
import java.util.ArrayList;

public class MaterieServiceImpl implements MaterieService {

    @Override
    public void setterMateri(ArrayList<Materie> localVector) {
        int i = 0;
        for (AllMaterii materie : AllMaterii.values()) {
            Materie local = new Materie();
            local.setNumeMaterie(materie);
            local.setId(i);
            switch (materie) {
                case PAO, FLP -> local.setCredite(5);
                case MDS, ALGORITMI_AVANSATI -> local.setCredite(4);
                case INTELIGENTA_ARTIFICIALA -> local.setCredite(3);
                case ENGLEZA -> local.setCredite(2);
            }
            i++;
            localVector.add(local);
        }
    }

    @Override
    public void afisareMaterii() {
        int i = 0;
        for (AllMaterii materie : AllMaterii.values()) {
            System.out.println((i++) + ". " + materie.toString());
        }
    }

    @Override
    public void add_nota(ArrayList<Materie> local, int materie, int nota, LocalDate data) {
        local.get(materie).getNote().add(local.get(materie).getForma(nota, data));
    }

    @Override
    public int return_nota(ArrayList<Materie> local, int materie, int pozitie) {
        return local.get(materie).getterNota(local.get(materie).getNote().get(pozitie));
    }

    @Override
    public LocalDate return_data(ArrayList<Materie> local, int materie, int pozitie) {
        return local.get(materie).getterData(local.get(materie).getNote().get(pozitie));
    }

    @Override
    public String numeMaterie(ArrayList<Materie> local, int materie) {
        return local.get(materie).getNumeMaterie().toString();
    }

    @Override
    public void addAbsenta(ArrayList<Materie> localVector, int optiune, LocalDate final1) {
        localVector.get(optiune).getAbsente().add(final1);
    }

    @Override
    public void afisare_absente(ArrayList<Materie> localVector, int materie) {
        for (LocalDate localDate : localVector.get(materie).getAbsente()) {
            if (localDate.getMonthValue() < 10)
                if (localDate.getDayOfMonth() < 10)
                    System.out.println("0" + localDate.getDayOfMonth() + ".0" + localDate.getMonthValue());
                else
                    System.out.println(localDate.getDayOfMonth() + ".0" + localDate.getMonthValue());
            else if (localDate.getDayOfMonth() < 10)
                System.out.println("0" + localDate.getDayOfMonth() + ".0" + localDate.getMonthValue());
            else
                System.out.println(localDate.getDayOfMonth() + ".0" + localDate.getMonthValue());
        }
    }

    @Override
    public int returnPozitieNota(ArrayList<Materie> local, int materie, int nota, LocalDate data) {
        int i = 0;
        if (local.get(materie).getNote().isEmpty())
            return -1;
        for (i = 0; i <= local.get(materie).getNote().size(); i++) {
            if (local.get(materie).getterNota(local.get(materie).getNote().get(i)) == nota && local.get(materie).getterData(local.get(materie).getNote().get(i)).equals(data))
                return i;
        }
        return -1;
    }

    @Override
    public void removeNotaByNota(ArrayList<Materie> local, int materie, int nota, LocalDate data) {
        local.get(materie).getNote().remove(returnPozitieNota(local, materie, nota, data));
    }

    @Override
    public LocalDate existaAbsenta(ArrayList<Materie> local, int materie, LocalDate data) {
        int i = 0;
        if (local.get(materie).getAbsente().isEmpty())
            return null;

        for (i = 0; i <= local.get(materie).getAbsente().size(); i++) {

            ArrayList<LocalDate> listaAbsente = new ArrayList<LocalDate>(local.get(materie).getAbsente());
            if (listaAbsente.get(i).equals(data))
                return listaAbsente.get(i);
        }
        return null;
    }


    @Override
    public void removeAbsentaByData(ArrayList<Materie> local, int materie, LocalDate data) {
        local.get(materie).getAbsente().remove(existaAbsenta(local, materie, data));
    }

    @Override
    public void seteazaProfesor(Profesor x, ArrayList<Materie> local, int materie) {
        local.get(materie).setProfesor(x);
    }

    @Override
    public void afisareProfesori(ArrayList<Materie> local) {
        ProfesorServiceImpl serviciiProfesori = new ProfesorServiceImpl();
        for (Materie materie : local) {
            if (materie.getProfesor() != null) {
                System.out.println("Profesorul pentru materia " + materie.getNumeMaterie() + " este:  \n");
                serviciiProfesori.afisareProfesor(materie.getProfesor());
            } else
                System.out.println("Nu exista profesor pentru materia " + materie.getNumeMaterie());
            System.out.println("----------------------------------------------------");
        }
    }


}

