package entitati;

import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;

public class Student extends Persoana implements Comparable<Student>{

    private String studentEmail;
    private String NrTelefon;
    private int AndeStudiu;
    private int semestru;

    private Vector<Materie> situatie;

    public Student() {
        super();
        situatie=null;
    }

    public Student(String cnp, String Prenume, String Nume, int age) {
        super(cnp, Prenume, Nume, age);
        situatie=new Vector<>();
    }


    public Student(String cnp, String Prenume, String Nume, int age, String studentEmail, String NrTelefon, int AndeStudiu, int semestru) {
        super(cnp, Prenume, Nume, age);
        this.studentEmail = studentEmail;
        this.NrTelefon = NrTelefon;
        this.AndeStudiu = AndeStudiu;
        this.semestru = semestru;
        this.situatie= new Vector<>();
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getNrTelefon() {
        return NrTelefon;
    }

    public void setNrTelefon(String NrTelefon) {
        this.NrTelefon = NrTelefon;
    }

    public int getAndeStudiu() {
        return AndeStudiu;
    }

    public void setAndeStudiu(int AndeStudiu) {
        this.AndeStudiu = AndeStudiu;
    }

    public int getsemestru() {
        return semestru;
    }

    public void setsemestru(int semestru) {
        this.semestru = semestru;
    }

    public Vector<Materie> getSituatie() {
        return situatie;
    }

    public void setSituatie(Vector<Materie> situatie) {
        this.situatie = situatie;
    }

    @Override
    public String toString() {
        return  "Student{" +
                "cnp = " + cnp + '\'' +
                ", Prenume=" + Prenume + '\'' +
                ", Nume = " + Nume + '\'' +
                ", varsta =" + age +
                ", student email=" + studentEmail + '\'' +
                ", Numar de telefon =" + NrTelefon + '\'' +
                ", anul de studiu = " + AndeStudiu + '\'' +
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
        return studentEmail == that.studentEmail && NrTelefon == that.NrTelefon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentEmail, NrTelefon);
    }

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getNume).thenComparing(Student::getPrenume).compare(this, o);
    }
}
