package Servicii;

import Servicii.Interfete.MateriiInterfata;
import entitati.Materie;
import entitati.Profesor;
import entitati.AllMaterii;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class ServiciiMaterii implements MateriiInterfata {

    @Override
    public void setterMateri(Vector<Materie> local_vector) {
        int i = 0;
        for (AllMaterii materie : AllMaterii.values()) {
            Materie local = new Materie();
            local.setNumeMaterie(materie);
            switch (materie) {
                case FLP -> local.setCredite(5);
                case MDS -> local.setCredite(4);
                case INTELIGENTA_ARTIFICIALA -> local.setCredite(3);
                case PAO -> local.setCredite(5);
                case ENGLEZA -> local.setCredite(2);
                case ALGORITMI_AVANSATI -> local.setCredite(4);
            }
            local_vector.add(local);
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
    public void add_nota(Vector<Materie> local, int materie, int nota, LocalDate data) {
        local.get(materie).getNote().add(local.get(materie).get_forma(nota, data));
    }

    @Override
    public int return_nota(Vector<Materie> local, int materie, int pozitie) {
        return local.get(materie).getter_nota(local.get(materie).getNote().get(pozitie));
    }

    @Override
    public LocalDate return_data(Vector<Materie> local, int materie, int pozitie) {
        return local.get(materie).getter_data(local.get(materie).getNote().get(pozitie));
    }

    @Override
    public String numeMaterie(Vector<Materie> local, int materie) {
        return local.get(materie).getNumeMaterie().toString();
    }

    @Override
    public void addAbsenta(Vector<Materie> localVector, int optiune, LocalDate final1) {
        localVector.get(optiune).getAbsente().add(final1);
    }

    @Override
    public void afisare_absente(Vector<Materie> localVector, int materie) {
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
    public int returnPozitieNota(Vector<Materie> local, int materie, int nota, LocalDate data) {
        int i = 0;
        if (local.get(materie).getNote().size() == 0)
            return -1;
        for (i = 0; i <= local.get(materie).getNote().size(); i++) {
            if (local.get(materie).getter_nota(local.get(materie).getNote().get(i)) == nota && local.get(materie).getter_data(local.get(materie).getNote().get(i)).equals(data))
                return i;
        }
        return -1;
    }

    @Override
    public void removeNotaByNota(Vector<Materie> local, int materie, int nota, LocalDate data) {
        local.get(materie).getNote().remove(returnPozitieNota(local, materie, nota, data));
    }

    @Override
    public int returnPozitieAbsenta(Vector<Materie> local, int materie, LocalDate data) {
        int i = 0;
        if (local.get(materie).getAbsente().size() == 0)
            return -1;

        for (i = 0; i <= local.get(materie).getAbsente().size(); i++) {

            ArrayList<LocalDate> listaAbsente = new ArrayList<LocalDate>(local.get(materie).getAbsente());
            if (listaAbsente.get(i).equals(data))
                return i;
        }
        return -1;
    }

    @Override
    public void removeAbsentaByData(Vector<Materie> local, int materie, LocalDate data) {
        local.get(materie).getAbsente().remove(returnPozitieAbsenta(local, materie, data));
    }

    @Override
    public void seteazaProfesor(Profesor x, Vector<Materie> local, int materie) {
        local.get(materie).setProfesor(x);
    }

    @Override
    public void afisareProfesori(Vector<Materie> local) {
        ServiciiProfesori serviciiProfesori = new ServiciiProfesori();
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

