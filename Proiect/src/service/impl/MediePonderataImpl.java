package service.impl;

import service.MedieCalculator;

public class MediePonderataImpl implements service.MedieCalculator{
    public static MedieCalculator getInstance() {
        return new MediePonderataImpl();
    }

    public double calculeazaMedie(model.Student x) {

        MaterieServiceImpl mainMaterii = new MaterieServiceImpl();
        int suma = 0;
        double medieTotala = 0.0;
        double medieMaterie = 0.0;
        for (model.Materie y : x.getSituatie()) {
            suma = 0;
            for (int i = 0; i < y.getNote().size(); i++) {
                suma += mainMaterii.return_nota(x.getSituatie(), x.getSituatie().indexOf(y), i);
            }
            if (suma == 0) {
                medieMaterie = 0.0;
            } else {
                medieMaterie = (double) suma / y.getNote().size();
            }
            medieTotala += medieMaterie*y.getCredite();
        }
        medieTotala = medieTotala / 23.0;

        return medieTotala;


    }
}
