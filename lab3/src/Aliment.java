public class Aliment {
   private long dataExp;
   private String Ingrediente;
   private Double pret;
    private Double calorii;

    public long getDataExp() {
        return dataExp;
    }

    public String getIngrediente() {
        return Ingrediente;
    }

    public Double getPret() {
        return pret;
    }

    public Double getCalorii() {
        return calorii;
    }

    public void setDataExp(long dataExp) {
        this.dataExp = dataExp;
    }

    public void setIngrediente(String ingrediente) {
        Ingrediente = ingrediente;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public void setCalorii(Double calorii) {
        this.calorii = calorii;
    }
}

