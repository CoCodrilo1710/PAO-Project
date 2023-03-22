package entitati;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class Materie {

    public class forma{
        private int nota;
        private LocalDate Data;


    }

    public int getter_nota(forma x)
    {
        return x.nota;
    }

    public LocalDate getter_data(forma x)
    {
        return x.Data;
    }

    private Profesor profesor;
    private allMaterii numeMaterie;
    private int credite;
    private int nrAbsente;
    private int nrNote;

    private double medie;
    private ArrayList<forma>  note;
    private boolean restanta;
    private TreeSet<LocalDate> absente;

    public forma get_forma(int local_nota, LocalDate local_data)
    {
        forma aici = new forma();
        aici.Data=local_data;
        aici.nota=local_nota;

        return aici;
    }

    public Materie(allMaterii numeMaterie, int credite, int nrAbsente, int nrNote, boolean restanta) {
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
        this.absente = new TreeSet<>();
        this.note = new ArrayList<>();
    }
    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
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

    public allMaterii getNumeMaterie() {
        return numeMaterie;
    }

    public void setNumeMaterie(allMaterii numeMaterie) {
        this.numeMaterie = numeMaterie;
    }

}
