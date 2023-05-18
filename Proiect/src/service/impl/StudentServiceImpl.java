package service.impl;

import service.StudentService;
import model.Materie;
import model.Student;
import model.FormaNota;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {

    @Override
    public void setMedieStudent(Student x){
        x.setMedie(x.getMedieCalculator().calculeazaMedie(x));
    }

    @Override
    public void setMediePerMaterie(Student x, Materie y) {
        MaterieServiceImpl mainMaterii = new MaterieServiceImpl();
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
        MaterieServiceImpl mainMaterii = new MaterieServiceImpl();
        for (Materie y : x.getSituatie()) {
            if (x.getSituatie().get(x.getSituatie().indexOf(y)).getMedie() < 5.0) {
                x.getSituatie().get(x.getSituatie().indexOf(y)).setRestanta(true);
            } else {
                x.getSituatie().get(x.getSituatie().indexOf(y)).setRestanta(false);
            }
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
            for (FormaNota FormaNota : mat.getNote()) {
                System.out.println("Nota: " + mat.getterNota(FormaNota) + " ,    Data: " + mat.getterData(FormaNota).getDayOfMonth() + "." + mat.getterData(FormaNota).getMonthValue());
                System.out.println();
            }
            System.out.println("Media la aceasta materie este: " + mat.getMedie());
            System.out.println();
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
        MaterieServiceImpl mainMaterii = new MaterieServiceImpl();
        mainMaterii.add_nota(x.getSituatie(), y, nota, data);
    }

    @Override
    public void stergeNota(Student x, int y, int nota, LocalDate data) {
        MaterieServiceImpl mainMaterii = new MaterieServiceImpl();
        mainMaterii.removeNotaByNota(x.getSituatie(), y, nota, data);
    }

    @Override
    public Student returnStudent() {
        Scanner var = new Scanner(System.in);

        System.out.println();
        System.out.println("Introduceti datele studentului"+": ");
        System.out.println();
        System.out.println();
            System.out.println("Specificati numele studentului: ");
            String nume = var.next();
            System.out.println("Specificati prenumele studentului: ");
            String prenume = var.next();
            System.out.println("Specificati CNP-ul studentului: ");
            String cnp = var.next();
            System.out.println("Specificati varsta studentului: ");
            int varsta = var.nextInt();
            System.out.println("Specificati email-ul studentului: ");
            String email = var.next();
            System.out.println("Specificati numarul de telefon al studentului: ");
            String nrdetel = var.next();
            System.out.println("Specificati anul de studiu al studentului: ");
            int andestudiu = var.nextInt();
            System.out.println("Specificati semestrul curent al studentului: ");
            int semestru = var.nextInt();

            Student local = new Student(cnp, prenume, nume, varsta, email, nrdetel, andestudiu, semestru);
            ArrayList<Materie> localVector = new ArrayList<>();

            System.out.println();
            System.out.println();
            System.out.println("Specificati numarul de note pe care doriti sa-l adaugati: \n(O sa alegeti pentru fiecare nota in parte la ce materie sa o adaugati)");
            int nrnoteLocal = var.nextInt();

            MaterieServiceImpl maintainLocalMaterii = new MaterieServiceImpl();
            maintainLocalMaterii.setterMateri(localVector);
            System.out.println();
            System.out.println();

            if (nrnoteLocal <= 0) {
                System.out.println("Nu ati introdus nicio nota");
            } else
                System.out.println("Notele trebuie introduse sub FormaNota: nota ( urmata de tasta ENTER), iar mai apoi data(sub FormaNota: zz.ll)");
            System.out.println();

            for (int i2 = 0; i2 < nrnoteLocal; i2++) {
                System.out.println("Introduceti nota #" + i2 + ": ");
                int nota = var.nextInt();
                String data = var.next();

                LocalDate localDate = LocalDate.now();
                int year = localDate.getYear() - 1;
                if (data.substring(0, 2).contains("."))
                    data = "0" + data;
                String backData = data;
                data = data + "." + year;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                LocalDate final1 = LocalDate.parse(data, formatter);

                System.out.println("\n \nVa rugam alegeti materia la care doriti sa adaugati nota: \n Scrieti doar cifra corespunzatoare! \n");
                maintainLocalMaterii.afisareMaterii();
                int optiune = var.nextInt();

                maintainLocalMaterii.add_nota(localVector, optiune, nota, final1);

                System.out.println();
                System.out.println("Ati adaugat cu succes nota " + nota + "/" + backData + " la materia ------ " + maintainLocalMaterii.numeMaterie(localVector, optiune) + " ------");
                System.out.println();
                System.out.println();
                System.out.println();


            }
            String key;
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Apasati tasta ENTER pentru a adauga absentele, ecranul se va goli!");
            String temp = var.nextLine();
            key = var.nextLine();
            if (key.equals("")) {
                int numRowsInConsole = 60;
                for (int iii = 0; iii < numRowsInConsole; iii++) {
                    System.out.println();
                }
            }

            System.out.println("Specificati numarul de ABSENTE pe care doriti sa-l adaugati: \n(O sa alegeti pentru fiecare ABSENTA in parte la ce materie sa o adaugati)");
            int nrabsenteLocal = var.nextInt();
            System.out.println();

            System.out.println();
            if (nrabsenteLocal == 0)
                System.out.println("Nu ati introdus nicio absenta!");
            else
                System.out.println("Absentele trebuiesc introduse sub FormaNota zz.dd ! Dupa fiecare absenta apsati tasta ENTER");

            for (int i3 = 0; i3 < nrabsenteLocal; i3++) {

                System.out.println("Introduceti data absentei #" + i3 + ": ");
                String data = var.next();
                LocalDate localDate = LocalDate.now();
                int year = localDate.getYear() - 1;
                if (data.substring(0, 2).contains("."))
                    data = "0" + data;
                String backData = data;
                data = data + "." + year;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                LocalDate final1 = LocalDate.parse(data, formatter);

                System.out.println("\n \nVa rugam alegeti materia la care doriti sa adaugati ABSENTA: \n Scrieti doar cifra corespunzatoare! \n");
                maintainLocalMaterii.afisareMaterii();
                int optiune = var.nextInt();

                maintainLocalMaterii.addAbsenta(localVector, optiune, final1);

                System.out.println();
                System.out.println("Ati adaugat cu succes ABSENTA " + backData + " la materia ------ " + maintainLocalMaterii.numeMaterie(localVector, optiune) + " ------");

                System.out.println();
                System.out.println();
                System.out.println();
            }


            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            local.setSituatie(localVector);

        return local;
    }
}
