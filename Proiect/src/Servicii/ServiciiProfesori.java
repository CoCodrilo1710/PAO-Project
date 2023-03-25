package Servicii;

import Servicii.Interfete.ProfesoriInterfata;
import entitati.Profesor;

public class ServiciiProfesori implements ProfesoriInterfata {

    @Override
    public void afisareProfesor(Profesor x) {
        System.out.println("ID: " + Profesor.getterId());
        System.out.println("Nume: " + x.getNume());
        System.out.println("Prenume: " + x.getPrenume());
        System.out.println("CNP: " + x.getCnp());
        System.out.println("Email: " + x.getEmail());
        System.out.println("Rank: " + x.getRank());
        System.out.println("Salariu: " + x.getSalariu());
        System.out.println();
    }

}
