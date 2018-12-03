/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.Podaci;

import java.util.List;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.KorisnikNovi;
import org.foi.uzdiz.zorgrdjan.dz1.SpremnikZaSmece;

/**
 *
 * @author Zoran
 */
public class Ulice {

    private String naziv;
    private int brojMjesta;
    private int udioMali;
    private int udioSrednji;
    private int udioVeliki;
    private int brojMali;
    private int brojSrednji;
    private int brojVeliki;
    private List<KorisnikNovi> korisnici;
    private List<SpremnikZaSmece> spremniciSmeca;
    private float ukupniOtpadStaklo = 0;
    private float ukupniOtpadPapir = 0;
    private float ukupniOtpadMetal = 0;
    private float ukupniOtpadBio = 0;
    private float ukupniOtpadMijesano = 0;

    public Ulice(String naziv, int brojMjesta, int udioMali, int udioSrednji, int udioVeliki) {
        this.naziv = naziv;
        this.brojMjesta = brojMjesta;
        this.udioMali = udioMali;
        this.udioSrednji = udioSrednji;
        this.udioVeliki = udioVeliki;
    }

    public List<SpremnikZaSmece> getSpremniciSmeca() {
        return spremniciSmeca;
    }

    public void setSpremniciSmeca(List<SpremnikZaSmece> spremniciSmeca) {
        this.spremniciSmeca = spremniciSmeca;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojMjesta() {
        return brojMjesta;
    }

    public void setBrojMjesta(int brojMjesta) {
        this.brojMjesta = brojMjesta;
    }

    public int getUdioMali() {
        return udioMali;
    }

    public void setUdioMali(int udioMali) {
        this.udioMali = udioMali;
    }

    public int getUdioSrednji() {
        return udioSrednji;
    }

    public void setUdioSrednji(int udioSrednji) {
        this.udioSrednji = udioSrednji;
    }

    public int getUdioVeliki() {
        return udioVeliki;
    }

    public void setUdioVeliki(int udioVeliki) {
        this.udioVeliki = udioVeliki;
    }

    public String ispis() {
        return "Naziv:" + this.naziv + " Broj mjesta:" + this.brojMjesta + " Udio mali:" + this.udioMali + " Udio srednji:" + this.udioSrednji + " Udio veliki:" + this.udioVeliki;
    }

    public int getBrojMali() {
        return brojMali;
    }

    public void setBrojMali(int brojMali) {
        this.brojMali = brojMali;
    }

    public int getBrojSrednji() {
        return brojSrednji;
    }

    public void setBrojSrednji(int brojSrednji) {
        this.brojSrednji = brojSrednji;
    }

    public int getBrojVeliki() {
        return brojVeliki;
    }

    public void setBrojVeliki(int brojVeliki) {
        this.brojVeliki = brojVeliki;
    }

    public List<KorisnikNovi> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<KorisnikNovi> korisnici) {
        this.korisnici = korisnici;
    }

    public void setUkupniOtpadStaklo(float ukupniOtpadStaklo) {
        this.ukupniOtpadStaklo = ukupniOtpadStaklo;
    }

    public void setUkupniOtpadPapir(float ukupniOtpadPapir) {
        this.ukupniOtpadPapir = ukupniOtpadPapir;
    }

    public void setUkupniOtpadMetal(float ukupniOtpadMetal) {
        this.ukupniOtpadMetal = ukupniOtpadMetal;
    }

    public void setUkupniOtpadBio(float ukupniOtpadBio) {
        this.ukupniOtpadBio = ukupniOtpadBio;
    }

    public void setUkupniOtpadMijesano(float ukupniOtpadMijesano) {
        this.ukupniOtpadMijesano = ukupniOtpadMijesano;
    }

    public float getUkupniOtpadStaklo() {
        return ukupniOtpadStaklo;
    }

    public float getUkupniOtpadPapir() {
        return ukupniOtpadPapir;
    }

    public float getUkupniOtpadMetal() {
        return ukupniOtpadMetal;
    }

    public float getUkupniOtpadBio() {
        return ukupniOtpadBio;
    }

    public float getUkupniOtpadMijesano() {
        return ukupniOtpadMijesano;
    }

    @Override
    public String toString() {
        String newline = System.getProperty("line.separator");
        return "Ulica: "+getNaziv()+newline+
               "Iznos otpada Staklo: "+getUkupniOtpadStaklo()+newline+
               "Iznos otpada Papir: "+getUkupniOtpadPapir()+newline+
               "Iznos otpada Metal: "+getUkupniOtpadMetal()+newline+
               "Iznos otpada Bio: "+getUkupniOtpadBio()+newline+
               "Iznos otpada Mijesano: "+getUkupniOtpadMijesano();
    }
    
}
