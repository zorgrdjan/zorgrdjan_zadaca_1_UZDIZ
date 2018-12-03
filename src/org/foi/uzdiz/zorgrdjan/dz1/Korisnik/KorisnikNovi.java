/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.Korisnik;

/**
 *
 * @author Zoran
 */
public abstract class KorisnikNovi {
    private static int idZaKorisnika=1;
    private int idKorisnik;
    private boolean staklo = false;
    private boolean papir = false;
    private boolean metal = false;
    private boolean bio = false;
    private boolean mjesano = false;
    private float otpadStaklo;
    private float otpadPapir;
    private float otpadMetal;
    private float otpadBio;
    private float otpadMjesano;

    public KorisnikNovi() {
        this.idKorisnik = idZaKorisnika;
        idZaKorisnika++;
    }
    

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }


    public void setStaklo(boolean staklo) {
        this.staklo = staklo;
    }

    public void setPapir(boolean papir) {
        this.papir = papir;
    }

    public void setMetal(boolean metal) {
        this.metal = metal;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public void setMjesano(boolean mjesano) {
        this.mjesano = mjesano;
    }

    public void setOtpadStaklo(float otpadStaklo) {
        this.otpadStaklo = otpadStaklo;
    }

    public void setOtpadPapir(float otpadPapir) {
        this.otpadPapir = otpadPapir;
    }

    public void setOtpadMetal(float otpadMetal) {
        this.otpadMetal = otpadMetal;
    }

    public void setOtpadBio(float otpadBio) {
        this.otpadBio = otpadBio;
    }

    public void setOtpadMjesano(float otpadMjesano) {
        this.otpadMjesano = otpadMjesano;
    }

    public  int getIdZaKorisnika() {
        return idZaKorisnika;
    }

    public  void setIdZaKorisnika(int idZaKorisnika) {
        KorisnikNovi.idZaKorisnika = idZaKorisnika;
    }

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public boolean isStaklo() {
        return staklo;
    }

    public boolean isPapir() {
        return papir;
    }

    public boolean isMetal() {
        return metal;
    }

    public boolean isBio() {
        return bio;
    }

    public boolean isMjesano() {
        return mjesano;
    }

    public float getOtpadStaklo() {
        return otpadStaklo;
    }

    public float getOtpadPapir() {
        return otpadPapir;
    }

    public float getOtpadMetal() {
        return otpadMetal;
    }

    public float getOtpadBio() {
        return otpadBio;
    }

    public float getOtpadMjesano() {
        return otpadMjesano;
    }
    
    
}
