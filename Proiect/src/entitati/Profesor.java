package entitati;

import java.util.Objects;

public class Profesor extends Persoana{
    private static int id;
    private String Email;
    private int Salariu;
    private String Rank;

    public Profesor() {
        super();
    }


    public Profesor(String Email, int Salariu, String Rank) {
        this.Email = Email;
        this.Salariu = Salariu;
        this.Rank = Rank;
        id++;
    }

    public Profesor(String cnp, String Prenume, String Nume, String Email, String Rank, int Salariu) {
        super(cnp, Prenume, Nume);
        this.Email = Email;
        this.Rank = Rank;
        this.Salariu = Salariu;
        id++;
    }

    public static int getterId() {
        return id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getSalariu() {
        return Salariu;
    }

    public void setSalariu(int Salariu) {
        this.Salariu = Salariu;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profesor that = (Profesor) o;
        return Email == that.Email && Salariu == that.Salariu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Email, Salariu);
    }

}
