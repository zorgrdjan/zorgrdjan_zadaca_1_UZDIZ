/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Zoran
 */
public class Podrucja implements Podrucje {

    public String imePodrucja;
    public String parrent;
    public List<Podrucja> listaPodrucja = new ArrayList<>();
    public List<Ulica> listaDjece = new ArrayList<>();


    public Podrucja(String imePodrucja, String parrent) {
        this.imePodrucja = imePodrucja;
        this.parrent = parrent;
    }

    @Override
    public void add(Podrucja podrucje) {
        listaPodrucja.add(podrucje);
    }

    @Override
    public void remove(Podrucja podrucje) {
        listaPodrucja.remove(podrucje);
    }

    @Override
    public void addProductByName(String imePodrucja, Podrucja podrucje) {

        if (getName().equalsIgnoreCase(imePodrucja)) {
            listaPodrucja.add(podrucje);
        } else {
            for (Podrucja podrucja : listaPodrucja) {
                podrucja.addProductByName(imePodrucja, podrucje);
            }
        }

    }

    @Override
    public String getName() {
        return this.imePodrucja;
    }



    @Override
    public void print() {
        System.out.println("-------------");
        System.out.println("Naziv podrucja: " + getName());
        System.out.println("Naziv roditelja: " + parrent);
        for (Ulica ulica : listaDjece) {
           ulica.print();
        }
        for (Podrucja podrucja : listaPodrucja) {
            podrucja.print();
        }

    }

    @Override
    public void addProductByName(String imePodrucja, Ulica ulica) {
        if (getName().equalsIgnoreCase(imePodrucja)) {
            listaDjece.add(ulica);
        } else {
            for (Podrucja podrucja : listaPodrucja) {
                podrucja.addProductByName(imePodrucja, ulica);
            }
        }
    }

    @Override
    public float getStaklo() {
       float ukupnoStaklo=0;
        for (Ulica ulica : listaDjece) {
            ukupnoStaklo+=ulica.getStaklo();
        }
        return ukupnoStaklo;
    }

    @Override
    public float getPapir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getMetal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getBio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getMijesano() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

}
