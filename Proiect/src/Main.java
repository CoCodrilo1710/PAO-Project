import Servicii.Service_Central;
import Servicii.Servicii_Materii;
import entitati.Grupa;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException
    {
       Service_Central serviceCentral = new Service_Central();
       serviceCentral.first_read();
        //Servicii_Materii bb = new Servicii_Materii();
        //bb.afisare_materii();
    }
}