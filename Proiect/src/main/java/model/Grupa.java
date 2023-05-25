package model;

import lombok.experimental.SuperBuilder;

import java.util.TreeSet;
@SuperBuilder
public class Grupa {
    private int id;
    private static int numarStudenti;

    static {
        numarStudenti = 0;
    }

    private int numarGrupa;
    private TreeSet<Student> studenti;
    private Locatie locatie;

    public Grupa(Grupa x) {
        this.id = x.id;
        this.numarGrupa = x.numarGrupa;
        this.studenti = x.studenti;
        this.locatie = x.locatie;
    }

    public Grupa(int nrgrupa, Locatie locatie) {
        this.studenti = new TreeSet<>();
        this.numarGrupa = nrgrupa;
        this.locatie = locatie;
    }


    public static int getNumarStudenti() {
        return numarStudenti;
    }

    public static void setNumarStudenti(int numarStudenti) {
        Grupa.numarStudenti = numarStudenti;
    }

    public void adaugaStudent(Student local) {
        this.studenti.add(local);
        numarStudenti++;
    }

    public int getNumarGrupa() {
        return numarGrupa;
    }

    public String getNumarGrupaString() {
        return String.valueOf(numarGrupa);
    }

    public void setNumarGrupa(int numarGrupa) {
        this.numarGrupa = numarGrupa;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
