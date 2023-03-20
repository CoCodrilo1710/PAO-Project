import Servicii.Service_Central;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Service_Central serviceCentral = new Service_Central();
        serviceCentral.first_read();
    }
}