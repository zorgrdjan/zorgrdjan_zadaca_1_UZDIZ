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
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloBio;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloMetal;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloMjesano;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloPapir;
import org.foi.uzdiz.zorgrdjan.dz1.Vozila.VoziloStaklo;

/**
 *
 * @author Zoran
 */
public class VoziloFactory extends AbstractFactory{

    @Override
    public Vozilo getVozilo(TipVozila tipVozila,Vozila vozilo) {
         switch (tipVozila) {
            case STAKLO:
                return new VoziloStaklo(vozilo.getNaziv(), vozilo.getTip(), vozilo.getVrsta(), vozilo.getNosivost(), vozilo.getVozaci());
            case PAPIR:
                return new VoziloPapir(vozilo.getNaziv(), vozilo.getTip(), vozilo.getVrsta(), vozilo.getNosivost(), vozilo.getVozaci());
            case METAL:
                return new VoziloMetal(vozilo.getNaziv(), vozilo.getTip(), vozilo.getVrsta(), vozilo.getNosivost(), vozilo.getVozaci());
            case BIO:
                return new VoziloBio(vozilo.getNaziv(), vozilo.getTip(), vozilo.getVrsta(), vozilo.getNosivost(), vozilo.getVozaci());
            case MJESANO:
                return new VoziloMjesano(vozilo.getNaziv(), vozilo.getTip(), vozilo.getVrsta(), vozilo.getNosivost(), vozilo.getVozaci());
            default:
                return null;
        }
    }
    
    @Override
    public KorisnikNovi getKorisnikNovi(TipoviKorisnika tip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
