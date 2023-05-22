package model.abstracts;

import lombok.experimental.SuperBuilder;

import java.util.Objects;

@SuperBuilder
public abstract class Persoana {
    private String cnp;
    private String prenume;
    private String nume;
    private int age;


    protected Persoana() {
    }

    protected Persoana(String cnp, String prenume, String nume, int age) {
        this.cnp = cnp;
        this.prenume = prenume;
        this.nume = nume;
        this.age = age;
    }

    protected Persoana(String cnp, String prenume, String nume) {
        this.cnp = cnp;
        this.prenume = prenume;
        this.nume = nume;
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
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + prenume + '\'' +
                ", lastName='" + nume + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return cnp.equals(persoana.cnp)
                && prenume.equals(persoana.prenume)
                && nume.equals(persoana.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp, prenume, nume);
    }
}
