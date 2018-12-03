/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1;

import ReportBuilder.Report;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.uzdiz.zorgrdjan.dz1.AbstractFactory.AbstractFactory;
import org.foi.uzdiz.zorgrdjan.dz1.AbstractFactory.FactoryProducer;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.KorisnikNovi;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.MaliKorisnik;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.SrednjiKorisnik;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.VelikiKorisnik;

import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Spremnici;
import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Ulice;
import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Vozila;
import org.foi.uzdiz.zorgrdjan.dz1.Singleton.OtpadSingleton;
import org.foi.uzdiz.zorgrdjan.dz1.Singleton.ParametriSingleton;
import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipVozila;
import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipoviKorisnika;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.Vozilo;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloBio;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloMetal;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloMjesano;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloPapir;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloStaklo;

public class Program {

    private List<Ulice> popisUlica = new ArrayList<Ulice>();
    private List<Vozila> vozila = new ArrayList<Vozila>();
    private List<Spremnici> popisSpremnika = new ArrayList<Spremnici>();
    public List<Vozilo> popisVozila = new ArrayList<Vozilo>();
    public List<Vozilo> popisReportVozila = new ArrayList<>();
    public static int idKorinika = 1;
    public static int idKontejnera = 1;
    public static boolean flagOtpad = false;
    public Report noviReport = new Report.ReportBuilder("Report za EZO").build();

    public static int spremnikbroj = 0;

    public void UcitajVozila() {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        File f = new File(parametar.getIzlaz());
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(parametar.getVozila()), "UTF8"))) {
            String line;
            br.readLine ();
            while ((line  = br.readLine()) != null) {
              //  System.out.println("Linija:" + line);
                String[] dijeloviVozila = line.split(";");
                String tip = "";
                String vrsta = "";
                if (Integer.parseInt(dijeloviVozila[1]) == 0) {
                    tip = "Dizel";
                } else {
                    tip = "Električni";
                }
                Vozila upisiVozilo = new Vozila(dijeloviVozila[0], tip, dijeloviVozila[2], Integer.parseInt(dijeloviVozila[3]), dijeloviVozila[4]);
                vozila.add(upisiVozilo);
                //    System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Exception:" + e);
        }
//        for (Vozila vozila : vozila) {
//            System.out.println(vozila.ispis());
//        }
        }

    

    

    public void UcitajSpremnike() {

        ParametriSingleton parametar = ParametriSingleton.getInstance();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(parametar.getSpremnici()), "UTF8"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] dijeloviSpremnika = line.split(";");
                Spremnici noviSpremnik = new Spremnici(dijeloviSpremnika[0],
                        Integer.parseInt(dijeloviSpremnika[1]),
                        Integer.parseInt(dijeloviSpremnika[2]),
                        Integer.parseInt(dijeloviSpremnika[3]),
                        Integer.parseInt(dijeloviSpremnika[4]),
                        Integer.parseInt(dijeloviSpremnika[5]));
                //   System.out.println(line);
                popisSpremnika.add(noviSpremnik);
            }
        } catch (IOException e) {
            System.out.println("Error:" + e);

        }
//        for (Spremnici spremnik : popisSpremnika) {
//            System.out.println(spremnik.ispis());
//        }
    }

    public void UcitajUlice() {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
       try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream((parametar.getUlice())), "UTF8"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] dijeloviUlice = line.split(";");
                Ulice nova = new Ulice(dijeloviUlice[0], Integer.parseInt(dijeloviUlice[1]),
                        Integer.parseInt(dijeloviUlice[2]),
                        Integer.parseInt(dijeloviUlice[3]),
                        Integer.parseInt(dijeloviUlice[4]));
                popisUlica.add(nova);
                //  System.out.println(line);
            }
        } catch (IOException e) {

        }
