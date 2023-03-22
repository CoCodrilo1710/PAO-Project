
import Servicii.serviciiGrupa;
import Servicii.serviciiMaterii;
import Servicii.serviciiStudent;
import entitati.Grupa;
import entitati.Materie;
import entitati.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Meniu {
    // private Grupa grupa;

    public void firstRead() {
        Scanner var = new Scanner(System.in);
        System.out.println("   ------------- DISCLAIMER ------------     ");
        System.out.println();
        System.out.println("Se recomanda largirea terminalului pentru a intra un rand complet pe latimea acestuia!");
        System.out.println("");
        System.out.println("Aceasta aplicatie simuleaza un catalog online construit pe planul unui grupe studentesti cu un numar dat de studenti!");
        System.out.println("");
        System.out.println("-------Aplicatia are aplicabilitate in cadrul secretariatului in activitati precum alocarea locurilor la caminele UNIBUC ------");
        System.out.println("");
        System.out.println("  Precizari despre folosirea aplicatiei:");
        System.out.println("- Daca un student este RESTANT, NU i se vor mai afisa notele");
        System.out.println("- Notele, respectiv absentele trebuiesc adaugate una cate una");
        System.out.println("- Acelasi aspect se foloseste si la stergerea lor");
        System.out.println("");
        System.out.println("");
        System.out.println("-------Rugam citirea cu atentie a instructiunilor date pe ecran!----------");
        System.out.println("");
        System.out.println("");
        System.out.println("Daca ati citit acest mesaj, puteti trece mai departe!");
        System.out.println("Pentru acest lucru, apasati tasta ENTER!");

        String key = " ";
        key = var.nextLine();
        if (key.equals("")) {
            int numRowsInConsole = 60;
            for (int ii = 0; ii < numRowsInConsole; ii++) {
                System.out.println();
            }
        }

        System.out.println("--------- Introduceti datele despre grupa!----------");
        System.out.println();
        System.out.println();

        System.out.print("Numarul grupei este:  ");
        int key_int = var.nextInt();
        System.out.println();
        Grupa grupa = new Grupa(key_int);

        System.out.println();
        System.out.println();
        System.out.println("Urmeaza sa cititi studentii componenti ai acestei grupe.");
        System.out.println();
        System.out.println("Cati studenti doriti sa adaugati ?");
        int ii = var.nextInt();
        if (ii<=0) {
            System.out.println("Nu ati introdus un numar valid de studenti!");
            System.out.println("Reincercati prin apasarea tastei ENTER!");
            String temp = var.nextLine();
            key = var.nextLine();
            if (key.equals("")) {
                int numRowsInConsole = 60;
                for (int iii = 0; iii < numRowsInConsole; iii++) {
                    System.out.println();
                }
            }
            firstRead();
        }
        for (int i = 0; i < ii; i++) {
            System.out.println();
            System.out.println("Introduceti datele studentului #" + i + ": ");
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

            Vector<Materie> local_vector = new Vector<Materie>();

            System.out.println();
            System.out.println();

            System.out.println("Specificati numarul de note pe care doriti sa-l adaugati: \n(O sa alegeti pentru fiecare nota in parte la ce materie sa o adaugati)");
            int nrnote_local = var.nextInt();

            serviciiMaterii maintain_local_materii = new serviciiMaterii();

            maintain_local_materii.setter_materi(local_vector);
            System.out.println();
            System.out.println();

            System.out.println("Notele trebuie introduse sub forma: nota ( urmata de tasta ENTER), iar mai apoi data(sub forma: zz.ll)");
            System.out.println();

            for (int i2 = 0; i2 < nrnote_local; i2++) {
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
                maintain_local_materii.afisare_materii();
                int optiune = var.nextInt();

                maintain_local_materii.add_nota(local_vector, optiune, nota, final1);

                System.out.println();
                System.out.println("Ati adaugat cu succes nota " + nota + "/" + backData + " la materia ------ " + maintain_local_materii.nume_materie(local_vector, optiune) + " ------");

                System.out.println();
                System.out.println();
                System.out.println();


            }

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

            //      System.out.println(maintain_local_materii.return_nota(local_vector,4,0));   // printare nota


            System.out.println("Specificati numarul de ABSENTE pe care doriti sa-l adaugati: \n(O sa alegeti pentru fiecare ABSENTA in parte la ce materie sa o adaugati)");
            int nrabsente_local = var.nextInt();
            System.out.println();
            System.out.println("Absentele trebuiesc introduse sub forma zz.dd ! Dupa fiecare absenta apsati tasta ENTER");
            if (nrabsente_local == 0) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Ati citit toate detaliile necesare! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                key = var.nextLine();
                if (key.equals("")) {
                    int numRowsInConsole = 60;
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                local.setSituatie(local_vector);
                grupa.getStudenti().add(local);

                Meniu1(grupa);

            }

            for (int i3=0;i3<nrabsente_local;i3++) {

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
                maintain_local_materii.afisare_materii();
                int optiune = var.nextInt();

                maintain_local_materii.add_absenta(local_vector, optiune, final1);

                System.out.println();
                System.out.println("Ati adaugat cu succes ABSENTA " + backData + " la materia ------ " + maintain_local_materii.nume_materie(local_vector, optiune) + " ------");

                System.out.println();
                System.out.println();
                System.out.println();
            }


                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();

                local.setSituatie(local_vector);
                grupa.getStudenti().add(local);

            }
        System.out.println();
        System.out.println();

        serviciiMaterii maintain_local_materii = new serviciiMaterii();

        List<Student> listStudenti = new ArrayList<Student>( grupa.getStudenti() );
        // maintain_local_materii.afisare_absente(listStudenti.get(0).getSituatie(),3);  /// pentru studentul 0, materia 3

        System.out.println("Ati citit toate detaliile necesare! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
        String temp1 = var.nextLine();
        key = var.nextLine();
        if (key.equals("")) {
            int numRowsInConsole = 60;
            for (int iii = 0; iii < numRowsInConsole; iii++) {
                System.out.println();
            }
        }

        Meniu1(grupa);
    }


    public void Meniu1(Grupa grupa_principala) {

        System.out.println("""
    
    1) Afisati intreaga grupa
    2) Afisati detaliile despre un anumit student

    3) Adaugati note unui anumit student
    4) Stergeti note unui anumit student

    5) Adaugati absente unui anumit student
    6) Stergeti absente unui anumit student

    7) Afisati detalii despre restantele unui anumit student
    8) Afisati numarul de restantieri ale grupei

    9) Adaugati un profesor
    10) Stergeti un profesor


    11) Cititi alta grupa
    12) Iesiti din program
    """);

        Scanner var = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("Introduceti numarul optinuii pe care doriti sa o executati, DOAR NUMARUL, dupa care apasati tasta ENTER!");

        int raspuns = var.nextInt();
        int numRowsInConsole = 60;
        for (int iii = 0; iii < numRowsInConsole; iii++) {
                System.out.println();
            }

        serviciiGrupa servicii_grupa = new serviciiGrupa();
        serviciiMaterii servicii_materii = new serviciiMaterii();
        serviciiStudent servicii_student = new serviciiStudent();
        switch (raspuns) {
            case 1 -> {
                System.out.println("Ati ales sa afisati intreaga grupa!");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                servicii_grupa.afisareGrupa(grupa_principala);
            }





        }

    }

}