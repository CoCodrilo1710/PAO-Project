package service.impl;

import exceptions.OutOfRangeInputException;
import service.MaterieService;
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

            }
            System.out.println();
            System.out.println();
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

        MaterieServiceImpl maintainLocalMaterii = new MaterieServiceImpl();
        ArrayList<Materie> localVector = new ArrayList<>();
        maintainLocalMaterii.setterMateri(localVector);
        local.setSituatie(localVector);

        return local;
    }

    @Override
    public Materie getMateriebyId(Student x, int id) {
        for (Materie materie : x.getSituatie()) {
            if (materie.getId() == id)
                return materie;
        }
        return null;
    }


}
