package com.example.quiz;

public class Pytanie {
    private String tresc;
    private String podpowiedz;
    private boolean poprawna;
    private boolean udzielonoPoprawnaOdpowidz;

    public Pytanie(String tresc, String podpowiedz, boolean poprawna) {
        this.tresc = tresc;
        this.podpowiedz = podpowiedz;
        this.poprawna = poprawna;
        udzielonoPoprawnaOdpowidz = false;
    }

    public void setUdzielonoPoprawnaOdpowidz(boolean udzielonoPoprawnaOdpowidz) {
        this.udzielonoPoprawnaOdpowidz = udzielonoPoprawnaOdpowidz;
    }

    public String getTresc() {
        return tresc;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public boolean isPoprawna() {
        return poprawna;
    }

    public boolean isUdzielonoPoprawnaOdpowidz() {
        return udzielonoPoprawnaOdpowidz;
    }
}
