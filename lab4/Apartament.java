public class Apartament {
    private int numar;
    private double pret;
    private double dimensiune;
    private String data;
    private int nrDormitoare;
    private nrBai varNrBai;

    public Apartament(int numar, double pret, double dimensiune, String data, int nrDormitoare, int nrBai) {
        this.numar = numar;
        this.pret = pret;
        this.dimensiune = dimensiune;
        this.data = data;
        this.nrDormitoare = nrDormitoare;
    }

    public Apartament() {
        this.numar = 0;
        this.pret = 0D;
        this.dimensiune = 0D;
        this.data = "01.01.1900";
        this.nrDormitoare = 0;
    }

    // Getteri si setteri pentru variabilele private
    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(double dimensiune) {
        this.dimensiune = dimensiune;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNrDormitoare() {
        return nrDormitoare;
    }

    public void setNrDormitoare(int nrDormitoare) {
        this.nrDormitoare = nrDormitoare;
    }
}