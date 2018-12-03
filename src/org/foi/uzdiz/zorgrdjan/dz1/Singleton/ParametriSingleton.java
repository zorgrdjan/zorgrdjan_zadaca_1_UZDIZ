/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zoran
 */
public class ParametriSingleton {

    private static volatile ParametriSingleton INSTANCE;
    private static volatile Random instanceRandom;
    private static String ulice;
    private static String spremnici;
    private static String vozila;
    private static String izlaz;
    private static int ispis;
    private static int sjemeGeneratora;
    private static int brojDecimala;
    private static int brojRadnihCiklusaZaOdvoz;
    private static int preuzimanje;
    private static int maliMin;
    private static int srednjiMin;
    private static int velikiMin;
    private static int maliStaklo;
    private static int maliPapir;
    private static int maliMetal;
    private static int maliBio;
    private static int maliMijesano;
    private static int srednjiStaklo;
    private static int srednjiPapir;
    private static int srednjiMetal;
    private static int srednjiBio;
    private static int srednjiMijesano;
    private static int velikiStaklo;
    private static int velikiPapir;
    private static int velikiMetal;
    private static int velikiBio;
    private static int velikiMijesano;
    private static Properties podaciParametri;

    private ParametriSingleton() {
//        try {
//            Properties prop = new Properties();
//            Path currentRelativePath = Paths.get("");
//            String s = currentRelativePath.toAbsolutePath().toString();
//          //  System.out.println("Current relative path is: " + s.replace("\\dist", ""));
//          //  s = s.replace("\\dist", "");
//          //  String adresa = "DZ_1_parametri.txt";
//          //  FileInputStream inputStream = new FileInputStream(adresa);
////            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
////            prop.load(reader);
////            this.ulice = prop.getProperty("ulice");
////            this.spremnici = prop.getProperty("spremnici");
////            this.vozila = prop.getProperty("vozila");
////            this.izlaz = prop.getProperty("izlaz");
////            this.ispis = Integer.parseInt(prop.getProperty("ispis"));
////            this.sjemeGeneratora = Integer.parseInt(prop.getProperty("sjemeGeneratora"));
////            this.brojDecimala = Integer.parseInt(prop.getProperty("brojDecimala"));
////            this.brojRadnihCiklusaZaOdvoz = Integer.parseInt(prop.getProperty("brojRadnihCiklusaZaOdvoz"));
////            this.preuzimanje = Integer.parseInt(prop.getProperty("preuzimanje"));
////            this.maliMin = Integer.parseInt(prop.getProperty("maliMin"));
////            this.srednjiMin = Integer.parseInt(prop.getProperty("srednjiMin"));
////            this.velikiMin = Integer.parseInt(prop.getProperty("velikiMin"));
////            this.maliStaklo = Integer.parseInt(prop.getProperty("maliStaklo"));
////            this.maliPapir = Integer.parseInt(prop.getProperty("maliPapir"));
////            this.maliMetal = Integer.parseInt(prop.getProperty("maliMetal"));
////            this.maliBio = Integer.parseInt(prop.getProperty("maliBio"));
////            this.maliMijesano = Integer.parseInt(prop.getProperty("maliMješano"));
////            this.srednjiStaklo = Integer.parseInt(prop.getProperty("srednjiStaklo"));
////            this.srednjiPapir = Integer.parseInt(prop.getProperty("srednjiPapir"));
////            this.srednjiMetal = Integer.parseInt(prop.getProperty("srednjiMetal"));
////            this.srednjiBio = Integer.parseInt(prop.getProperty("srednjiBio"));
////            this.srednjiMijesano = Integer.parseInt(prop.getProperty("srednjiMješano"));
////            this.velikiStaklo = Integer.parseInt(prop.getProperty("velikiStaklo"));
////            this.velikiPapir = Integer.parseInt(prop.getProperty("velikiPapir"));
////            this.velikiMetal = Integer.parseInt(prop.getProperty("velikiMetal"));
////            this.velikiBio = Integer.parseInt(prop.getProperty("velikiBio"));
////            this.velikiMijesano = Integer.parseInt(prop.getProperty("velikiMješano"));
//        } catch (IOException ex) {
//            Logger.getLogger(ParametriSingleton.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    private ParametriSingleton(String adresa) {
        try {
            Properties prop = new Properties();
         //   Path currentRelativePath = Paths.get("");
          //  String s = currentRelativePath.toAbsolutePath().toString();
          //  System.out.println("Current relative path is: " + s.replace("\\dist", ""));
           // s = s.replace("\\dist", "");
          //  String adresa = "DZ_1_parametri.txt";
            FileInputStream inputStream = new FileInputStream(adresa);
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            prop.load(reader);
            this.podaciParametri=prop;
            this.ulice = prop.getProperty("ulice");
            this.spremnici = prop.getProperty("spremnici");
            this.vozila = prop.getProperty("vozila");
            this.izlaz = prop.getProperty("izlaz");
            this.ispis = Integer.parseInt(prop.getProperty("ispis"));
            this.sjemeGeneratora = Integer.parseInt(prop.getProperty("sjemeGeneratora"));
            this.brojDecimala = Integer.parseInt(prop.getProperty("brojDecimala"));
            this.brojRadnihCiklusaZaOdvoz = Integer.parseInt(prop.getProperty("brojRadnihCiklusaZaOdvoz"));
            this.preuzimanje = Integer.parseInt(prop.getProperty("preuzimanje"));
            this.maliMin = Integer.parseInt(prop.getProperty("maliMin"));
            this.srednjiMin = Integer.parseInt(prop.getProperty("srednjiMin"));
            this.velikiMin = Integer.parseInt(prop.getProperty("velikiMin"));
            this.maliStaklo = Integer.parseInt(prop.getProperty("maliStaklo"));
            this.maliPapir = Integer.parseInt(prop.getProperty("maliPapir"));
            this.maliMetal = Integer.parseInt(prop.getProperty("maliMetal"));
            this.maliBio = Integer.parseInt(prop.getProperty("maliBio"));
            this.maliMijesano = Integer.parseInt(prop.getProperty("maliMješano"));
            this.srednjiStaklo = Integer.parseInt(prop.getProperty("srednjiStaklo"));
            this.srednjiPapir = Integer.parseInt(prop.getProperty("srednjiPapir"));
            this.srednjiMetal = Integer.parseInt(prop.getProperty("srednjiMetal"));
            this.srednjiBio = Integer.parseInt(prop.getProperty("srednjiBio"));
            this.srednjiMijesano = Integer.parseInt(prop.getProperty("srednjiMješano"));
            this.velikiStaklo = Integer.parseInt(prop.getProperty("velikiStaklo"));
            this.velikiPapir = Integer.parseInt(prop.getProperty("velikiPapir"));
            this.velikiMetal = Integer.parseInt(prop.getProperty("velikiMetal"));
            this.velikiBio = Integer.parseInt(prop.getProperty("velikiBio"));
            this.velikiMijesano = Integer.parseInt(prop.getProperty("velikiMješano"));
        } catch (IOException ex) {
            Logger.getLogger(ParametriSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ParametriSingleton getInstance( ) {
        if (INSTANCE == null) {
            synchronized (ParametriSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ParametriSingleton();
                }
            }
        }
        return INSTANCE;
    }
     public static ParametriSingleton getInstance(String Adresa ) {
        if (INSTANCE == null) {
            synchronized (ParametriSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ParametriSingleton(Adresa);
                }
            }
        }
        return INSTANCE;
    }
     public Random getInstanceRandom() {
        if (instanceRandom == null) {
                    instanceRandom = new Random(sjemeGeneratora);
        }
        return instanceRandom;
    }

    public  String generatePath(String adresa) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
   //     System.out.println("Current relative path is: " + s.replace("\\dist", ""));
        String adress = s.replace("\\dist", "");

        return adress+"\\podaci\\"+adresa;
    }

