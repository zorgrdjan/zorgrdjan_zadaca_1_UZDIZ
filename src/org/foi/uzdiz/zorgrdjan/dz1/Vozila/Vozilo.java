/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.Vozila;

/**
 *
 * @author Zoran
 */
public abstract class Vozilo {

    private int idVozila;
    private String naziv;
    private String tip;
    private String vrsta;
    private int nosivost;
    private String vozaci;
    private static int id_brojac = 1;
    private int brojPreuzimanja;
    private int brojMjestaPreuzimanja;
    private float kolicinaOtpadaUkupno;
    private int brojOdlazakaNaOtpad;

    private boolean preuzimanjeOtpada = true; //true->preuzima otpad, false->ne preuzima otpad
    private boolean voziNaOtpad = false; //true->kamion se vozi na otpad , false->kamion ne vozi na otpad
    private int brojCiklusaNaCekanju;
    private float trenutniTeret;

    public Vozilo(String naziv, String tip, String vrsta, int nosivost, String vozaci) {
        this.idVozila = id_brojac;
        id_brojac++;
        this.naziv = naziv;
        this.tip = tip;
        this.vrsta = vrsta;
        this.nosivost = nosivost;
        this.vozaci = vozaci;
        this.trenutniTeret = 0;
        this.brojPreuzimanja = 0;
        this.brojMjestaPreuzimanja = 0;
        this.kolicinaOtpadaUkupno = 0;
        this.brojOdlazakaNaOtpad = 0;
    }

    public int getIdVozila() {
        return idVozila;
    }

    public void setIdVozila(int idVozila) {
        this.idVozila = idVozila;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getNosivost() {
        return nosivost;
    }

    public void setNosivost(int nosivost) {
        this.nosivost = nosivost;
    }

    public String getVozaci() {
        return vozaci;
    }

    public void setVozaci(String vozaci) {
        this.vozaci = vozaci;
    }

    public static int getId_brojac() {
        return id_brojac;
    }

    public static void setId_brojac(int id_brojac) {
        Vozilo.id_brojac = id_brojac;
    }

    public boolean isPreuzimanjeOtpada() {
        return preuzimanjeOtpada;
    }

    public void setPreuzimanjeOtpada(boolean preuzimanjeOtpada) {
        this.preuzimanjeOtpada = preuzimanjeOtpada;
    }

    public boolean isVoziNaOtpad() {
        return voziNaOtpad;
    }

    public void setVoziNaOtpad(boolean voziNaOtpad) {
        this.voziNaOtpad = voziNaOtpad;
    }

    public int getBrojCiklusaNaCekanju() {
        return brojCiklusaNaCekanju;
    }

    public void setBrojCiklusaNaCekanju(int brojCiklusaNaCekanju) {
        this.brojCiklusaNaCekanju = brojCiklusaNaCekanju;
    }

    public float getTrenutniTeret() {
        return trenutniTeret;
    }

    public void setTrenutniTeret(float trenutniTeret) {
        this.trenutniTeret = trenutniTeret;
    }

    public int getBrojPreuzimanja() {
        return brojPreuzimanja;
    }

    public void setBrojPreuzimanja(int brojPreuzimanja) {
        this.brojPreuzimanja = brojPreuzimanja;
    }

    public int getBrojMjestaPreuzimanja() {
        return brojMjestaPreuzimanja;
    }

    public void setBrojMjestaPreuzimanja(int brojMjestaPreuzimanja) {
        this.brojMjestaPreuzimanja = brojMjestaPreuzimanja;
    }

    public float getKolicinaOtpadaUkupno() {
        return kolicinaOtpadaUkupno;
    }

    public void setKolicinaOtpadaUkupno(float kolicinaOtpadaUkupno) {
        this.kolicinaOtpadaUkupno = kolicinaOtpadaUkupno;
    }

    public int getBrojOdlazakaNaOtpad() {
        return brojOdlazakaNaOtpad;
    }

    public void setBrojOdlazakaNaOtpad(int brojOdlazakaNaOtpad) {
        this.brojOdlazakaNaOtpad = brojOdlazakaNaOtpad;
    }

}
