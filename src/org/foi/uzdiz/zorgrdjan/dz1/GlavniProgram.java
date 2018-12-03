/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1;

import ReportBuilder.Report;
import org.foi.uzdiz.zorgrdjan.dz1.Singleton.ParametriSingleton;
import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Vozila;
import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Ulice;
import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Spremnici;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.foi.uzdiz.zorgrdjan.dz1.AbstractFactory.AbstractFactory;
import org.foi.uzdiz.zorgrdjan.dz1.AbstractFactory.KorisnikFactory;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.KorisnikNovi;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.MaliKorisnik;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.SrednjiKorisnik;
import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipoviKorisnika;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.Vozilo;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloBio;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloMetal;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloMjesano;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloPapir;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloStaklo;

/**
 *
 * @author Zoran
 */
public class GlavniProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Broj parametara je pogresan");
        } else {
            String adresa=args[0];
            ParametriSingleton parametar = ParametriSingleton.getInstance(adresa);
            Program program = new Program();

            program.UcitajVozila();
            program.UcitajSpremnike();
            program.UcitajUlice();

            program.brojMjestaUlica();

            program.kreirajKorisnika();

            program.podijeliSpremnikeZaSmece();
            //  program.ispisiGrupeKorisnika();
            program.dodijeliOtpadKorisnicima();
            //  program.ispisiKolicineOtpadaZaUlice();
            for (Spremnici spremnik : program.getPopisSpremnika()) {
                for (int i = 1; i < 4; i++) {
                    if (spremnik.getNaziv().equalsIgnoreCase("mješano")) {
                        program.dodijeliOtpadKontejnerima("mjesano", i);
                    }
                    program.dodijeliOtpadKontejnerima(spremnik.getNaziv(), i);
                }
            }
            //   program.ispisiSmeceKontejneri();
            program.kreiranjeVozilaZaOtpad();
            program.voziKamionePoUlicama();
            //   program.ispisiKorisnikePoKontejnerima();

//              Report report=new Report.ReportBuilder("Neki naslov", "Neki zapis").build();
            //  report.ispis();
            //  program.ispisiKolicineOtpadaZaUlice();
            program.ispisiKolicineOtpadaNaOtpadu();
            program.ispisPreuzetihSpremnika(program.getPopisReportVozila());
        }
//        
//       
    }

}
