package entitati;

import java.util.TreeSet;

public class Grupa {
    private static int numar_studenti;

    static {
        numar_studenti = 0;
    }

    private int numar_grupa;
    private TreeSet<Student> studenti;

    private Locatie locatie;

    public Grupa(Grupa x) {
        this.numar_grupa = x.numar_grupa;
        this.studenti = x.studenti;
        this.numar_studenti = numar_studenti;

    }

    public Grupa(int nrgrupa, Locatie locatie) {
        this.studenti = new TreeSet<Student>();
        this.numar_grupa = nrgrupa;
        this.locatie = locatie;
    }

    public static int getNumar_studenti() {
        return numar_studenti;
    }

    public static void setNumar_studenti(int numar_studenti) {
        Grupa.numar_studenti = numar_studenti;
    }

    public void Adauga_Student(Student local) {
        this.studenti.add(local);
        numar_studenti++;
    }

    public int getNumar_grupa() {
        return numar_grupa;
    }

    public void setNumar_grupa(int numar_grupa) {
        this.numar_grupa = numar_grupa;
    }

    public TreeSet<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(TreeSet<Student> studenti) {
        this.studenti = studenti;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }


}