    public static Properties getPodaciParametri() {
        return podaciParametri;
    }

    public static void setPodaciParametri(Properties podaciParametri) {
        ParametriSingleton.podaciParametri = podaciParametri;
    }

    public  int generateRandomInt(int brojOd, int brojDo) {

        Random generator=getInstanceRandom();
        int broj = generator.nextInt((brojDo - brojOd)) + brojOd;
        return broj;
    }

    public  long generateRandomLong(long brojOd, long brojDo) {
        Random generator=getInstanceRandom();
        long result = brojOd + (long) (generator.nextDouble() * (brojDo - brojOd));
        return result;
    }

    public  float generateRandomFloat(Float brojOd, Float brojDo) {
        Random generator=getInstanceRandom();
        float result = brojOd + (float) (generator.nextDouble() * (brojDo - brojOd));
        DecimalFormat broj = new DecimalFormat(".##");
        String rezultat = broj.format(result);
        rezultat = rezultat.replace(",", ".");

        return Float.parseFloat(rezultat);
    }

    public  String getUlice() {
        return ulice;
    }

    public  String getSpremnici() {
        return spremnici;
    }

    public  String getVozila() {
        return vozila;
    }

    public  String getIzlaz() {
        return izlaz;
    }

    public  int getIspis() {
        return ispis;
    }

    public  int getSjemeGeneratora() {
        return sjemeGeneratora;
    }

    public  int getBrojDecimala() {
        return brojDecimala;
    }

    public  int getBrojRadnihCiklusaZaOdvoz() {
        return brojRadnihCiklusaZaOdvoz;
    }

    public  int getPreuzimanje() {
        return preuzimanje;
    }

    public  int getMaliMin() {
        return maliMin;
    }

    public  int getSrednjiMin() {
        return srednjiMin;
    }

    public  int getVelikiMin() {
        return velikiMin;
    }

    public  int getMaliStaklo() {
        return maliStaklo;
    }

    public  int getMaliPapir() {
        return maliPapir;
    }

    public  int getMaliMetal() {
        return maliMetal;
    }

    public  int getMaliBio() {
        return maliBio;
    }

    public  int getMaliMijesano() {
        return maliMijesano;
    }

    public  int getSrednjiStaklo() {
        return srednjiStaklo;
    }

    public  int getSrednjiPapir() {
        return srednjiPapir;
    }

    public  int getSrednjiMetal() {
        return srednjiMetal;
    }

    public  int getSrednjiBio() {
        return srednjiBio;
    }

    public  int getSrednjiMijesano() {
        return srednjiMijesano;
    }

    public  int getVelikiStaklo() {
        return velikiStaklo;
    }

    public  int getVelikiPapir() {
        return velikiPapir;
    }

    public  int getVelikiMetal() {
        return velikiMetal;
    }

    public  int getVelikiBio() {
        return velikiBio;
    }

    public  int getVelikiMijesano() {
        return velikiMijesano;
    }

}
