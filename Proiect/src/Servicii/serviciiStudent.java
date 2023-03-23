package Servicii;

import entitati.Materie;
import entitati.Student;

import java.time.LocalDate;

public class serviciiStudent {

    public void setMedieStudent(Student x)
    {
        serviciiMaterii mainMaterii = new serviciiMaterii();
        int suma=0;
        double medieTotala=0.0, medieMaterie=0.0;
        for (Materie y:x.getSituatie()) {
            suma =0;
            medieMaterie=0.0;
            for (int i=0;i<y.getNote().size();i++) {
                suma+=mainMaterii.return_nota(x.getSituatie(),x.getSituatie().indexOf(y),i);
            }
            if (suma==0) {
                medieMaterie=0.0;
            }
            else {
                medieMaterie = (double)suma/y.getNote().size()*1.0;
            }
            medieTotala+=medieMaterie;
        }
        medieTotala = (double) medieTotala/6.0;

        x.setMedie(medieTotala);
    }

    public void setMediePerMaterie(Student x, Materie y)
    {
        serviciiMaterii mainMaterii = new serviciiMaterii();
        int suma=0;
        double medieTotala=0.0, medieMaterie=0.0;
        suma =0;
        medieMaterie=0.0;
        for (int i=0;i<y.getNote().size();i++) {
            suma+=mainMaterii.return_nota(x.getSituatie(),x.getSituatie().indexOf(y),i);
        }
        if (suma==0) {
            medieMaterie=0.0;
        }
        else {
            medieMaterie = (double)suma/y.getNote().size()*1.0;
        }
        x.getSituatie().get(x.getSituatie().indexOf(y)).setMedie(medieMaterie);
    }


    public void setRestantaMaterii(Student x)
    {
        serviciiMaterii mainMaterii = new serviciiMaterii();
        for (Materie y:x.getSituatie()) {
            if (x.getSituatie().get(x.getSituatie().indexOf(y)).getMedie()<5.0) {
                x.getSituatie().get(x.getSituatie().indexOf(y)).setRestanta(true);
            }
            else{
                x.getSituatie().get(x.getSituatie().indexOf(y)).setRestanta(false);
            }
        }
    }

    public void afisareStudent(Student x)
    {
        System.out.println("Numele este: "+x.getNume());
        System.out.println("Prenumele este: "+x.getPrenume());
        System.out.println("CNP-ul este: "+x.getCnp());
        System.out.println("Varsta este: "+x.getAge());
        System.out.println("Media este: "+x.getMedie());
        System.out.println();
        System.out.println();

        System.out.println("Notele/Absentele sale sunt urmatoarele: ");
        System.out.println();
        for (Materie mat: x.getSituatie() ) {

            System.out.println("Materia: --- "+mat.getNumeMaterie()+ " ---");
            System.out.println("Note: ");
            for (Materie.forma forma: mat.getNote() ) {
                System.out.println("Nota: "+mat.getter_nota(forma)+" ,    Data: " + mat.getter_data(forma).getDayOfMonth()+"."+mat.getter_data(forma).getMonthValue());
                System.out.println();
            }
            System.out.println();
            System.out.println("Absente: ");
            for (LocalDate data: mat.getAbsente() ) {
                System.out.println(data.getDayOfMonth()+"."+data.getMonthValue());
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public void adaugaNota(Student x, int y, int nota, LocalDate data)
    {
        serviciiMaterii mainMaterii = new serviciiMaterii();
        mainMaterii.add_nota(x.getSituatie(),y ,nota, data);
    }

    public void stergeNota(Student x, int y, int nota, LocalDate data)
    {
        serviciiMaterii mainMaterii = new serviciiMaterii();
        mainMaterii.removeNotaByNota(x.getSituatie(),y ,nota, data);
    }


}
