package Servicii;

import Servicii.Interfete.StudentInterfata;
import entitati.Materie;
import entitati.Student;

import java.time.LocalDate;

public class ServiciiStudent implements StudentInterfata {

    @Override
    public void setMedieStudent(Student x) {
        ServiciiMaterii mainMaterii = new ServiciiMaterii();
        int suma = 0;
        double medieTotala = 0.0, medieMaterie = 0.0;
        for (Materie y : x.getSituatie()) {
            suma = 0;
            medieMaterie = 0.0;
            for (int i = 0; i < y.getNote().size(); i++) {
                suma += mainMaterii.return_nota(x.getSituatie(), x.getSituatie().indexOf(y), i);
            }
            if (suma == 0) {
                medieMaterie = 0.0;
            } else {
                medieMaterie = (double) suma / y.getNote().size();
            }
            medieTotala += medieMaterie;
        }
        medieTotala = medieTotala / 6.0;

        x.setMedie(medieTotala);
    }

    @Override
    public void setMediePerMaterie(Student x, Materie y) {
        ServiciiMaterii mainMaterii = new ServiciiMaterii();
        int suma = 0;
        double medieTotala = 0.0, medieMaterie = 0.0;
        suma = 0;
        medieMaterie = 0.0;
        for (int i = 0; i < y.getNote().size(); i++) {
            suma += mainMaterii.return_nota(x.getSituatie(), x.getSituatie().indexOf(y), i);
        }
        if (suma == 0) {
            medieMaterie = 0.0;
        } else {
            medieMaterie = (double) suma / y.getNote().size();
        }
        x.getSituatie().get(x.getSituatie().indexOf(y)).setMedie(medieMaterie);
    }

    @Override
    public void setRestantaMaterii(Student x) {
        ServiciiMaterii mainMaterii = new ServiciiMaterii();
        for (Materie y : x.getSituatie()) {
            x.getSituatie().get(x.getSituatie().indexOf(y)).setRestanta(x.getSituatie().get(x.getSituatie().indexOf(y)).getMedie() < 5.0);
        }
    }

    @Override
    public void afisareStudent(Student x) {
        System.out.println("Numele este: " + x.getNume());
        System.out.println("Prenumele este: " + x.getPrenume());
        System.out.println("CNP-ul este: " + x.getCnp());
        System.out.println("Varsta este: " + x.getAge());
        System.out.println("Media este: " + x.getMedie());
        System.out.println();
        System.out.println();

        System.out.println("Notele/Absentele sale sunt urmatoarele: ");
        System.out.println();
        for (Materie mat : x.getSituatie()) {

            System.out.println("Materia: --- " + mat.getNumeMaterie() + " ---");
            System.out.println("Note: ");
            for (Materie.forma forma : mat.getNote()) {
                System.out.println("Nota: " + mat.getter_nota(forma) + " ,    Data: " + mat.getter_data(forma).getDayOfMonth() + "." + mat.getter_data(forma).getMonthValue());
                System.out.println();
            }
            System.out.println();
            System.out.println("Absente: ");
            for (LocalDate data : mat.getAbsente()) {
                System.out.println(data.getDayOfMonth() + "." + data.getMonthValue());
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    @Override
    public void adaugaNota(Student x, int y, int nota, LocalDate data) {
        ServiciiMaterii mainMaterii = new ServiciiMaterii();
        mainMaterii.add_nota(x.getSituatie(), y, nota, data);
    }

    @Override
    public void stergeNota(Student x, int y, int nota, LocalDate data) {
        ServiciiMaterii mainMaterii = new ServiciiMaterii();
        mainMaterii.removeNotaByNota(x.getSituatie(), y, nota, data);
    }

    public Student returnStudent(Student x) {
        return x;
    }
}
