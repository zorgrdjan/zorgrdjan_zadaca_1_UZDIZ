/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.Podaci;

/**
 *
 * @author Zoran
 */
public class Spremnici {
    private String naziv;
    private int vrsta;
    private int jednaNaBrojMalih;
    private int jednaNaBrojSrednjih;
    private int jednNaBrojVelikih;
    private int nosivost;

    public Spremnici(String naziv, int vrsta, int jednaNaBrojMalih, int jednaNaBrojSrednjih, int jednNaBrojVelikih, int nosivost) {
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.jednaNaBrojMalih = jednaNaBrojMalih;
        this.jednaNaBrojSrednjih = jednaNaBrojSrednjih;
        this.jednNaBrojVelikih = jednNaBrojVelikih;
        this.nosivost = nosivost;
    }
     public String ispis()
    {
        return "Naziv:"+this.naziv+" vrsta:"+this.vrsta+" jednaNaBrojMalih:"+this.jednaNaBrojMalih+" jednaNaBrojSrednjih:"+this.jednaNaBrojSrednjih +" jednNaBrojVelikih:"+ this.jednNaBrojVelikih+" nosivost"+this.nosivost;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getVrsta() {
        return vrsta;
    }

    public void setVrsta(int vrsta) {
        this.vrsta = vrsta;
    }

    public int getJednaNaBrojMalih() {
        return jednaNaBrojMalih;
    }

    public void setJednaNaBrojMalih(int jednaNaBrojMalih) {
        this.jednaNaBrojMalih = jednaNaBrojMalih;
    }

    public int getJednaNaBrojSrednjih() {
        return jednaNaBrojSrednjih;
    }

    public void setJednaNaBrojSrednjih(int jednaNaBrojSrednjih) {
        this.jednaNaBrojSrednjih = jednaNaBrojSrednjih;
    }

    public int getJednNaBrojVelikih() {
        return jednNaBrojVelikih;
    }

    public void setJednNaBrojVelikih(int jednNaBrojVelikih) {
        this.jednNaBrojVelikih = jednNaBrojVelikih;
    }

    public int getNosivost() {
        return nosivost;
    }

    public void setNosivost(int nosivost) {
        this.nosivost = nosivost;
    }
     
    
    
}
