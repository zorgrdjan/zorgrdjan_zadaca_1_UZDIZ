/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.AbstractFactory;

/**
 *
 * @author Zoran
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {

        if (choice.equalsIgnoreCase("KORISNIK")) {
            return new KorisnikFactory();

        } else if (choice.equalsIgnoreCase("VOZILO")) {
            return new VoziloFactory();
        }

        return null;
    }
}
