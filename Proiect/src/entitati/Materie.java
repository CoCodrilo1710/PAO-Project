package entitati;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

enum AllMaterii
{
    PAO,
    Inteligenta_Artificiala,
    Algoritmi_Avansati,
    Engleza,
    MDS,
    FLP
}
public class Materie {

    class forma{
        public int nota;
        public LocalDate Data;
    }

    private Profesor profesor;
    private AllMaterii numeMaterie;
    private int credite;
    private int nrAbsente;
    private int nrNote;
    private ArrayList<forma>  note;
    private boolean restanta;
    private TreeSet<LocalDate> absente;

    public Materie(AllMaterii numeMaterie, int credite, int nrAbsente, int nrNote, boolean restanta) {
        this.numeMaterie = numeMaterie;
        this.credite = credite;
        this.nrAbsente = nrAbsente;
        this.nrNote = nrNote;
        this.restanta = restanta;
        this.absente = new TreeSet<>();
        this.note = new ArrayList<>();
    }

    public Materie()
    {
        this.numeMaterie = null;
        this.credite = 0;
        this.nrAbsente = 0;
        this.nrNote = 0;
        this.restanta = false;
        this.absente = null;
        this.note = null;
    }

    public int getCredite() {
        return credite;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getNrAbsente() {
        return nrAbsente;
    }

    public int getNrNote() {
        return nrNote;
    }

    public ArrayList<forma> getNote() {
        return note;
    }

    public boolean isRestanta() {
        return restanta;
    }

    public TreeSet<LocalDate> getAbsente() {
        return absente;
    }

    public void setCredite(int credite) {
        this.credite = credite;
    }

    public void setNrAbsente(int nrAbsente) {
        this.nrAbsente = nrAbsente;
    }

    public void setNrNote(int nrNote) {
        this.nrNote = nrNote;
    }

    public void setNote(ArrayList<forma> note) {
        this.note = note;
    }

    public void setRestanta(boolean restanta) {
        this.restanta = restanta;
    }

    public void setAbsente(TreeSet<LocalDate> absente) {
        this.absente = absente;
    }

    public AllMaterii getNumeMaterie() {
        return numeMaterie;
    }

    public void setNumeMaterie(AllMaterii numeMaterie) {
        this.numeMaterie = numeMaterie;
    }

}
