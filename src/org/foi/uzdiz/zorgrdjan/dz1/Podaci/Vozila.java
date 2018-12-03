/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.Podaci;

import java.util.List;

/**
 *
 * @author Zoran
 */
public class Vozila {
    private String id_vozila;
    private String naziv;
    private String tip;
    private String vrsta;
    private int nosivost;
    private String vozaci;

    public Vozila(String id_vozila,String naziv, String tip, String vrsta, int nosivost, String vozaci) {
        this.id_vozila=id_vozila;
        this.naziv = naziv;
        this.tip = tip;
        this.vrsta = vrsta;
        this.nosivost = nosivost;
        this.vozaci = vozaci;
    }
     public String ispis()
    {
        return "ID vozila:"+id_vozila+" Naziv:"+this.naziv+" Tip:"+this.tip+" Vrsta:"+this.vrsta+" Nosivost:"+this.nosivost +" Vozaci:"+ this.vozaci;
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

    public String getId_vozila() {
        return id_vozila;
    }

    public void setId_vozila(String id_vozila) {
        this.id_vozila = id_vozila;
    }
    
}

