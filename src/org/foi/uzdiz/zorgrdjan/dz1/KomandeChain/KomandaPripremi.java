/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.KomandeChain;

import org.foi.uzdiz.zorgrdjan.dz1.Tipovi.TipNaredbe;

/**
 *
 * @author Zoran
 */
public class KomandaPripremi implements ChainKomande{
    private ChainKomande nextInChain; 

    @Override
    public void setNext(ChainKomande nextInChain) {
        this.nextInChain=nextInChain;
    }

    public void executeCommand(String command) {
        if(command.contains(TipNaredbe.PRIPREMI.toString()))
        {
            System.out.println("Radim naredbu Pripremi!");
        }
        else{
            nextInChain.executeCommand(command);
        }
     }
}
