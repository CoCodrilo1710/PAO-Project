import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
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
        Scanner var = new Scanner(System.in);
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
        Meniu serviceCentral = new Meniu();
        serviceCentral.firstRead();
    }
}