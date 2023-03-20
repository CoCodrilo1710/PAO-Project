package entitati;

import java.util.Objects;

public class Persoana {
    protected String cnp;
    protected String Prenume;
    protected String Nume;
    protected int age;


    public Persoana() {
    }

    public Persoana(String cnp, String Prenume, String Nume, int age) {
        this.cnp = cnp;
        this.Prenume = Prenume;
        this.Nume = Nume;
        this.age = age;
    }

    public Persoana(String cnp, String Prenume, String Nume) {
        this.cnp = cnp;
        this.Prenume = Prenume;
        this.Nume = Nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        this.Prenume = prenume;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        this.Nume = nume;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + Prenume + '\'' +
                ", lastName='" + Nume + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana Persoana = (Persoana) o;
        return cnp.equals(Persoana.cnp)
                && Prenume.equals(Persoana.Prenume)
                && Nume.equals(Persoana.Nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp, Prenume, Nume);
    }
}
