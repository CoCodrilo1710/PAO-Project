package model.abstractsSealed;

import lombok.experimental.SuperBuilder;
import model.Materie;
import service.MedieCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

@SuperBuilder
public final class Student extends Persoana implements Comparable<Student> {
    private int id;
    private String studentEmail;
    private String nrTelefon;
    private int andeStudiu;
    private int semestru;

    private ArrayList<Materie> situatie;

    private double medie;

    private MedieCalculator medieCalculator;


    public Student(String cnp, String prenume, String nume, int age, String studentEmail, String nrTelefon, int andeStudiu, int semestru) {
        super(cnp, prenume, nume, age);
        this.studentEmail = studentEmail;
        this.nrTelefon = nrTelefon;
        this.andeStudiu = andeStudiu;
        this.semestru = semestru;
        this.situatie = new ArrayList<>();
        this.medie = 0.0D;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setMedieCalculator(MedieCalculator medieCalculator) {
        this.medieCalculator = medieCalculator;
    }

    public MedieCalculator getMedieCalculator() {
        return medieCalculator;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public int getAndeStudiu() {
        return andeStudiu;
    }

    public void setAndeStudiu(int andeStudiu) {
        this.andeStudiu = andeStudiu;
    }

    public int getsemestru() {
        return semestru;
    }

    public void setsemestru(int semestru) {
        this.semestru = semestru;
    }

    public ArrayList<Materie> getSituatie() {
        return situatie;
    }

    public void setSituatie(ArrayList<Materie> situatie) {
        this.situatie = situatie;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "cnp = " + getCnp() + '\'' +
                ", Prenume=" + getPrenume() + '\'' +
                ", Nume = " + getNume() + '\'' +
                ", varsta =" + getAge() +
                ", student email=" + studentEmail + '\'' +
                ", Numar de telefon =" + nrTelefon + '\'' +
                ", anul de studiu = " + andeStudiu + '\'' +
                ", semestru = " + semestru + '\'' +
                ", situatie = " + situatie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student that = (Student) o;
        return studentEmail == that.studentEmail && nrTelefon == that.nrTelefon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentEmail, nrTelefon);
    }

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getMedie).thenComparing(Student::getNume).thenComparing(Student::getPrenume).thenComparing(Student::getCnp).compare(this, o);
    }
}
