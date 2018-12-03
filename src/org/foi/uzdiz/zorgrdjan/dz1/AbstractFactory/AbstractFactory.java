/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.AbstractFactory;

import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.KorisnikNovi;
import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Vozila;
import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipVozila;
import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipoviKorisnika;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.Vozilo;

/**
 *
 * @author Zoran
 */
public abstract class AbstractFactory {
    public abstract KorisnikNovi getKorisnikNovi(TipoviKorisnika tip);
    public abstract Vozilo getVozilo (TipVozila tip,Vozila vozilo);
}
