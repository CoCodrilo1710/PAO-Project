package exceptions;


public class UnknownStudentException extends Exception{
    public UnknownStudentException(String nume, String prenume) {
        super("Studentul " + nume + " " + prenume + " nu exista in baza de date!");
    }
}
