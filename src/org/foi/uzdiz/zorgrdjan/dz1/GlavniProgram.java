/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1;

import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Spremnici;
import org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite.GlavnoPodrucje;
import org.foi.uzdiz.zorgrdjan.dz1.Singleton.ParametriSingleton;
import org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite.Ulica;
import org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite.Podrucja;
import org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite.Podrucje;

/**
 *
 * @author Zoran
 */
public class GlavniProgram {

    /**
     * @param args the command line arguments
     */
   // public static Program program = new Program();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Broj parametara je pogresan");
        } else {
            String adresa = args[0];
            ParametriSingleton parametar = ParametriSingleton.getInstance(adresa);
            Program program = new Program();
            program.UcitajVozila();
            program.UcitajSpremnike();
            program.UcitajUlice();
            program.ucitajDispecer();
            //    program.ispisiKomande();
            //      program.IzvrsiKomande();
            //  program.ucitajPodrucja();
            GlavnoPodrucje podrucje = new GlavnoPodrucje();
            podrucje.ucitajPodrucja();
            //    podrucje.hardKodiraniPodaci();
            podrucje.dodijeliPodrucja();

            program.brojMjestaUlica();
            program.kreirajKorisnika();
            program.podijeliSpremnikeZaSmece();
            program.dodijeliOtpadKorisnicima();
//            program.ispisiSmeceKontejneri();
            for (Spremnici spremnik : program.getPopisSpremnika()) {
                for (int i = 1; i < 4; i++) {
                    if (spremnik.getNaziv().equalsIgnoreCase("mješano")) {
                        program.dodijeliOtpadKontejnerima("mjesano", i);
                    }
                    program.dodijeliOtpadKontejnerima(spremnik.getNaziv(), i);
                }
            }
            podrucje.ispis();

       
           program.kreiranjeVozilaZaOtpad();
           program.IzvrsiKomande();
//            program.voziKamionePoUlicama();
//            program.ispisiKolicineOtpadaNaOtpadu();
//            program.ispisPreuzetihSpremnika(program.getPopisReportVozila());
        }
    }
}
//        
//       

