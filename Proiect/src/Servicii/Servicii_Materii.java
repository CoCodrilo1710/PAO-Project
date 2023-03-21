package Servicii;

import entitati.AllMaterii;
import entitati.Materie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

public class Servicii_Materii {

    public void setter_materi(Vector<Materie> local_vector)
    {
        int i=0;
        for (AllMaterii materie : AllMaterii.values())
        {
            Materie local = new Materie();
            local.setNumeMaterie(materie);
            switch (materie)
            {
                case FLP ->  local.setCredite(5);
                case MDS ->  local.setCredite(4);
                case Inteligenta_Artificiala ->  local.setCredite(3);
                case PAO ->  local.setCredite(5);
                case Engleza -> local.setCredite(2);
                case Algoritmi_Avansati -> local.setCredite(4);
            }
            local_vector.add(local);
        }
    }

    public void afisare_materii()
    {
        int i=0;
        for (AllMaterii materie : AllMaterii.values())
        {
            System.out.println((i++) +". " + materie.toString());
        }
    }

    public void add_nota(Vector<Materie> local, int materie, int nota, LocalDate data)
    {
        local.get(materie).getNote().add(local.get(materie).get_forma(nota,data));
    }

    public int return_nota(Vector<Materie> local, int materie, int pozitie)
    {
        return local.get(materie).getter_nota(  local.get(materie).getNote().get(pozitie) );
    }

    public LocalDate return_data(Vector<Materie> local, int materie, int pozitie)
    {
        return local.get(materie).getter_data(  local.get(materie).getNote().get(pozitie) );
    }

}
