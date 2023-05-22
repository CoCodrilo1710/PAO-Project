package model;

import lombok.experimental.SuperBuilder;

import java.util.Objects;

@SuperBuilder
public class Locatie {

    private int id;
    private String nume;
    private String adresa;
    private String oras;
    private String judet;
    private String tara;

    public Locatie(String nume, String adresa, String oras, String judet, String tara) {
        this.nume = nume;
        this.adresa = adresa;
        this.oras = oras;
        this.judet = judet;
        this.tara = tara;
    }

    public Locatie(Locatie x) {
        this.nume = x.nume;
        this.adresa = x.adresa;
        this.oras = x.oras;
        this.judet = x.judet;
        this.tara = x.tara;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locatie locatie)) return false;
        return Objects.equals(nume, locatie.nume) && adresa.equals(locatie.adresa) && oras.equals(locatie.oras) && tara.equals(locatie.tara);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, adresa, oras, tara);
    }

    @Override
    public String toString() {
        return "Locatie: \n" + "Nume: " + nume + "\nAdresa: " + adresa + "\nOras: " + oras + "\nTara: " + tara + "\n";
    }
}
