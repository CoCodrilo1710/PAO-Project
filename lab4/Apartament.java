public class Apartament {
    private int numar;
    private double pret;
    private double dimensiune;
    private String data;
    private int nrDormitoare;
    enum nrBai
    {
        o_baie, doua_bai
    }

    private nrBai varNrBai;


    public Apartament(int numar, double pret, double dimensiune, String data, int nrDormitoare, int nrBai) {
        this.numar = numar;
        this.pret = pret;
        this.dimensiune = dimensiune;
        this.data = data;
        this.nrDormitoare = nrDormitoare;
    }
    public Apartament()
    {
        numar=0;
        pret=0D;
        dimensiune=0D;
        data="01.01.1900";
        nrDormitoare=0;
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