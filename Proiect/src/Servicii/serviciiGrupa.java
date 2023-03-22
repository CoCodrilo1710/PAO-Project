package Servicii;

import entitati.Grupa;
import entitati.Materie;
import entitati.Student;

import java.util.ArrayList;
import java.util.List;

public class serviciiGrupa {
    public void afisareGrupa(Grupa x)
    {
        System.out.println("Numarul grupei este: "+x.getNumar_grupa());
        System.out.println("Numarul de studenti este: "+x.getNumar_studenti());
        List<Student> listStudenti = new ArrayList<Student>( x.getStudenti() );

        for (int i=0;i<listStudenti.size();i++)
        {
            System.out.println("Studentul #"+(i) );

            System.out.println("Numele este: "+listStudenti.get(i).getNume());
            System.out.println("Prenumele este: "+listStudenti.get(i).getPrenume());
            System.out.println("CNP-ul este: "+listStudenti.get(i).getCnp());
            System.out.println("Varsta este: "+listStudenti.get(i).getAge());
            System.out.println("Media este: "+listStudenti.get(i).getMedie());

            Student xy = listStudenti.get(i);
            System.out.println("Notele sale sunt urmatoarele: ");
            for (Materie mat: xy.getSituatie() ) {

                System.out.println("Materia: --- "+mat.getNumeMaterie()+ " ---");
                for (Materie.forma forma: mat.getNote() ) {
                    System.out.println("Nota: "+mat.getter_nota(forma)+"\nData: "+mat.getter_data(forma).getDayOfMonth());
                }
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

}
