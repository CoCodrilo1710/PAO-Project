package entitati;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class Materie {

    private Profesor profesor;
    private AllMaterii numeMaterie;
    private int credite;
    private int nrAbsente;
    private int nrNote;
    private double medie;
    private ArrayList<FormaNota> note;
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
    public Materie() {
        this.numeMaterie = null;
        this.credite = 0;
        this.nrAbsente = 0;
        this.nrNote = 0;
        this.restanta = false;
        this.absente = new TreeSet<>();
        this.note = new ArrayList<>();
    }

    public int getterNota(FormaNota x) {
        return x.nota;
    }

    public LocalDate getterData(FormaNota x) {
        return x.Data;
    }

    public FormaNota getForma(int local_nota, LocalDate local_data) {
        FormaNota aici = new FormaNota();
        aici.Data = local_data;
        aici.nota = local_nota;
        return aici;
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

    public void setCredite(int credite) {
        this.credite = credite;
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

    public void setNrAbsente(int nrAbsente) {
        this.nrAbsente = nrAbsente;
    }

    public int getNrNote() {
        return nrNote;
    }

    public void setNrNote(int nrNote) {
        this.nrNote = nrNote;
    }

    public ArrayList<FormaNota> getNote() {
        return note;
    }

    public void setNote(ArrayList<FormaNota> note) {
        this.note = note;
    }

    public boolean isRestanta() {
        return restanta;
    }

    public TreeSet<LocalDate> getAbsente() {
        return absente;
    }

    public void setAbsente(TreeSet<LocalDate> absente) {
        this.absente = absente;
    }

    public boolean getRestanta() {
        return restanta;
    }

    public void setRestanta(boolean restanta) {
        this.restanta = restanta;
    }

    public AllMaterii getNumeMaterie() {
        return numeMaterie;
    }

    public void setNumeMaterie(AllMaterii numeMaterie) {
        this.numeMaterie = numeMaterie;
    }

}
