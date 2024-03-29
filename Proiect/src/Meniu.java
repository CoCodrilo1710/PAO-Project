import Servicii.ServiciiGrupa;
import Servicii.ServiciiMaterii;
import Servicii.ServiciiStudent;
import entitati.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

public class Meniu {

    public void firstRead() {
        Scanner var = new Scanner(System.in);
        String key;
        System.out.println("--------- Introduceti datele despre grupa!----------");
        System.out.println();
        System.out.println();
        System.out.print("Numarul grupei este:  ");
        int key_int = var.nextInt();
        System.out.println();
        System.out.println();
        System.out.println("Dati detalii despre locatia unde o sa se sustina cursurile: ");
        System.out.println();

        String temp12 = var.nextLine();
        System.out.println("Introduceti un acronim pentru locatie: ");
        String acronim = "";
        acronim+=var.nextLine();
        System.out.println("Introduceti adresa efectiva( strada, numar, bloc, etaj");
        String adresa = "";
        adresa+=var.nextLine();
        System.out.println("Introduceti orasul: ");
        String oras = "";
        oras+=var.nextLine();
        System.out.println("Introduceti judetul: ");
        String judet = var.next();
        System.out.println("Introduceti tara: ");
        String tara = var.next();


        Locatie locatie = new Locatie(acronim, adresa, oras, judet, tara);
        Grupa grupa = new Grupa(key_int, locatie);

        System.out.println();
        System.out.println();
        System.out.println("Urmeaza sa cititi studentii componenti ai acestei grupe.");
        System.out.println();
        System.out.println("Cati studenti doriti sa adaugati ?");
        int ii = var.nextInt();
        if (ii <= 0) {
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
            Vector<Materie> localVector = new Vector<>();

            System.out.println();
            System.out.println();
            System.out.println("Specificati numarul de note pe care doriti sa-l adaugati: \n(O sa alegeti pentru fiecare nota in parte la ce materie sa o adaugati)");
            int nrnoteLocal = var.nextInt();

            ServiciiMaterii maintainLocalMaterii = new ServiciiMaterii();
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
            int nrabsenteLocal = var.nextInt();
            System.out.println();

            System.out.println();
            if (nrabsenteLocal == 0)
                System.out.println("Nu ati introdus nicio absenta!");
            else
                System.out.println("Absentele trebuiesc introduse sub forma zz.dd ! Dupa fiecare absenta apsati tasta ENTER");

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
            grupa.Adauga_Student(local);

        }
        System.out.println();
        System.out.println();
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

    public void Meniu1(Grupa grupaPrincipala) {

        ServiciiGrupa serviciiGrupa = new ServiciiGrupa();
        serviciiGrupa.setareMedieGrupa(grupaPrincipala);
        serviciiGrupa.setareRestantaGrupa(grupaPrincipala);
        serviciiGrupa.setareMedieMateriiGrupa(grupaPrincipala);

        System.out.println("""
                    
                1) Afisati intreaga grupa
                2) Afisati detaliile despre un anumit student

                3) Adaugati note unui anumit student
                4) Stergeti note unui anumit student

                5) Adaugati absente unui anumit student
                6) Stergeti absente unui anumit student

                7) Afisati detalii despre restantele unui anumit student
                8) Afisati numarul de restantieri ale grupei

                9) Adaugati/Modificati un profesor
                10) Stergeti un profesor

                11) Afisati profesorii materiilor
                                
                12) Afisati intreaga grupa in ordinea mediei
                
                13) Adaugati un student nou
                14) Stergeti un student
                
                15) Modificati locatia grupei ( In urma unei relocari )

                16) Cititi alta grupa
                17) Iesiti din program
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
        ServiciiGrupa serviciiGrupa1 = new ServiciiGrupa();
        ServiciiMaterii serviciiMaterii = new ServiciiMaterii();
        ServiciiStudent serviciiStudent = new ServiciiStudent();
        switch (raspuns) {
            case 1 -> {
                System.out.println("Ati ales sa afisati intreaga grupa!");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                serviciiGrupa1.afisareGrupa(grupaPrincipala);
                System.out.println();
                System.out.println();
                System.out.println("Afisarea s-a terminat! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 2 -> {
                System.out.println("Ati ales sa afisati detaliile despre un anumit student!");
                System.out.println("Introduceti numele studentului: ");
                String nume = var.next();
                System.out.println("Introduceti prenumele studentului: ");
                String prenume = var.next();
                System.out.println();

                if (serviciiGrupa1.exitaStudent(grupaPrincipala, nume, prenume)) {
                    Student ty = serviciiGrupa1.getStudentByName(grupaPrincipala, nume, prenume);
                    serviciiStudent.afisareStudent(ty);
                    System.out.println();
                    System.out.println();
                    System.out.println("Afisarea s-a terminat! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }

                    Meniu1(grupaPrincipala);

                } else {
                    System.out.println("Nu exista niciun student cu numele si prenumele introduse!");
                    System.out.println();
                    System.out.println();
                    System.out.println("Reincercati! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                    Meniu1(grupaPrincipala);
                }
            }

            case 3 -> {
                System.out.println("Ati ales sa adaugati note unui anumit student!");
                System.out.println("Introduceti numele studentului: ");
                String nume = var.next();
                System.out.println("Introduceti prenumele studentului: ");
                String prenume = var.next();
                System.out.println();

                if (serviciiGrupa1.exitaStudent(grupaPrincipala, nume, prenume)) {

                    Student ty = serviciiGrupa1.getStudentByName(grupaPrincipala, nume, prenume);

                    System.out.println("Cate note doriti sa adaugati? ");
                    int numar_note = var.nextInt();
                    for (int ii = 0; ii < numar_note; ii++) {

                        serviciiMaterii.afisareMaterii();
                        System.out.println("Introduceti numarul materiei pentru nota pe care doriti sa o adaugati: ");
                        int numar_materie = var.nextInt();
                        System.out.println("Introduceti nota: ");
                        int nota = var.nextInt();
                        System.out.println("Introduceti data: (sub FormaNota zz.ll");
                        String data = var.next();

                        data = data + ".2022";
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                        LocalDate final1 = LocalDate.parse(data, formatter);

                        serviciiStudent.adaugaNota(ty, numar_materie, nota, final1);
                        System.out.println();
                        System.out.println();
                    }
                    if (numar_note > 0)
                        System.out.println("Adaugarea a fost efectuata! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    else
                        System.out.println("Nu ati introdus nicio nota! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");

                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                    Meniu1(grupaPrincipala);
                } else {
                    System.out.println("Nu exista niciun student cu numele si prenumele introduse!");
                    System.out.println();
                    System.out.println();
                    System.out.println("Reincercati! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                    Meniu1(grupaPrincipala);
                }
            }

            case 4 -> {
                System.out.println("Ati ales sa stergeti note unui anumit student!");
                System.out.println("Introduceti numele studentului: ");
                String nume = var.next();
                System.out.println("Introduceti prenumele studentului: ");
                String prenume = var.next();
                System.out.println();
                int ok = 0;
                if (serviciiGrupa1.exitaStudent(grupaPrincipala, nume, prenume)) {

                    Student ty = serviciiGrupa1.getStudentByName(grupaPrincipala, nume, prenume);

                    System.out.println("Cate note doriti sa stergeti? ");
                    int numar_note = var.nextInt();
                    for (int ii = 0; ii < numar_note; ii++) {

                        serviciiMaterii.afisareMaterii();
                        System.out.println("Introduceti numarul materiei pentru nota pe care doriti sa o stergeti: ");
                        int numarMaterie = var.nextInt();
                        System.out.println("Introduceti nota: ");
                        int nota = var.nextInt();
                        System.out.println("Introduceti data: (sub FormaNota zz.ll");
                        String data = var.next();

                        data = data + ".2022";
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                        LocalDate final1 = LocalDate.parse(data, formatter);

                        if (serviciiMaterii.returnPozitieNota(ty.getSituatie(), numarMaterie, nota, final1) == -1)
                            System.out.println("Nota nu a fost gasita!");
                        else {
                            serviciiStudent.stergeNota(ty, numarMaterie, nota, final1);
                            ok = 1;
                        }

                        System.out.println();
                        System.out.println();
                    }
                    if (numar_note > 0 && ok == 1)
                        System.out.println("Stergerea a fost efectuata pe notele gasite! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    else
                        System.out.println("Nu ati introdus nicio nota! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");

                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }

                    Meniu1(grupaPrincipala);
                } else {
                    System.out.println("Nu exista niciun student cu numele si prenumele introduse!");
                    System.out.println();
                    System.out.println();
                    System.out.println("Reincercati! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                }
            }

            case 5 -> {
                System.out.println("Ati ales sa adaugati absente unui anumit student!");
                System.out.println("Introduceti numele studentului: ");
                String nume = var.next();
                System.out.println("Introduceti prenumele studentului: ");
                String prenume = var.next();
                System.out.println();
                if (serviciiGrupa1.exitaStudent(grupaPrincipala, nume, prenume)) {

                    Student ty = serviciiGrupa1.getStudentByName(grupaPrincipala, nume, prenume);

                    System.out.println("Cate absente doriti sa adaugati? ");
                    int numar_absente = var.nextInt();
                    for (int ii = 0; ii < numar_absente; ii++) {

                        serviciiMaterii.afisareMaterii();
                        System.out.println("Introduceti numarul materiei pentru absenta pe care doriti sa o adaugati: ");
                        int numarMaterie = var.nextInt();
                        System.out.println("Introduceti data: (sub FormaNota zz.ll");
                        String data = var.next();

                        data = data + ".2022";
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                        LocalDate final1 = LocalDate.parse(data, formatter);

                        serviciiMaterii.addAbsenta(ty.getSituatie(), numarMaterie, final1);
                        System.out.println();
                        System.out.println();
                    }
                    if (numar_absente > 0)
                        System.out.println("Adaugarea a fost efectuata! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    else
                        System.out.println("Nu ati introdus nicio absenta! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");

                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                    Meniu1(grupaPrincipala);
                } else {
                    System.out.println("Nu exista niciun student cu numele si prenumele introduse!");
                    System.out.println();
                    System.out.println();
                    System.out.println("Reincercati! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                }
            }

            case 6 -> {

                System.out.println("Ati ales sa stergeti absente unui anumit student!");
                System.out.println();
                System.out.println("Introduceti numele studentului: ");
                String nume = var.next();
                System.out.println("Introduceti prenumele studentului: ");
                String prenume = var.next();
                System.out.println();
                int ok = 0;
                if (serviciiGrupa1.exitaStudent(grupaPrincipala, nume, prenume)) {

                    Student ty = serviciiGrupa1.getStudentByName(grupaPrincipala, nume, prenume);

                    System.out.println("Cate absente doriti sa stergeti? ");
                    int numarAbsente = var.nextInt();
                    for (int ii = 0; ii < numarAbsente; ii++) {

                        serviciiMaterii.afisareMaterii();
                        System.out.println("Introduceti numarul materiei pentru absenta pe care doriti sa o stergeti: ");
                        int numarMaterie = var.nextInt();
                        System.out.println("Introduceti data: (sub FormaNota zz.ll");
                        String data = var.next();

                        data = data + ".2022";
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                        LocalDate final1 = LocalDate.parse(data, formatter);

                        if (serviciiMaterii.existaAbsenta(ty.getSituatie(), numarMaterie, final1) == null)
                            System.out.println("Absenta nu a fost gasita!");
                        else {
                            serviciiMaterii.removeAbsentaByData(ty.getSituatie(), numarMaterie, final1);
                            ok = 1;
                        }
                        System.out.println();
                        System.out.println();
                    }
                    if (numarAbsente > 0 && ok == 1)
                        System.out.println("Stergerea a fost efectuata pe absentele gasite! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    else
                        System.out.println("Nu ati introdus nicio absenta! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");

                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                    Meniu1(grupaPrincipala);
                } else {
                    System.out.println("Nu exista niciun student cu numele si prenumele introduse!");
                    System.out.println();
                    System.out.println();
                    System.out.println("Reincercati! \nLa apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                }
            }

            case 7 -> {
                System.out.println("Ati ales sa aflati detalii despre restantele unui student!");
                System.out.println();
                System.out.println("Introduceti numele studentului: ");
                String nume = var.next();
                System.out.println("Introduceti prenumele studentului: ");
                String prenume = var.next();
                System.out.println();
                Student x = null;

                if (serviciiGrupa1.exitaStudent(grupaPrincipala, nume, prenume)) {
                    x = serviciiGrupa1.getStudentByName(grupaPrincipala, nume, prenume);
                }

                if (x != null) {
                    System.out.println("Studentul " + x.getNume() + " " + x.getPrenume() + " are restante la urmatoarele materii: ");
                    int numar = 0;
                    for (Materie mat : x.getSituatie()) {
                        if (mat.getRestanta()) {
                            System.out.println(mat.getNumeMaterie().toString());
                            numar++;
                            System.out.println();
                            System.out.println("Media la aceasta materie este: " + mat.getMedie());
                            System.out.println();
                        }
                    }
                    System.out.println();
                    if (numar == 0)
                        System.out.println("Nu are restante!");
                    else {
                        System.out.println();
                        System.out.println("Deci, are " + numar + " restante!");
                    }
                } else {
                    System.out.println("Nu exista niciun student cu numele si prenumele introduse!");
                    System.out.print("Reincercati! ");
                }

                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 8 -> {
                System.out.println("Ati ales sa aflati numarul de restantieri din intreaga grupa!");
                System.out.println();
                System.out.println("Numarul de restantieri din intreaga grupa este: " + serviciiGrupa1.returnNrRestanti(grupaPrincipala));
                System.out.println();
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 9 -> {
                System.out.println("Ati ales sa adaugati un profesor la o materie!");
                System.out.println();
                System.out.println("Alegeti materia: ");
                serviciiMaterii.afisareMaterii();
                int numarMaterie = var.nextInt();
                if (numarMaterie < 0 || numarMaterie > 6) {
                    System.out.println("Optiune invalida!");
                    System.out.println();
                    System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                    Meniu1(grupaPrincipala);
                } else {
                    System.out.println("Introduceti numele profesorului: ");
                    String nume = var.next();
                    System.out.println("Introduceti prenumele profesorului: ");
                    String prenume = var.next();
                    System.out.println("Introduceti CNP-ul profesorului: ");
                    String cnp = var.next();
                    System.out.println("Introduceti email-ul profesorului: ");
                    String email = var.next();
                    System.out.println("Introduceti salariul profesorului: ");
                    int salariu = var.nextInt();
                    System.out.println("Introduceti rank-ul profesorului: ");
                    String rank = var.next();
                    Profesor x = new Profesor(cnp, prenume, nume, email, rank, salariu);
                    serviciiGrupa1.setareProfesorMass(grupaPrincipala, x, numarMaterie);
                }
                System.out.println();
                System.out.println("Modificarea a fost facuta cu succes!");
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 10 -> {
                System.out.println("Ati ales sa stergeti un profesor de la o materie!");
                System.out.println();
                System.out.println("Alegeti materia: ");
                serviciiMaterii.afisareMaterii();
                int numarMaterie = var.nextInt();
                if (numarMaterie < 0 || numarMaterie > 6) {
                    System.out.println("Optiune invalida!");
                    System.out.println();
                    System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                    String temp1 = var.nextLine();
                    String key = var.nextLine();
                    if (key.equals("")) {
                        for (int iii = 0; iii < numRowsInConsole; iii++) {
                            System.out.println();
                        }
                    }
                    Meniu1(grupaPrincipala);
                } else {
                    serviciiGrupa1.stergereProfesorMass(grupaPrincipala, numarMaterie);
                }
                System.out.println();
                System.out.println("Modificarea a fost facuta cu succes!");
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 11 -> {
                serviciiMaterii.afisareProfesori(grupaPrincipala.getStudenti().first().getSituatie());
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 12 -> {

                System.out.println("Grupa ordonata dupa medie: ");
                System.out.println();
                serviciiGrupa1.afisareGrupa(serviciiGrupa1.returnGrupaOrdonataByMedie(grupaPrincipala));

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 13 -> {
                System.out.println("Ati ales sa adaugati un student!");
                serviciiGrupa.adaugareStudent(grupaPrincipala, serviciiStudent.returnStudent());

                System.out.println();
                System.out.println("Inserare efectuata cu succes!");
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }

            case 14 ->{

                System.out.println("Ati ales sa stergeti un student!");
                System.out.println("Introduceti CNP-ul studentului: ");
                String cnp = var.next();
                if (serviciiGrupa1.exitaStudent(grupaPrincipala,cnp))
                {
                    Student x = serviciiGrupa1.getStudentByCNP(grupaPrincipala,cnp);
                    serviciiGrupa1.stergereStudent(grupaPrincipala,x);
                }
                else
                {
                    System.out.println("Studentul nu exista!");
                }
                System.out.println();
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }

                Meniu1(grupaPrincipala);
            }


            case 15 -> {
                System.out.println("Ati ales sa modificati locatia grupei! ( In urma unei relocari! )");
                System.out.println();
                System.out.println("Introduceti noua locatie: ");
                System.out.println();
                System.out.println("Introduceti un acronim pentru locatie: ");
                String acronim = var.next();
                System.out.println("Introduceti adresa efectiva( strada, numar, bloc, etaj");
                String adresa = var.next();
                System.out.println("Introduceti orasul: ");
                String oras = var.next();
                System.out.println("Introduceti judetul: ");
                String judet = var.next();
                System.out.println("Introduceti tara: ");
                String tara = var.next();

                Locatie locatie = new Locatie(acronim, adresa, oras, judet, tara);
                grupaPrincipala.setLocatie(locatie);
                System.out.println("Modificarea a fost facuta cu succes!");
                System.out.println();
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }

                Meniu1(grupaPrincipala);
            }

            case 16 -> firstRead();

            case 17 -> {
                System.out.println("Multumim pentru utilizarea aplicatiei!");
                System.exit(0);
            }

            default -> {
                System.out.println("Optiune invalida!");
                System.out.println();
                System.out.println("La apasarea tastei ENTER va va trimite in meniul aplicatiei!");
                String temp1 = var.nextLine();
                String key = var.nextLine();
                if (key.equals("")) {
                    for (int iii = 0; iii < numRowsInConsole; iii++) {
                        System.out.println();
                    }
                }
                Meniu1(grupaPrincipala);
            }
        }
    }
}
