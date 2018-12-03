/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.foi.uzdiz.zorgrdjan.dz1.Singleton.ParametriSingleton;

/**
 *
 * @author Zoran
 */
public class GlavnoPodrucje {

    public List<String> listaPodrucja = new ArrayList<>();
    public List<Podrucja> listaSvihPodrucja = new ArrayList<>();
    public List<Podrucje> listaGlavnihPodrucja = new ArrayList<>();

    public void ucitajPodrucja() {
        ParametriSingleton parametar = ParametriSingleton.getInstance();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(parametar.getPodaciParametri().getProperty("područja")), "UTF8"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] dijeloviPodrucja = line.split(";");
                if (dijeloviPodrucja.length == 3) {
                    listaPodrucja.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception:" + e);
        }
    }

//    public void hardKodiraniPodaci() {
//        Podrucja p1 = new Podrucja("p1", "null");
//        Podrucja p2 = new Podrucja("p2", "p1");
//        Podrucja p3 = new Podrucja("p3", "p1");
//        p1.add(p2);
//        p1.add(p3);
//        listaGlavnihPodrucja.add(p1);
//        Podrucja p4 = new Podrucja("p4", "p2");
//        Podrucja p5 = new Podrucja("p5", "p2");
//        Podrucja p6 = new Podrucja("p6", "p2");
//        p2.add(p4);
//        p2.add(p5);
//        p2.add(p6);
//        Podrucja p7 = new Podrucja("p7", "p3");
//        Podrucja p8 = new Podrucja("p8", "p3");
//        p3.add(p7);
//        p3.add(p8);
//       
//        listaSvihPodrucja.add(p1);
//        listaSvihPodrucja.add(p2);
//        listaSvihPodrucja.add(p3);
//        listaSvihPodrucja.add(p4);
//        listaSvihPodrucja.add(p5);
//        listaSvihPodrucja.add(p6);
//        listaSvihPodrucja.add(p7);
//        listaSvihPodrucja.add(p8);
//         for (Podrucje podrucje : listaGlavnihPodrucja) {
//            Podrucja p9 = new Podrucja("p9", "p3");
//            podrucje.addProductByName("p3",p9);
//            podrucje.print();
//        }
//    }
    public void dodijeliUlicePodrucjima() {
        for (String string : listaPodrucja) {
            String[] dijeloviPodrucja = string.split(";");
            if (listaGlavnihPodrucja.isEmpty()) {
                Podrucje podrucja = new Podrucja(dijeloviPodrucja[0], "nema");
                listaGlavnihPodrucja.add(podrucja);
                if (dijeloviPodrucja[2].contains("p")) {
                    String[] podijeliPodrucja = dijeloviPodrucja[2].split(",");
                    for (int i = 0; i < podijeliPodrucja.length; i++) {
                        Podrucja novoPodrucje = new Podrucja(podijeliPodrucja[i], dijeloviPodrucja[0]);
                        podrucja.add(novoPodrucje);
                    }
                } else if (dijeloviPodrucja[2].contains("u")) {
                }
            }
            if (listaGlavnihPodrucja.isEmpty() == false) {

            }
        }
    }

    public void dodijeliPodrucja() {
        for (String string : listaPodrucja) {
            if (listaGlavnihPodrucja.isEmpty()) {
                dodijeliUlicePodrucjima();
            } else {

                String[] dijeloviPodrucja = string.split(";");
                if (dijeloviPodrucja[2].contains("p")) {
                    String[] podijeliPodrucja = dijeloviPodrucja[2].split(",");
                    for (int i = 0; i < podijeliPodrucja.length; i++) {
                        Podrucja novoPodrucje = new Podrucja(podijeliPodrucja[i], dijeloviPodrucja[0]);
                        for (Podrucje podrucje : listaGlavnihPodrucja) {
                            podrucje.addProductByName(dijeloviPodrucja[0], novoPodrucje);
                        }

                    }
                } else if (dijeloviPodrucja[2].contains("u")) {
                    String[] dijeloviPodrucjaUlica = string.split(";");
                    String[] ulice = dijeloviPodrucjaUlica[2].split(",");
                    for(int i=0;i<ulice.length;i++)
                    {
                        Ulica ulica=new Ulica(ulice[i], dijeloviPodrucjaUlica[0]);
                        for (Podrucje podrucje : listaGlavnihPodrucja) {
                            podrucje.addProductByName(dijeloviPodrucja[0], ulica);
                        }
                    }
                    
                }
            }
        }
    }

    public void ispis() {
        for (Podrucje podrucje : listaGlavnihPodrucja) {
            podrucje.print();
        }
    }
}
