/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.AbstractFactory;

import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.MaliKorisnik;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.SrednjiKorisnik;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.KorisnikNovi;
import org.foi.uzdiz.zorgrdjan.dz1.Korisnik.VelikiKorisnik;
import org.foi.uzdiz.zorgrdjan.dz1.Podaci.Vozila;
import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipVozila;
import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipoviKorisnika;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.Vozilo;

/**
 *
 * @author Zoran
 */
public class KorisnikFactory extends AbstractFactory {

    @Override
    public KorisnikNovi getKorisnikNovi(TipoviKorisnika tip) {
        switch (tip) {
            case MALI:
                return new MaliKorisnik();
            case SREDNJI:
                return new SrednjiKorisnik();
            case VELIKI:
                return new VelikiKorisnik();
            default:
                return null;
        }
    }

    @Override
    public Vozilo getVozilo(TipVozila tip, Vozila vozilo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  


}
