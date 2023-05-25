package application;

import model.Grupa;
import service.impl.GrupaServiceImpl;

public class VerifyAverageThread implements Runnable {
    private Grupa grupa;
    private boolean stop;

    public VerifyAverageThread(Grupa grupa) {
        this.grupa = grupa;
        this.stop = false;
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        GrupaServiceImpl serviciiGrupa = new GrupaServiceImpl();
        while (!stop) {

            serviciiGrupa.setareMedieGrupa(grupa);
            serviciiGrupa.setareRestantaGrupa(grupa);
            serviciiGrupa.setareMedieMateriiGrupa(grupa);

            try {
                Thread.sleep(1000); // Așteaptă 1 secundă între verificări
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}