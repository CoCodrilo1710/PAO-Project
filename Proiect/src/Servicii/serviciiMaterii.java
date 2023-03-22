package Servicii;

import entitati.allMaterii;
import entitati.Materie;

import java.time.LocalDate;
import java.util.Vector;

public class serviciiMaterii {

    public void setter_materi(Vector<Materie> local_vector) {
        int i = 0;
        for (allMaterii materie : allMaterii.values()) {
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

    public void afisare_materii() {
        int i = 0;
        for (allMaterii materie : allMaterii.values()) {
            System.out.println((i++) + ". " + materie.toString());
        }
    }

    public void add_nota(Vector<Materie> local, int materie, int nota, LocalDate data) {
        local.get(materie).getNote().add(local.get(materie).get_forma(nota, data));
    }

    public int return_nota(Vector<Materie> local, int materie, int pozitie) {
        return local.get(materie).getter_nota(local.get(materie).getNote().get(pozitie));
    }

    public LocalDate return_data(Vector<Materie> local, int materie, int pozitie) {
        return local.get(materie).getter_data(local.get(materie).getNote().get(pozitie));
    }

    public String nume_materie(Vector<Materie> local, int materie) {
        return local.get(materie).getNumeMaterie().toString();
    }

    public void add_absenta(Vector<Materie> localVector, int optiune, LocalDate final1) {
        localVector.get(optiune).getAbsente().add(final1);
    }

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
}

