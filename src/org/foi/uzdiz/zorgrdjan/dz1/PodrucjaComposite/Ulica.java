/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite;

import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Ulice;
import org.foi.uzdiz.zorgrdjan.dz1.Program;

/**
 *
 * @author Zoran
 */
public class Ulica extends Program implements Podrucje {

    private String id_Ulice;
    private String parrent_ulice;

    public Ulica(String id_Ulice, String parrent_ulice) {
        this.id_Ulice = id_Ulice;
        this.parrent_ulice = parrent_ulice;
    }

    @Override
    public void add(Podrucja podrucje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Podrucja podrucje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProductByName(String imeDjeteta, Podrucja podrucje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.id_Ulice;
    }

    @Override
    public void print() {
        System.out.println("Naziv ulice:" + id_Ulice);
        String newline = System.getProperty("line.separator");
        System.out.println("Ulica: " + id_Ulice + newline
                + "Iznos otpada Staklo: " + getStaklo()+ newline
                + "Iznos otpada Papir: " + getPapir()+ newline
                + "Iznos otpada Metal: " + getMetal()+ newline
                + "Iznos otpada Bio: " + getBio()+ newline
                + "Iznos otpada Mijesano: " + getMijesano());
    }

    @Override
    public void addProductByName(String imePodrucja, Ulica ulica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getStaklo() {
        for (Ulice ulica : popisUlica) {
            if (ulica.getId_ulice().equals(this.id_Ulice)) {
                return ulica.getUkupniOtpadStaklo();
            }
        }
        return 0;
    }

    @Override
    public float getPapir() {
        for (Ulice ulica : popisUlica) {
            if (ulica.getId_ulice().equals(this.id_Ulice)) {
                return ulica.getUkupniOtpadPapir();
            }
        }
        return 0;
    }

    @Override
    public float getMetal() {
        for (Ulice ulica : popisUlica) {
            if (ulica.getId_ulice().equals(this.id_Ulice)) {
                return ulica.getUkupniOtpadMetal();
            }
        }
        return 0;
    }

    @Override
    public float getBio() {
        for (Ulice ulica : popisUlica) {
            if (ulica.getId_ulice().equals(this.id_Ulice)) {
                return ulica.getUkupniOtpadBio();
            }
        }
        return 0;
    }

    @Override
    public float getMijesano() {
        for (Ulice ulica : popisUlica) {
            if (ulica.getId_ulice().equals(this.id_Ulice)) {
                return ulica.getUkupniOtpadMijesano();
            }
        }
        return 0;
    }

 

}
