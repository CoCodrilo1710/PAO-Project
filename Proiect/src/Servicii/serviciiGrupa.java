package Servicii;

import entitati.Grupa;
import entitati.Materie;
import entitati.Profesor;
import entitati.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class serviciiGrupa {
    public void afisareGrupa(Grupa x)
    {
        System.out.println("Numarul grupei este: "+x.getNumar_grupa());
        System.out.println("Numarul de studenti este: "+x.getNumar_studenti());
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        System.out.println();
        System.out.println();

        for (int i=0;i<listStudenti.size();i++)
        {
            System.out.println("Studentul #"+(i) );
            System.out.println();
            System.out.println();
            System.out.println("Numele este: "+listStudenti.get(i).getNume());
            System.out.println("Prenumele este: "+listStudenti.get(i).getPrenume());
            System.out.println("CNP-ul este: "+listStudenti.get(i).getCnp());
            System.out.println("Varsta este: "+listStudenti.get(i).getAge());
            System.out.println("Media este: "+listStudenti.get(i).getMedie());
            System.out.println();
            System.out.println();

            Student xy = listStudenti.get(i);
            System.out.println("Notele sale sunt urmatoarele: ");
            System.out.println();
            for (Materie mat: xy.getSituatie() ) {

                System.out.println("Materia: --- "+mat.getNumeMaterie()+ " ---");
                for (Materie.forma forma: mat.getNote() ) {
                    System.out.println("Nota: "+mat.getter_nota(forma)+" ,    Data: "+mat.getter_data(forma).getDayOfMonth()+"."+mat.getter_data(forma).getMonthValue());
                    System.out.println();
                    System.out.println("Absente: ");
                    for (LocalDate data: mat.getAbsente() ) {
                        System.out.println(data.getDayOfMonth()+"."+data.getMonthValue());
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
            }
        }
    }

    public void setareMedieGrupa(Grupa x)
    {
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        serviciiStudent serviciiStudent = new serviciiStudent();
        for (Student x1 : listStudenti) {
            serviciiStudent.setMedieStudent(x1);
        }
    }

    public void setareRestantaGrupa(Grupa x)
    {
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        serviciiStudent serviciiStudent = new serviciiStudent();
        for (Student x1 : listStudenti) {
            serviciiStudent.setRestantaMaterii(x1);
        }
    }

    public boolean exitaStudent(Grupa x, String nume, String prenume)
    {
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        for (Student x1 : listStudenti) {
            if (x1.getNume().equals(nume) && x1.getPrenume().equals(prenume)) {
                return true;
            }
        }
        return false;
    }

    public Student getStudentByName(Grupa x, String nume, String prenume)
    {
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        for (Student x1 : listStudenti) {
            if (x1.getNume().equals(nume) && x1.getPrenume().equals(prenume)) {
                return x1;
            }
        }
        return null;
    }

    public int returnNrRestanti(Grupa x)
    {
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        int nrRestanti=0;
        int ok=0;
        for (Student x1 : listStudenti) {
            ok=0;
            for (Materie x2 : x1.getSituatie() ) {
                if (x2.isRestanta()) {
                    ok=1;
                }
            }
            if (ok==1) {
                nrRestanti++;
            }
        }
        return nrRestanti;
    }

    public void setareProfesorMass(Grupa x, Profesor y, int numarMaterie)
    {
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        for (Student x1 : listStudenti) {
            x1.getSituatie().get(numarMaterie).setProfesor(y);
        }
    }

    public void stergereProfesorMass(Grupa x, int numarMaterie)
    {
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );
        for (Student x1 : listStudenti) {
            x1.getSituatie().get(numarMaterie).setProfesor(null);
        }
    }

    public Grupa returnGrupaOrdonataByMedie(Grupa x)
    {
        TreeSet<Student> treeSet = (TreeSet<Student>) x.getStudenti().descendingSet();
        Grupa t = new Grupa(x);
        return t;
    }

}
