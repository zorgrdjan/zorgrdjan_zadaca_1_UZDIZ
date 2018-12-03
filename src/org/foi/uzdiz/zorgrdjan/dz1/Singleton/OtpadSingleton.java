/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.Singleton;

/**
 *
 * @author Zoran
 */
public class OtpadSingleton {

    private static OtpadSingleton otpadInstance;

    private float ukupniOtpadStaklo = 0;
    private float ukupniOtpadPapir = 0;
    private float ukupniOtpadMetal = 0;
    private float ukupniOtpadBio = 0;
    private float ukupniOtpadMijesano = 0;

    public OtpadSingleton() {
    }
    
    public static OtpadSingleton getInstanceOtpad() {
        if (otpadInstance == null) {
                    otpadInstance = new OtpadSingleton();
        }
        return otpadInstance;
    }

    public float getUkupniOtpadStaklo() {
        return ukupniOtpadStaklo;
    }

    public void setUkupniOtpadStaklo(float ukupniOtpadStaklo) {
        this.ukupniOtpadStaklo = ukupniOtpadStaklo;
    }

    public float getUkupniOtpadPapir() {
        return ukupniOtpadPapir;
    }

    public void setUkupniOtpadPapir(float ukupniOtpadPapir) {
        this.ukupniOtpadPapir = ukupniOtpadPapir;
    }

    public float getUkupniOtpadMetal() {
        return ukupniOtpadMetal;
    }

    public void setUkupniOtpadMetal(float ukupniOtpadMetal) {
        this.ukupniOtpadMetal = ukupniOtpadMetal;
    }

    public float getUkupniOtpadBio() {
        return ukupniOtpadBio;
    }

    public void setUkupniOtpadBio(float ukupniOtpadBio) {
        this.ukupniOtpadBio = ukupniOtpadBio;
    }

    public float getUkupniOtpadMijesano() {
        return ukupniOtpadMijesano;
    }

    public void setUkupniOtpadMijesano(float ukupniOtpadMijesano) {
        this.ukupniOtpadMijesano = ukupniOtpadMijesano;
    }

    @Override
    public String toString() {
        String newline = System.getProperty("line.separator");
        return "UKUPNI OTPAD NA ODLAGALASITU "+newline+
               "Iznos otpada Staklo: "+getUkupniOtpadStaklo()+newline+
               "Iznos otpada Papir: "+getUkupniOtpadPapir()+newline+
               "Iznos otpada Metal: "+getUkupniOtpadMetal()+newline+
               "Iznos otpada Bio: "+getUkupniOtpadBio()+newline+
               "Iznos otpada Mijesano: "+getUkupniOtpadMijesano(); //To change body of generated methods, choose Tools | Templates.
    }
     
}
