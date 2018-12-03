/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.zorgrdjan.dz1.KomandeChain;

/**
 *
 * @author Zoran
 */
public interface ChainKomande {
    public abstract void setNext(ChainKomande nextInChain);
    public abstract void executeCommand(String command);   
}
