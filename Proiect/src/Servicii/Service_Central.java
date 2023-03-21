package Servicii;

import entitati.AllMaterii;
import entitati.Grupa;
import entitati.Materie;
import entitati.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

public class Service_Central {
   // private Grupa grupa;

    public Grupa first_read()
    {
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

        String key=" ";
        key = var.nextLine();
        if (key.equals(""))
        {
            int numRowsInConsole = 60;
            for (int ii=0; ii<numRowsInConsole; ii++) {
                System.out.println();
            }
        }

        System.out.println("--------- Introduceti datele despre grupa!----------");
        System.out.println();
        System.out.println();

        System.out.print("Numarul grupei este:  ");
        int key_int= var.nextInt();
        System.out.println();
        Grupa grupa = new Grupa(key_int);

        System.out.println();
        System.out.println();
        System.out.println("Urmeaza sa cititi studentii componenti ai acestei grupe.");
        System.out.println();
        System.out.println("Cati studenti doriti sa adaugati ?");
        int ii = var.nextInt();
        for (int i=0;i<ii;i++)
        {
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
            String nrdetel=var.next();
            System.out.println("Specificati anul de studiu al studentului: ");
            int andestudiu = var.nextInt();
            System.out.println("Specificati semestrul curent al studentului: ");
            int semestru = var.nextInt();

            Student local = new Student(cnp,prenume,nume,varsta,email,nrdetel,andestudiu,semestru);

            Vector<Materie> local_vector = new Vector<Materie>();

            System.out.println();
            System.out.println();

            System.out.println("Specificati numarul de note pe care doriti sa-l adaugati: (  \n O sa alegeti pentru fiecare nota in parte la ce materie sa o adaugati");
            int nrnote_local = var.nextInt();

            Servicii_Materii maintain_local_materii= new Servicii_Materii();

            maintain_local_materii.setter_materi(local_vector);
            System.out.println();
            System.out.println();

            System.out.println("Notele trebuie introduse sub forma: nota ( urmata de tasta ENTER), iar mai apoi data(sub forma: zz.ll");

            for (int i2=0;i2<nrnote_local;i2++)
            {
                int nota= var.nextInt();
                String data=var.next();
                String backData=data;
                LocalDate localDate=LocalDate.now();
                int year=localDate.getYear()-1;
                data=data+"."+year;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                LocalDate final1 = LocalDate.parse(data,formatter);

                System.out.println("\n \n Va rugam alegeti materia la care doriti sa adaugati nota: \n Scrieti doar cifra corespunzatoare! \n");
                maintain_local_materii.afisare_materii();
                int optiune = var.nextInt();

                maintain_local_materii.add_nota(local_vector,optiune,nota,final1);

                System.out.println("Ati adaugat cu succes nota "+ nota + "/" + backData + " la materia ------ " + local_vector.get(optiune).getNumeMaterie().toString() + " ------" );
            }


            System.out.println(maintain_local_materii.return_nota(local_vector,4,0));   ///printare nota

            System.out.println();

        }

        return grupa;
    }


    public void Meniu(Grupa grupa_principala)
    {
        System.out.println();
        System.out.println();
        System.out.println("--------  Apasati tasta ENTER pentru a intra in meniu!  ----------");




    }

}
