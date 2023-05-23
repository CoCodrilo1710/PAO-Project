package model;

import lombok.experimental.SuperBuilder;
import model.abstracts.Persoana;

import java.util.Objects;

@SuperBuilder
public class Profesor extends Persoana {
    private int id;
    private String email;
    private int salariu;
    private String rank;

    public Profesor(String cnp, String prenume, String nume, String email, String rank, int salariu) {
        super(cnp, prenume, nume);
        this.email = email;
        this.rank = rank;
        this.salariu = salariu;
    }

    public int getterId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profesor that = (Profesor) o;
        return email == that.email && salariu == that.salariu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, salariu);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
