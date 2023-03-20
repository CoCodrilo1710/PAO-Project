package entitati;

import java.util.TreeSet;

public class Grupa {
    private int numar_grupa;
    private TreeSet<Student> studenti;
    private static int numar_studenti;

    static {
        numar_studenti = 0;
    }

    public Grupa(int nrgrupa)
    {
        studenti=new TreeSet<>();
        numar_grupa=nrgrupa;
    }

    public void Adauga_Student(Student local)
    {
        studenti.add(local);
        numar_studenti++;
    }

    public void Sterge_Student(Student local)
    {
        studenti.remove(local);
        numar_studenti--;
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

    public static int getNumar_studenti() {
        return numar_studenti;
    }

    public static void setNumar_studenti(int numar_studenti) {
        Grupa.numar_studenti = numar_studenti;
    }





}
