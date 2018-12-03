/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.PodrucjaComposite;

/**
 *
 * @author Zoran
 */
public interface Podrucje {

    public void add(Podrucja podrucje);
    public void remove(Podrucja podrucje);
    public void  addProductByName(String imePodrucja,Podrucja podrucje);
    public void  addProductByName(String imePodrucja,Ulica ulica);
    public String getName();
    public float getStaklo();
    public float getPapir();
    public float getMetal();
    public float getBio();
    public float getMijesano();
    public void print();
}
