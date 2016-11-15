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
public class ListaLigadaAdya {

    NodoSimple[] vec;

    public ListaLigadaAdya(int n) {
        vec = new NodoSimple[n];
    }

    public void conectar(NodoSimple x, int n) {
        NodoSimple p = vec[n];
        if (p == null) {
            vec[n] = x;
        } else {
            while (p.getLiga() != null) {
                p = p.getLiga();
            }
            p.setLiga(x);
        }
    }

    public NodoSimple[] getVec() {
        return vec;
    }

    public NodoSimple getVec(int n) {
        return vec[n];
    }
}
