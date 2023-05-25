import application.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("   ------------- DISCLAIMER ------------     ");
        System.out.println();
        System.out.println("Se recomanda largirea terminalului pentru a intra un rand complet pe latimea acestuia!");
        System.out.println();
        System.out.println("Aceasta aplicatie simuleaza un catalog online construit pe planul unui grupe studentesti cu un numar dat de studenti!");
        System.out.println();
        System.out.println("------- Aplicatia are aplicabilitate in cadrul secretariatului in activitati precum alocarea locurilor la caminele UNIBUC ------");
        System.out.println();
        System.out.println("  Precizari despre folosirea aplicatiei:");
        System.out.println("- Notele, respectiv absentele trebuiesc adaugate una cate una");
        System.out.println("- Acelasi aspect se foloseste si la stergerea lor");
        System.out.println();
        System.out.println();
        System.out.println("-------Rugam citirea cu atentie a instructiunilor date pe ecran!----------");
        System.out.println();
        System.out.println();
        Scanner varCitire = new Scanner(System.in);
        System.out.println("Daca ati citit acest mesaj, puteti trece mai departe!");
        System.out.println("Pentru acest lucru, apasati tasta ENTER!");
        String key;
        key = varCitire.nextLine();
        if (key.equals("")) {
            int numRowsInConsole = 60;
            for (int ii = 0; ii < numRowsInConsole; ii++) {
                System.out.println();
            }
        }


        Menu serviceCentral = Menu.getInstance();
        System.out.println("Exista 2 moduri de functionare a acestei aplicatii!");
        System.out.println("1. Modul de functionare cu baza de date");
        System.out.println("2. Modul de functionare cu input de la tastatura");
        System.out.println("Pentru a alege modul de functionare, tastati 1 sau 2!");
        Scanner varCitire2 = new Scanner(System.in);
        String key2;
        key2 = varCitire2.nextLine();
        if (key2.equals("1")) {
            int numRowsInConsole = 60;
            for (int ii = 0; ii < numRowsInConsole; ii++) {
                System.out.println();
            }

            serviceCentral.getRequirementsForLastPart();

        } else if (key2.equals("2")) {
            int numRowsInConsole = 60;
            for (int ii = 0; ii < numRowsInConsole; ii++) {
                System.out.println();
            }
            serviceCentral.firstRead();

        } else {
            System.out.println("Ati introdus o valoare gresita!");
            System.out.println("Aplicatia se va inchide!");
            System.exit(0);
        }
        serviceCentral.getRequirementsForLastPart();
    }
}