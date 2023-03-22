package Servicii;

import entitati.Materie;
import entitati.Student;

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


}
