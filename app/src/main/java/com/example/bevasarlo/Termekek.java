package com.example.bevasarlo;

public class Termekek {
    private String nev;
    private Integer mennyiseg;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Integer mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public Termekek(String nev, Integer mennyiseg) {
        this.nev = nev;
        this.mennyiseg = mennyiseg;
    }
}