//        for (Ulice ulice : popisUlica) {
//            System.out.println(ulice.ispis());
//        }
    }

    public void brojMjestaUlica() {
        for (Ulice ulice : popisUlica) {

            if (ulice.getUdioMali() > 0) {
                float broj = ((float) ulice.getUdioMali() / 100);
                ulice.setBrojMali((int) (((float) ulice.getUdioMali() / 100) * ulice.getBrojMjesta()));
            } else {
                ulice.setBrojMali(0);
            }
            if (ulice.getUdioSrednji() > 0) {
                float broj = ((float) ulice.getUdioSrednji() / 100);
                ulice.setBrojSrednji((int) (((float) ulice.getUdioSrednji() / 100) * ulice.getBrojMjesta()));
            } else {
                ulice.setBrojSrednji(0);
            }
            if (ulice.getUdioVeliki() > 0) {
                float broj = ((float) ulice.getUdioVeliki() / 100);
                ulice.setBrojVeliki((int) (((float) ulice.getUdioVeliki() / 100) * ulice.getBrojMjesta()));
            } else {
                ulice.setBrojVeliki(0);
            }
            int sumaMjestaUlica = ulice.getBrojMali() + ulice.getBrojSrednji() + ulice.getBrojVeliki();
            if (sumaMjestaUlica < ulice.getBrojMjesta()) {
                int razlika = ulice.getBrojMjesta() - sumaMjestaUlica;
                ulice.setBrojMali(ulice.getBrojMali() + razlika);
            }
//            System.out.println("Naziv ulice:" + ulice.getNaziv() + " Mjesta: " + ulice.getBrojMjesta());
//            System.out.println("Broj malih mjesta u ulici:" + ulice.getBrojMali());
//            System.out.println("Broj srednjih mjesta u ulici:" + ulice.getBrojSrednji());
//            System.out.println("Broj velikih mjesta u ulici:" + ulice.getBrojVeliki());
//            System.out.println("Suma svih mjesta u ulici:" + (ulice.getBrojMali() + ulice.getBrojSrednji() + ulice.getBrojVeliki()));
        }
    }

    public void kreirajKorisnika() {

        AbstractFactory factory = FactoryProducer.getFactory("KORISNIK");
        for (Ulice ulice : popisUlica) {
            List<KorisnikNovi> korisnici = new ArrayList<>();
            kreirajMali(ulice.getBrojMali(), korisnici, factory);
            kreirajSrednji(ulice.getBrojSrednji(), korisnici, factory);
            kreirajVeliki(ulice.getBrojVeliki(), korisnici, factory);
            ulice.setKorisnici(korisnici);
        }
    }

    public void kreirajMali(int broj, List<KorisnikNovi> korisnika, AbstractFactory factory) {

        for (int i = 0; i < broj; i++) {
            KorisnikNovi korisnikNovi = factory.getKorisnikNovi(TipoviKorisnika.MALI);
            korisnika.add(korisnikNovi);
        }
    }

    public void kreirajSrednji(int broj, List<KorisnikNovi> korisnika, AbstractFactory factory) {
        for (int i = 0; i < broj; i++) {
            KorisnikNovi korisnikNovi = factory.getKorisnikNovi(TipoviKorisnika.SREDNJI);
            korisnika.add(korisnikNovi);
        }
    }

    public void kreirajVeliki(int broj, List<KorisnikNovi> korisnika, AbstractFactory factory) {
        for (int i = 0; i < broj; i++) {
            KorisnikNovi korisnikNovi = factory.getKorisnikNovi(TipoviKorisnika.VELIKI);
            korisnika.add(korisnikNovi);
        }
    }

    public void ispisiKorisnikeUlica() {
        for (Ulice ulice : popisUlica) {
            System.out.println("Ulice:" + ulice.getNaziv());
            for (KorisnikNovi kor : ulice.getKorisnici()) {
                System.out.println("Id korisnika:" + kor.getIdZaKorisnika());
            }
        }
    }

    public void podijeliSpremnikeZaSmece() {
        for (Ulice ulice : popisUlica) {
            List<SpremnikZaSmece> spremniciSmeca = new ArrayList<>();
            for (Spremnici spremnik : popisSpremnika) {
                if (spremnik.getNaziv().equalsIgnoreCase("staklo")) {
                    kreirajKontejnerStaklo(ulice, spremnik, spremniciSmeca);
                    kreirajKontejnerStakloSrednje(ulice, spremnik, spremniciSmeca);
                    kreirajKontejnerStakloVeliko(ulice, spremnik, spremniciSmeca);
                }
                if (spremnik.getNaziv().equalsIgnoreCase("papir")) {
                    kreirajKontejnerPapir(ulice, spremnik, spremniciSmeca);
                    kreirajKontejnerPapirSrednje(ulice, spremnik, spremniciSmeca);
                    kreirajKontejnerPapirVeliko(ulice, spremnik, spremniciSmeca);

                }
                if (spremnik.getNaziv().equalsIgnoreCase("metal")) {
                    kreirajKontejnerMetal(ulice, spremnik, spremniciSmeca);
                    kreirajKontejnerMetalSrednje(ulice, spremnik, spremniciSmeca);
                    kreirajKontejnerMetalVeliko(ulice, spremnik, spremniciSmeca);

                }
                if (spremnik.getNaziv().equalsIgnoreCase("bio")) {
                    kreirajKantaBio(ulice, spremnik, spremniciSmeca);
                    kreirajKantaBioSrednje(ulice, spremnik, spremniciSmeca);
                    kreirajKantaBioVeliko(ulice, spremnik, spremniciSmeca);
                }
                if (spremnik.getNaziv().equalsIgnoreCase("mješano") && spremnik.getVrsta() == 0) {
                    kreirajKantaMjesano(ulice, spremnik, spremniciSmeca);
                }
                if (spremnik.getNaziv().equalsIgnoreCase("mješano") && spremnik.getVrsta() == 1) {
                    kreirajKantaMjesanoSrednje(ulice, spremnik, spremniciSmeca);
                    kreirajKantaMjesanoVeliko(ulice, spremnik, spremniciSmeca);
                }
            }
            ulice.setSpremniciSmeca(spremniciSmeca);
        }
    }

    public void kreirajKontejnerStaklo(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojMali() / spremnik.getJednaNaBrojMalih();
        if (brojKontejnera * spremnik.getJednaNaBrojMalih() < ulice.getBrojMali()) {
            brojKontejnera++;
        }
        //  System.out.println("Broj kontejnera za Staklo u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof MaliKorisnik && korisnik.isStaklo() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setStaklo(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojMalih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "staklo", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(1);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKontejnerStakloSrednje(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojSrednji() / spremnik.getJednaNaBrojSrednjih();
        if (brojKontejnera * spremnik.getJednaNaBrojSrednjih() < ulice.getBrojSrednji()) {
            brojKontejnera++;
        }
        //  System.out.println("Broj kontejnera za srednje Staklo u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof SrednjiKorisnik && korisnik.isStaklo() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setStaklo(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojSrednjih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "staklo", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(2);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKontejnerStakloVeliko(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojVeliki() / spremnik.getJednNaBrojVelikih();
        if (brojKontejnera * spremnik.getJednNaBrojVelikih() < ulice.getBrojVeliki()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj kontejnera za srednje Staklo u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof VelikiKorisnik && korisnik.isStaklo() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setStaklo(true);
                    if (popisKorisnika.size() >= spremnik.getJednNaBrojVelikih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "staklo", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(3);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void ispisiGrupeKorisnika() {
        for (Ulice ulice : popisUlica) {
            System.out.println("Ulice je:" + ulice.getNaziv());
            for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {
                if (spremnik.getVrstaSpremnika() == 1 && spremnik.getVrstaSmecaUSpremniku().equalsIgnoreCase("mjesano")) {
                    System.out.println("Grupa korisnika za kontejner :" + spremnik.getIdSpremnika() + " Tipa:" + spremnik.getVrstaSmecaUSpremniku());
                    for (Integer broj : spremnik.getPopisKorisnika()) {
                        System.out.println("Id korisnika:" + broj);

                    }
                }
            }
        }
    }

    private void kreirajKontejnerPapir(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojMali() / spremnik.getJednaNaBrojMalih();
        if (brojKontejnera * spremnik.getJednaNaBrojMalih() < ulice.getBrojMali()) {
            brojKontejnera++;
        }
        //  System.out.println("Broj kontejnera za Papir u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof MaliKorisnik && korisnik.isPapir() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setPapir(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojMalih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "papir", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(1);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKontejnerPapirSrednje(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojSrednji() / spremnik.getJednaNaBrojSrednjih();
        if (brojKontejnera * spremnik.getJednaNaBrojSrednjih() < ulice.getBrojSrednji()) {
            brojKontejnera++;
        }
        //  System.out.println("Broj kontejnera za srednje Papir u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof SrednjiKorisnik && korisnik.isPapir() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setPapir(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojSrednjih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "papir", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(2);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKontejnerPapirVeliko(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojVeliki() / spremnik.getJednNaBrojVelikih();
        if (brojKontejnera * spremnik.getJednNaBrojVelikih() < ulice.getBrojVeliki()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj kontejnera za veliki Papir u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof VelikiKorisnik && korisnik.isPapir() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setPapir(true);
                    if (popisKorisnika.size() >= spremnik.getJednNaBrojVelikih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "papir", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(3);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    private void kreirajKontejnerMetal(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojMali() / spremnik.getJednaNaBrojMalih();
        if (brojKontejnera * spremnik.getJednaNaBrojMalih() < ulice.getBrojMali()) {
            brojKontejnera++;
        }
        //  System.out.println("Broj kontejnera za Metal u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof MaliKorisnik && korisnik.isMetal() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setMetal(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojMalih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "metal", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(1);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKontejnerMetalSrednje(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojSrednji() / spremnik.getJednaNaBrojSrednjih();
        if (brojKontejnera * spremnik.getJednaNaBrojSrednjih() < ulice.getBrojSrednji()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj kontejnera za srednje Metal u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof SrednjiKorisnik && korisnik.isMetal() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setMetal(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojSrednjih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "metal", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(2);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKontejnerMetalVeliko(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojVeliki() / spremnik.getJednNaBrojVelikih();
        if (brojKontejnera * spremnik.getJednNaBrojVelikih() < ulice.getBrojVeliki()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj kontejnera za veliki Metal u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof VelikiKorisnik && korisnik.isMetal() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setMetal(true);
                    if (popisKorisnika.size() >= spremnik.getJednNaBrojVelikih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 2, "metal", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(3);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    private void kreirajKantaBio(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojMali() / spremnik.getJednaNaBrojMalih();
        if (brojKontejnera * spremnik.getJednaNaBrojMalih() < ulice.getBrojMali()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj Kanti za Bio u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof MaliKorisnik && korisnik.isBio() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setBio(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojMalih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 1, "bio", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(1);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKantaBioSrednje(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojSrednji() / spremnik.getJednaNaBrojSrednjih();
        if (brojKontejnera * spremnik.getJednaNaBrojSrednjih() < ulice.getBrojSrednji()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj kontejnera za srednje Bio u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof SrednjiKorisnik && korisnik.isBio() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setBio(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojSrednjih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 1, "bio", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(2);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKantaBioVeliko(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojVeliki() / spremnik.getJednNaBrojVelikih();
        if (brojKontejnera * spremnik.getJednNaBrojVelikih() < ulice.getBrojVeliki()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj kontejnera za veliki Bio u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof VelikiKorisnik && korisnik.isBio() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setBio(true);
                    if (popisKorisnika.size() >= spremnik.getJednNaBrojVelikih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 1, "bio", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(3);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    private void kreirajKantaMjesano(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojMali() / spremnik.getJednaNaBrojMalih();
        if (brojKontejnera * spremnik.getJednaNaBrojMalih() < ulice.getBrojMali()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj Kanti za Mjesano u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof MaliKorisnik && korisnik.isMjesano() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setMjesano(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojMalih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 1, "mjesano", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(1);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKantaMjesanoSrednje(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojSrednji() / spremnik.getJednaNaBrojSrednjih();
        if (brojKontejnera * spremnik.getJednaNaBrojSrednjih() < ulice.getBrojSrednji()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj Kanti za srednje mjesano u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof SrednjiKorisnik && korisnik.isMjesano() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setMjesano(true);
                    if (popisKorisnika.size() >= spremnik.getJednaNaBrojSrednjih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 1, "mjesano", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(2);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void kreirajKantaMjesanoVeliko(Ulice ulice, Spremnici spremnik, List<SpremnikZaSmece> spremniciSmeca) {
        int brojKontejnera = ulice.getBrojVeliki() / spremnik.getJednNaBrojVelikih();
        if (brojKontejnera * spremnik.getJednNaBrojVelikih() < ulice.getBrojVeliki()) {
            brojKontejnera++;
        }
        //   System.out.println("Broj kontejnera za veliki Bio u ulici:" + ulice.getNaziv() + " je:" + brojKontejnera);
        for (int i = 0; i < brojKontejnera; i++) {
            List<Integer> popisKorisnika = new ArrayList<>();
            for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                if (korisnik instanceof VelikiKorisnik && korisnik.isMjesano() == false) {
                    popisKorisnika.add(korisnik.getIdKorisnik());
                    korisnik.setMjesano(true);
                    if (popisKorisnika.size() >= spremnik.getJednNaBrojVelikih()) {
                        break;
                    }
                }
            }
            SpremnikZaSmece noviSpremnik1 = new SpremnikZaSmece(idKontejnera, 0, popisKorisnika, 1, "mjesano", spremnik.getNosivost());
            noviSpremnik1.setTipSpremnika(3);
            idKontejnera++;
            spremniciSmeca.add(noviSpremnik1);
        }
    }

    public void dodijeliOtpadKorisnicima() {
        for (Ulice ulice : popisUlica) {
            float ukupniOtpadStaklo = 0;
            float ukupniOtpadPapir = 0;
            float ukupniOtpadMetal = 0;
            float ukupniOtpadBio = 0;
            float ukupniOtpadMijesano = 0;
            List<KorisnikNovi> korisnici;
            korisnici = ulice.getKorisnici();
            for (KorisnikNovi korisnik : korisnici) {

                if (korisnik instanceof MaliKorisnik)//korisnik je mali
                {
                    generirajMali(korisnik);
                    ukupniOtpadStaklo += korisnik.getOtpadStaklo();
                    ukupniOtpadPapir += korisnik.getOtpadPapir();
                    ukupniOtpadMetal += korisnik.getOtpadMetal();
                    ukupniOtpadBio += korisnik.getOtpadBio();
                    ukupniOtpadMijesano += korisnik.getOtpadMjesano();
                } else if (korisnik instanceof SrednjiKorisnik)//korisnik je srednji
                {
                    generirajSrednji(korisnik);
                    ukupniOtpadStaklo += korisnik.getOtpadStaklo();
                    ukupniOtpadPapir += korisnik.getOtpadPapir();
                    ukupniOtpadMetal += korisnik.getOtpadMetal();
                    ukupniOtpadBio += korisnik.getOtpadBio();
                    ukupniOtpadMijesano += korisnik.getOtpadMjesano();
                } else if (korisnik instanceof VelikiKorisnik)//korisnik je veliki
                {

                    generirajVeliki(korisnik);
                    ukupniOtpadStaklo += korisnik.getOtpadStaklo();
                    ukupniOtpadPapir += korisnik.getOtpadPapir();
                    ukupniOtpadMetal += korisnik.getOtpadMetal();
                    ukupniOtpadBio += korisnik.getOtpadBio();
                    ukupniOtpadMijesano += korisnik.getOtpadMjesano();
                }
            }
            ulice.setUkupniOtpadStaklo(ukupniOtpadStaklo);
            ulice.setUkupniOtpadPapir(ukupniOtpadPapir);
            ulice.setUkupniOtpadMetal(ukupniOtpadMetal);
            ulice.setUkupniOtpadBio(ukupniOtpadBio);
            ulice.setUkupniOtpadMijesano(ukupniOtpadMijesano);
//            System.out.println("Ukupni kolicina pojedinog otpada za ulicu:" + ulice.getNaziv());
//            System.out.println("Ukupni otpad staklo:" + ukupniOtpadStaklo);
//            System.out.println("Ukupni otpad papir:" + ukupniOtpadPapir);
//            System.out.println("Ukupni otpad metal:" + ukupniOtpadMetal);
//            System.out.println("Ukupni otpad bio:" + ukupniOtpadBio);
//            System.out.println("Ukupni otpad mijesano:" + ukupniOtpadMijesano);

        }
    }

    public void generirajMali(KorisnikNovi korisnik) {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        korisnik.setOtpadStaklo(racunajIznosOtpada(parametar.getMaliMin(), parametar.getMaliStaklo()));
        korisnik.setOtpadPapir(racunajIznosOtpada(parametar.getMaliMin(), parametar.getMaliPapir()));
        korisnik.setOtpadMetal(racunajIznosOtpada(parametar.getMaliMin(), parametar.getMaliMetal()));
        korisnik.setOtpadBio(racunajIznosOtpada(parametar.getMaliMin(), parametar.getMaliBio()));
        korisnik.setOtpadMjesano(racunajIznosOtpada(parametar.getMaliMin(), parametar.getMaliMijesano()));
        if (parametar.getIspis() == 0) {
            String ispis = "Korisnik sa ID: " + korisnik.getIdKorisnik() + " Tip otpada: Mali" + " Staklo: " + korisnik.getOtpadStaklo() + " Papir: " + korisnik.getOtpadPapir()
                    + " Metal: " + korisnik.getOtpadMetal() + " Bio: " + korisnik.getOtpadBio() + " Mjesano: " + korisnik.getOtpadMjesano();
            System.out.println(ispis);
            Report report = new Report.ReportBuilder(ispis).build();
            pisiIzvjestaj(report);

        }
    }

    public void generirajSrednji(KorisnikNovi korisnik) {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        korisnik.setOtpadStaklo(racunajIznosOtpada(parametar.getSrednjiMin(), parametar.getSrednjiStaklo()));
        korisnik.setOtpadPapir(racunajIznosOtpada(parametar.getSrednjiMin(), parametar.getSrednjiPapir()));
        korisnik.setOtpadMetal(racunajIznosOtpada(parametar.getSrednjiMin(), parametar.getSrednjiMetal()));
        korisnik.setOtpadBio(racunajIznosOtpada(parametar.getSrednjiMin(), parametar.getSrednjiBio()));
        korisnik.setOtpadMjesano(racunajIznosOtpada(parametar.getSrednjiMin(), parametar.getSrednjiMijesano()));
        if (parametar.getIspis() == 0) {
            String ispis = "Korisnik sa ID: " + korisnik.getIdKorisnik() + " Tip otpada: Srednji" + " Staklo: " + korisnik.getOtpadStaklo() + " Papir: " + korisnik.getOtpadPapir()
                    + " Metal: " + korisnik.getOtpadMetal() + " Bio: " + korisnik.getOtpadBio() + " Mjesano: " + korisnik.getOtpadMjesano();
            System.out.println(ispis);
            Report report = new Report.ReportBuilder(ispis).build();
            pisiIzvjestaj(report);
        }
    }

    public void generirajVeliki(KorisnikNovi korisnik) {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        korisnik.setOtpadStaklo(racunajIznosOtpada(parametar.getVelikiMin(), parametar.getVelikiStaklo()));
        korisnik.setOtpadPapir(racunajIznosOtpada(parametar.getVelikiMin(), parametar.getVelikiPapir()));
        korisnik.setOtpadMetal(racunajIznosOtpada(parametar.getVelikiMin(), parametar.getVelikiMetal()));
        korisnik.setOtpadBio(racunajIznosOtpada(parametar.getVelikiMin(), parametar.getVelikiBio()));
        korisnik.setOtpadMjesano(racunajIznosOtpada(parametar.getVelikiMin(), parametar.getVelikiMijesano()));
        if (parametar.getIspis() == 0) {
            String ispis = "Korisnik sa ID: " + korisnik.getIdKorisnik() + " Tip otpada: Veliki" + " Staklo: " + korisnik.getOtpadStaklo() + " Papir: " + korisnik.getOtpadPapir()
                    + " Metal: " + korisnik.getOtpadMetal() + " Bio: " + korisnik.getOtpadBio() + " Mjesano: " + korisnik.getOtpadMjesano();
            System.out.println(ispis);
            Report report = new Report.ReportBuilder(ispis).build();
            pisiIzvjestaj(report);
        }

    }

    public float racunajIznosOtpada(int postotak, int kolicina) {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        float broj = (float) postotak / 100;
        return parametar.generateRandomFloat((float) (broj * kolicina), (float) kolicina);

    }

    public void dodijeliOtpadKontejnerima(String otpad, int tipSpremnika) {
        for (Ulice ulice : popisUlica) {
            for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {
                float kapacitet = 0;
                if (otpad.equalsIgnoreCase(spremnik.getVrstaSmecaUSpremniku())) {
                    for (Integer broj : spremnik.getPopisKorisnika()) {
                        for (KorisnikNovi korisnik : ulice.getKorisnici()) {
                            if (broj == korisnik.getIdKorisnik() && spremnik.getVrstaSmecaUSpremniku().equalsIgnoreCase(otpad) && spremnik.getTipSpremnika() == tipSpremnika) {
                                if (otpad.equalsIgnoreCase("staklo")) {
                                    kapacitet += korisnik.getOtpadStaklo();
                                    break;
                                } else if (otpad.equalsIgnoreCase("papir")) {
                                    kapacitet += korisnik.getOtpadPapir();
                                    break;
                                } else if (otpad.equalsIgnoreCase("metal")) {
                                    kapacitet += korisnik.getOtpadMetal();
                                    break;
                                } else if (otpad.equalsIgnoreCase("bio")) {
                                    kapacitet += korisnik.getOtpadBio();
                                    break;
                                } else if (otpad.equalsIgnoreCase("mjesano") || otpad.equalsIgnoreCase("mješano")) {
                                    kapacitet += korisnik.getOtpadMjesano();
                                    break;
                                }
                            }
                        }
                    }
                    if (kapacitet > 0) {
//                        System.out.println("Postavljam u spremnik sa ID:" + spremnik.getIdSpremnika() + " Iznos tereta: " + kapacitet);
                        spremnik.setKapacitetSpremnika(kapacitet);

                    }

                }
            }
        }
    }

    public void ispisiSmeceKontejneri() {
        for (Ulice ulice : popisUlica) {
            System.out.println("Ulica:" + ulice.getNaziv());
            for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {
//                System.out.println("Ovo je spremnik id:" + spremnik.getIdSpremnika() + " Koji ima u sebi:" + spremnik.getKapacitetSpremnika());
            }

        }
    }

    public void kreiranjeVozilaZaOtpad() {
        AbstractFactory factory = FactoryProducer.getFactory("VOZILO");
        for (Vozila vozila : vozila) {
            if (vozila.getVrsta().equalsIgnoreCase("0")) {
                Vozilo objekt = factory.getVozilo(TipVozila.STAKLO, vozila);
                popisVozila.add(objekt);
            } else if (vozila.getVrsta().equalsIgnoreCase("1")) {
                Vozilo objekt = factory.getVozilo(TipVozila.PAPIR, vozila);
                popisVozila.add(objekt);
            } else if (vozila.getVrsta().equalsIgnoreCase("2")) {
                Vozilo objekt = factory.getVozilo(TipVozila.METAL, vozila);
                popisVozila.add(objekt);
            } else if (vozila.getVrsta().equalsIgnoreCase("3")) {
                Vozilo objekt = factory.getVozilo(TipVozila.BIO, vozila);
                popisVozila.add(objekt);
            } else if (vozila.getVrsta().equalsIgnoreCase("4")) {
                Vozilo objekt = factory.getVozilo(TipVozila.MJESANO, vozila);
                popisVozila.add(objekt);
            }
        }

    }

    public void voziKamionePoUlicama() {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        OtpadSingleton otpadParametar = OtpadSingleton.getInstanceOtpad();
        List<Integer> redoslijedVozila = new ArrayList<Integer>();
        List<Integer> redoslijedUlica = new ArrayList<Integer>();
        List<Vozilo> randomVozila = new ArrayList<>();
        List<Vozilo> vozilaNaOtpadu = new ArrayList<>();
        List<Vozilo> vozilaZaVracanje = new ArrayList<>();
        List<Ulice> randomUlice = new ArrayList<>();

        Ulice ulicaZaRemove = null;
        int brojUnesenih = 0;
        while (brojUnesenih < popisVozila.size()) {
            int generiraniBroj = parametar.generateRandomInt(1, popisVozila.size() + 1);
            if (!redoslijedVozila.contains(generiraniBroj)) {
                redoslijedVozila.add(generiraniBroj);
                randomVozila.add(popisVozila.get(generiraniBroj - 1));
                brojUnesenih++;
            }
        }
        if (parametar.getPreuzimanje() == 0) {
            int brojUlica = 0;

            while (brojUlica < popisUlica.size()) {
                int generiraniBroj = parametar.generateRandomInt(1, popisUlica.size() + 1);
                if (!redoslijedUlica.contains(generiraniBroj)) {
                    redoslijedUlica.add(generiraniBroj);
                    randomUlice.add(popisUlica.get(generiraniBroj - 1));
                    brojUlica++;
                }
            }
            boolean sakupljaj = true;
            int ciklus = 0;

            while (sakupljaj) {
                for (Vozilo vozilo : randomVozila) {
                    if (teretUlicaZaKamion(randomUlice, vozilo) == 0) {
                        if (flagOtpad == true) {
                            flagOtpad = false;
                            break;
                        }
                        if (vozilaNaOtpadu.size() > 0) {
                            for (Vozilo vozilo1 : vozilaNaOtpadu) {   // provjeravaj vozila na otpadu
                                if (vozilo1.getBrojCiklusaNaCekanju() > 0) {

                                    vozilo1.setBrojCiklusaNaCekanju(vozilo1.getBrojCiklusaNaCekanju() - 1);
                                } else if (vozilo1.getBrojCiklusaNaCekanju() == 0) {
                                    break;
                                }
                            }
                        }
                        ciklus++;
                        continue;
                    }
                    if (teretSvihUlica(randomUlice) == 0) {
                        sakupljaj = false;
                        break;
                    }
                    kupiSmece(vozilo, randomUlice);
                    ciklus++;
                }
                for (Vozilo vozilo : randomVozila) //stavi vozila na otpad
                {
                    if (vozilo.isPreuzimanjeOtpada() == false && vozilo.isVoziNaOtpad() == true) {
                        vozilo.setPreuzimanjeOtpada(true);
                        vozilo.setVoziNaOtpad(false);
                        vozilaNaOtpadu.add(vozilo);
                    }
                }
                if (randomVozila.size() > 0) //makni vvozila s liste aktivnih vozila
                {
                    for (Vozilo vozilo : vozilaNaOtpadu) {
                        randomVozila.remove(vozilo);
                    }
                }
                if (vozilaNaOtpadu.size() > 0) {
                    for (Vozilo vozilo1 : vozilaNaOtpadu) {   // provjeravaj vozila na otpadu
                        if (vozilo1.getBrojCiklusaNaCekanju() == 0) {
                            //vrati vozilo na listu vozila
                            vozilo1.setTrenutniTeret(0);
                            randomVozila.add(vozilo1);
                            vozilaZaVracanje.add(vozilo1);
                        } else {
                            vozilo1.setBrojCiklusaNaCekanju(vozilo1.getBrojCiklusaNaCekanju() - 1);
                        }
                    }
                }
                if (vozilaZaVracanje.size() > 0) {
                    for (Vozilo voz : vozilaZaVracanje) {
                        vozilaNaOtpadu.remove(voz);
                    }
                    vozilaZaVracanje.clear();
                }
                if (teretSvihUlica(randomUlice) == 0) {
                    sakupljaj = false;
                }
            }
            for (Vozilo v : randomVozila) {
                if (v.getTrenutniTeret() > 0) {
                    v.setBrojOdlazakaNaOtpad(v.getBrojOdlazakaNaOtpad() + 1);
                    v.setKolicinaOtpadaUkupno(v.getKolicinaOtpadaUkupno() + v.getTrenutniTeret());

                    voziNaOtpad(v, otpadParametar);
                }

            }

            setPopisReportVozila(randomVozila);
        } else if (parametar.getPreuzimanje() == 1) {
            System.out.println("Preuzimam 1");
        }

    }

    public void voziNaOtpad(Vozilo v, OtpadSingleton otpadParametar) {
        if (v.getVrsta().equals("0")) {
            otpadParametar.setUkupniOtpadStaklo(otpadParametar.getUkupniOtpadStaklo() + v.getTrenutniTeret());
        } else if (v.getVrsta().equals("1")) {
            otpadParametar.setUkupniOtpadPapir(otpadParametar.getUkupniOtpadPapir() + v.getTrenutniTeret());
        } else if (v.getVrsta().equals("2")) {
            otpadParametar.setUkupniOtpadMetal(otpadParametar.getUkupniOtpadStaklo() + v.getTrenutniTeret());
        } else if (v.getVrsta().equals("3")) {
            otpadParametar.setUkupniOtpadBio(otpadParametar.getUkupniOtpadBio() + v.getTrenutniTeret());
        } else if (v.getVrsta().equals("4")) {
            otpadParametar.setUkupniOtpadMijesano(otpadParametar.getUkupniOtpadMijesano() + v.getTrenutniTeret());
        }
    }

    public void skupljajStaklo(Vozilo vozilo, SpremnikZaSmece spremnik) {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        if ((vozilo.getTrenutniTeret() + spremnik.getKapacitetSpremnika()) < vozilo.getNosivost())//ako je trenutni kapacitet + kontejner koji se kupi manji od nosivosti uzmi teret
        {
            vozilo.setTrenutniTeret(vozilo.getTrenutniTeret() + spremnik.getKapacitetSpremnika());
            spremnik.setKapacitetSpremnika(0);
            if (parametar.getIspis() == 0) {
                String ispis = "Trenutni teret u vozilu: " + vozilo.getNaziv() + " je " + vozilo.getTrenutniTeret() + " Do popunjenja ima jos slobodno: " + ((float) vozilo.getNosivost() - vozilo.getTrenutniTeret());
                System.out.println(ispis);
                Report report = new Report.ReportBuilder(ispis).build();
                pisiIzvjestaj(report);
            }
            spremnikbroj++;
            vozilo.setBrojPreuzimanja(vozilo.getBrojPreuzimanja() + 1);
            vozilo.setBrojMjestaPreuzimanja(vozilo.getBrojMjestaPreuzimanja() + spremnik.getPopisKorisnika().size());
        } else if ((vozilo.getTrenutniTeret() + spremnik.getKapacitetSpremnika()) > vozilo.getNosivost()) {
            if (parametar.getIspis() == 0) {
                String ispis = "Vozilo: " + vozilo.getNaziv() + " Vozim se na otpad";
                System.out.println(ispis);
                Report report = new Report.ReportBuilder(ispis).build();
                pisiIzvjestaj(report);
            }
            vozilo.setBrojOdlazakaNaOtpad(vozilo.getBrojOdlazakaNaOtpad() + 1);
            vozilo.setKolicinaOtpadaUkupno(vozilo.getKolicinaOtpadaUkupno() + vozilo.getTrenutniTeret());

            flagOtpad = true;
            vozilo.setPreuzimanjeOtpada(false);
            vozilo.setVoziNaOtpad(true);
            vozilo.setBrojCiklusaNaCekanju(parametar.getBrojRadnihCiklusaZaOdvoz());
            voziNaOtpad(vozilo, OtpadSingleton.getInstanceOtpad());

        }
    }

    public float teretUlice(String naziv, List<Ulice> ulica) {
        float teretUlice = 0;
        for (Ulice ulice : ulica) {
            if (ulice.getNaziv().equalsIgnoreCase(naziv)) {
                for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {
                    teretUlice += spremnik.getKapacitetSpremnika();

                }
            }
        }
        return teretUlice;
    }

    public float teretSvihUlica(List<Ulice> ulica) {
        float teretUlice = 0;
        for (Ulice ulice : ulica) {
            {
                for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {
                    teretUlice += spremnik.getKapacitetSpremnika();

                }
            }
        }
        return teretUlice;
    }

    public float teretUlicePojedinacno(String naziv, List<Ulice> ulica, Vozilo vozilo) {
        float teretUlice = 0;
        String vrstaSmeca = "";
        for (Ulice ulice : ulica) {
            if (ulice.getNaziv().equalsIgnoreCase(naziv)) {
                for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {
                    if (vozilo instanceof VoziloStaklo) {
                        vrstaSmeca = "staklo";
                    } else if (vozilo instanceof VoziloPapir) {
                        vrstaSmeca = "papir";
                    } else if (vozilo instanceof VoziloMetal) {
                        vrstaSmeca = "metal";
                    } else if (vozilo instanceof VoziloBio) {
                        vrstaSmeca = "bio";
                    } else if (vozilo instanceof VoziloMjesano) {
                        vrstaSmeca = "mjesano";
                    }
                    if (spremnik.getVrstaSmecaUSpremniku().equalsIgnoreCase(vrstaSmeca)) {
                        teretUlice += spremnik.getKapacitetSpremnika();
                    }

                }
            }
        }
        return teretUlice;
    }

    public float teretUlicaZaKamion(List<Ulice> ulica, Vozilo vozilo) {
        float teretUlice = 0;
        String vrstaSmeca = "";
        for (Ulice ulice : ulica) {
            for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {
                if (vozilo instanceof VoziloStaklo) {
                    vrstaSmeca = "staklo";
                } else if (vozilo instanceof VoziloPapir) {
                    vrstaSmeca = "papir";
                } else if (vozilo instanceof VoziloMetal) {
                    vrstaSmeca = "metal";
                } else if (vozilo instanceof VoziloBio) {
                    vrstaSmeca = "bio";
                } else if (vozilo instanceof VoziloMjesano) {
                    vrstaSmeca = "mjesano";
                }
                if (spremnik.getVrstaSmecaUSpremniku().equalsIgnoreCase(vrstaSmeca)) {
                    teretUlice += spremnik.getKapacitetSpremnika();
                }

            }
        }
        return teretUlice;
    }

    private void kupiSmece(Vozilo vozilo, List<Ulice> randomUlice) {
        for (Ulice ulica : randomUlice) {
            if (teretUlicePojedinacno(ulica.getNaziv(), randomUlice, vozilo) == 0) {
                continue;
            }
            List<SpremnikZaSmece> spremnici = ulica.getSpremniciSmeca();
            for (SpremnikZaSmece spremnikZaSmece : spremnici) {
                if (vozilo instanceof VoziloStaklo && spremnikZaSmece.getVrstaSmecaUSpremniku().equalsIgnoreCase("staklo") && spremnikZaSmece.getKapacitetSpremnika() != 0) {
                    skupljajStaklo(vozilo, spremnikZaSmece);
                    break;
                } else if (vozilo instanceof VoziloPapir && spremnikZaSmece.getVrstaSmecaUSpremniku().equalsIgnoreCase("papir") && spremnikZaSmece.getKapacitetSpremnika() != 0)//ako je vozilo za staklo i spremnik za staklo
                {
                    skupljajStaklo(vozilo, spremnikZaSmece);
                    break;
                } else if (vozilo instanceof VoziloMetal && spremnikZaSmece.getVrstaSmecaUSpremniku().equalsIgnoreCase("metal") && spremnikZaSmece.getKapacitetSpremnika() != 0)//ako je vozilo za staklo i spremnik za staklo
                {
                    skupljajStaklo(vozilo, spremnikZaSmece);
                    break;
                } else if (vozilo instanceof VoziloBio && spremnikZaSmece.getVrstaSmecaUSpremniku().equalsIgnoreCase("bio") && spremnikZaSmece.getKapacitetSpremnika() != 0)//ako je vozilo za staklo i spremnik za staklo
                {
                    skupljajStaklo(vozilo, spremnikZaSmece);
                    break;

                } else if (vozilo instanceof VoziloMjesano && spremnikZaSmece.getVrstaSmecaUSpremniku().equalsIgnoreCase("mjesano") && spremnikZaSmece.getKapacitetSpremnika() != 0)//ako je vozilo za staklo i spremnik za staklo
                {
                    skupljajStaklo(vozilo, spremnikZaSmece);
                    break;
                }

            }
            break;
        }
    }

    public List<Spremnici> getPopisSpremnika() {
        return popisSpremnika;
    }

    void ispisiKorisnikePoKontejnerima() {
        for (Ulice ulice : popisUlica) {
            System.out.println("Ulica:" + ulice.getNaziv());
            for (SpremnikZaSmece spremnik : ulice.getSpremniciSmeca()) {

                System.out.println("Spremnik:" + spremnik.getVrstaSmecaUSpremniku());
                for (Integer broj : spremnik.getPopisKorisnika()) {
                    System.out.println("Id:" + broj);
                }
            }
        }
    }

    void ispisiKolicineOtpadaZaUlice() {
        for (Ulice ulice : popisUlica) {
            System.out.println(ulice.toString());
        }
    }

    void ispisiKolicineOtpadaNaOtpadu() {
        kreirajReport(OtpadSingleton.getInstanceOtpad().toString());
    }

    public void ispisPreuzetihSpremnika(List<Vozilo> vozila) {
        String ispis = "";

        for (Vozilo voz : vozila) {
            ispis = "Vozilo :" + voz.getNaziv() + " Broj spremnika: " + voz.getBrojPreuzimanja();
            System.out.println(ispis);
            Report report = new Report.ReportBuilder(ispis).build();
            pisiIzvjestaj(report);
        }
        for (Vozilo voz : vozila) {
            ispis = "Vozilo :" + voz.getNaziv() + " Broj mjesta preuzimanja: " + voz.getBrojMjestaPreuzimanja();
            System.out.println(ispis);
            Report report = new Report.ReportBuilder(ispis).build();
            pisiIzvjestaj(report);
        }
        for (Vozilo voz : vozila) {
            ispis = "Vozilo :" + voz.getNaziv() + " Kolicina otpada preuzeta: " + voz.getKolicinaOtpadaUkupno();
            System.out.println(ispis);
            Report report = new Report.ReportBuilder(ispis).build();
            pisiIzvjestaj(report);
        }
        for (Vozilo voz : vozila) {
            ispis = "Vozilo :" + voz.getNaziv() + " Broj odlazaka: " + voz.getBrojOdlazakaNaOtpad();
            System.out.println(ispis);
            Report report = new Report.ReportBuilder(ispis).build();
            pisiIzvjestaj(report);
        }

    }

    public List<Vozilo> getPopisReportVozila() {
        return popisReportVozila;
    }

    public void setPopisReportVozila(List<Vozilo> popisReportVozila) {
        this.popisReportVozila = popisReportVozila;
    }

    public void pisiIzvjestaj(Report reportS) {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        try (FileWriter fw = new FileWriter(parametar.getIzlaz(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(reportS.getNaslov());

        } catch (IOException e) {
            System.out.println("Problem kod pisanja u datoteku!" + e);
        }

    }

    public void kreirajReport(String ispis) {
        System.out.println(ispis);
        Report report = new Report.ReportBuilder(ispis).build();
        pisiIzvjestaj(report);
    }

}
