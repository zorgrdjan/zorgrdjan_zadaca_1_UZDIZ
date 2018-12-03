/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1;

import java.util.List;

/**
 *
 * @author Zoran
 */
public class SpremnikZaSmece {
    private int idSpremnika;
    private float kapacitetSpremnika;
    private List<Integer> popisKorisnika;
    private int vrstaSpremnika; //1 kanta 2 kontejner
    private String vrstaSmecaUSpremniku;
    private int nosivost;
    private int tipSpremnika; //1 mali 2 srednji 3 veliki



    public SpremnikZaSmece(int idSpremnika, float kapacitetSpremnika, List<Integer> popisKorisnika, int vrstaSpremnika, String vrstaSmecaUSpremniku, int nosivost) {
        this.idSpremnika = idSpremnika;
        this.kapacitetSpremnika = kapacitetSpremnika;
        this.popisKorisnika = popisKorisnika;
        this.vrstaSpremnika = vrstaSpremnika;
        this.vrstaSmecaUSpremniku = vrstaSmecaUSpremniku;
        this.nosivost = nosivost;
    }

    public int getIdSpremnika() {
        return idSpremnika;
    }

    public void setIdSpremnika(int idSpremnika) {
        this.idSpremnika = idSpremnika;
    }

    public List<Integer> getPopisKorisnika() {
        return popisKorisnika;
    }

    public void setPopisKorisnika(List<Integer> popisKorisnika) {
        this.popisKorisnika = popisKorisnika;
    }

    public int getVrstaSpremnika() {
        return vrstaSpremnika;
    }

    public void setVrstaSpremnika(int vrstaSpremnika) {
        this.vrstaSpremnika = vrstaSpremnika;
    }

    public int getNosivost() {
        return nosivost;
    }

    public void setNosivost(int nosivost) {
        this.nosivost = nosivost;
    }

    public float getKapacitetSpremnika() {
        return kapacitetSpremnika;
    }

    public void setKapacitetSpremnika(float kapacitetSpremnika) {
        this.kapacitetSpremnika = kapacitetSpremnika;
    }

    public String getVrstaSmecaUSpremniku() {
        return vrstaSmecaUSpremniku;
    }

    public void setVrstaSmecaUSpremniku(String vrstaSmecaUSpremniku) {
        this.vrstaSmecaUSpremniku = vrstaSmecaUSpremniku;
    }

    public int getTipSpremnika() {
        return tipSpremnika;
    }

    public void setTipSpremnika(int tipSpremnika) {
        this.tipSpremnika = tipSpremnika;
    }
    
    
    
    
    
}
