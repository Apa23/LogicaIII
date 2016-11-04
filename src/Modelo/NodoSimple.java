/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Apa
 */
public class NodoSimple {
    int dato=0;
    NodoSimple liga = null;

    public NodoSimple(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public NodoSimple getLiga() {
        return liga;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setLiga(NodoSimple liga) {
        this.liga = liga;
    }
    
    
    
}
