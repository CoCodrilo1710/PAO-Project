package Servicii;

import entitati.Grupa;
import entitati.Student;

import java.util.Scanner;

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
            grupa.getStudenti().add(local);

          // debug  System.out.println(nume + " " + prenume + " " + cnp + " "+ varsta + " " + email + " " + nrdetel + " " + andestudiu + " "+ semestru);
            
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
