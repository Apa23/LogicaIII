/**
 * @author Juan Pablo Tobón Flórez y Andrés Felipe Aparicio Mestre
 */
package Modelo;

/** 
 * ClaseListaLigadaAdya: Clase de Listas Ligadas de adyacencia que se usa para 
 * la representación y recorrido del grafo.
 */
public class ListaLigadaAdya {

    NodoSimple[] vec;

    
    /**
     * Constructor de ListaLigadaAdya: crea un vector de nodos simples del 
     * tamaño del valor del parametro de entrada.
     * 
     * @param n
     */
    public ListaLigadaAdya(int n) {
        vec = new NodoSimple[n];
    }

    /**
     * conectar: metodo que conecta un nodo simple al final de la lista ligada
     * que se ecuentra en la posicion n del vector de nodos simples.
     * 
     * @param x
     * @param n
     */
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

    /**
     * getVec: metodo que retorna el vector de nodo simple.
     * @return NodoSimple[]
     */
    public NodoSimple[] getVec() {
        return vec;
    }

    /**
     * getVec: metodo que retorna el nodo simple que se encuentra en la posicion
     * del vector del parametro de entrada.
     * @param n
     * @return NodoSimple
     */
    public NodoSimple getVec(int n) {
        return vec[n];
    }
}
