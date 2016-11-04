/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalogica2;

/**
 *
 * @author Apa
 */
public class ListaLigadaAbya {
    NodoSimple[] vec;

    public ListaLigadaAbya(int n) {
        vec = new NodoSimple[n];
    }
    
    public void conectar(NodoSimple x, int n){
        NodoSimple p = vec[n];
        while (p.getLiga()!= null){
            p= p.getLiga();
        }
        p.setLiga(x);               
    }    
}
