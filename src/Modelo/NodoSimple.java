/**
 * @author Juan Pablo Tobón Flórez y Andrés Felipe Aparicio Mestre
 */
package Modelo;

/**
 * Clase NodoSimple: Clase de Nodos Simples. Solamente tiene un espacio para guardar los datos y un espacio 
 * para guardar la derección de memoria del nodo siguiente.
 */
public class NodoSimple {
    int dato=0;
    NodoSimple liga = null;

     /**
     * Constructor de la clase que asigna sus parametros de entrada a los 
     * atributos de la clase.
     * @param dato
     */
    public NodoSimple(int dato) {
        this.dato = dato;
    }
    
    /**
     * getDato: Método que retorna los datos guardados en el campo data.
     * @return int
     */
    public int getDato() {
        return dato;
    }

    /**
     * getLiga: Método que retorna los datos guardaos en el campo liga.
     * @return NodoSimple
     */
    public NodoSimple getLiga() {
        return liga;
    }

    /**
     * setDato: Método que asigna un dato al campo dato.
     * @param dato
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * setData: Método que asigna un dato al campo liga.
     * @param liga
     */
    public void setLiga(NodoSimple liga) {
        this.liga = liga;
    }
    
    
    
}
