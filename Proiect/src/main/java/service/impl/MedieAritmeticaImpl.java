package service.impl;

import model.Materie;
import model.abstractsSealed.Student;
import service.MedieCalculator;

public class MedieAritmeticaImpl implements service.MedieCalculator{

    public static MedieCalculator getInstance() {
        return new MedieAritmeticaImpl();
    }
    public double calculeazaMedie(Student x) {
        MaterieServiceImpl mainMaterii = new MaterieServiceImpl();
        int suma = 0;
        double medieTotala = 0.0;
        double medieMaterie = 0.0;
        for (Materie y : x.getSituatie()) {
            suma = 0;
            for (int i = 0; i < y.getNote().size(); i++) {
                suma += mainMaterii.return_nota(x.getSituatie(), x.getSituatie().indexOf(y), i);
            }
            if (suma == 0) {
                medieMaterie = 0.0;
            } else {
                medieMaterie = (double) suma / y.getNote().size();
            }
            medieTotala += medieMaterie;
        }
        medieTotala = medieTotala / 6.0;

        return medieTotala;
    }
}
