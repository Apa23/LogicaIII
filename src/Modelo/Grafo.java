/**
 * @author Juan Pablo Tobón Flórez y Andrés Felipe Aparicio Mestre
 */
package Modelo;

import java.util.HashMap;

/**
 * ClaseListaLigadaAdya: Clase de Listas Ligadas de adyacencia que se usa para
 * la representación y recorrido del grafo.
 */
public class Grafo {

    int n = 0;
    int l = 0;
    int[][] adya;
    int[][] inci;
    HashMap<Integer, String> vertices;
    ListaLigadaAdya lista;

    /**
     * Constructor de Grafo: Construye todos los elementos del grafo, junto con
     * su representación y el HashMap a partir de las palabras representadas
     * como Strings que entrar por parametro.
     *
     * @param Palabras
     */
    public Grafo(String Palabras) {
        vertices = new HashMap();
        this.Mapa(Palabras);
        n = vertices.size();
        adya = new int[n][n];
        construirAdya();
        inci = new int[n][l / 2];
        construirInci();
        lista = new ListaLigadaAdya(n);
        construirLista();
    }

    /**
     * Mapa: Construye el HashMap de las palabras a partir del String entrar por
     * parametro.
     *
     * @param Palabras
     */
    private void Mapa(String Palabras) {
        char aux;
        String palabra = "";
        int cont = 0;
        for (int i = 0; i < Palabras.length(); i++) {  

            aux = Palabras.charAt(i);
            if (!Character.isLetter(aux) || Character.toString(aux).equals("\n")
                    || Character.toString(aux).equals("")) { 
                if (!"".equals(palabra)) {
                    vertices.put(cont, palabra);
                    cont++;
                    palabra = "";
                }
            } else {
                palabra = palabra.concat(Character.toString(aux));
            }

        }
    }

    /**
     * esAdyacente: Metodo que determina si dos palabras serán abyacentes en el
     * grafo, Se recibe por parametro su hubicación en el HashMap.
     *
     * @param x
     * @param y
     */
    private boolean esAdyacente(int x, int y) {
        int diferencia = 0;
        String s1 = vertices.get(x);
        String s2 = vertices.get(y);
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diferencia++;
                }
            }
        } else if (s1.length() == s2.length() + 1) {
            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diferencia++;
                }
            }

        } else if (s1.length() + 1 == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diferencia++;
                }
            }
        }

        return diferencia == 1;
    }

    /**
     * construirAdya: Construye la Matriz de Adyacencia del Grafo.
     *
     */
    private void construirAdya() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (esAdyacente(i, j)) {
                    adya[i][j] = 1;
                    l++;
                }
            }
        }
    }

    /**
     * construirInci: Construye la Matriz de Adyacencia del Grafo.
     *
     */
    private void construirInci() {
        int lado = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adya[i][j] == 1) {
                    inci[i][lado] = 1;
                    inci[j][lado] = 1;
                    lado++;
                }
            }
        }
    }

    /**
     * construirLista: Construye el grafo como lista ligada de adyacencia.
     *
     */
    private void construirLista() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adya[i][j] == 1) {
                    NodoSimple x = new NodoSimple(j);
                    lista.conectar(x, i);
                }
            }
        }

    }

    /**
     * getNumVertices: Método que retorna el numero de vertices del grafo.
     *
     * @return int
     */
    public int getNumVertices() {
        return n;
    }

    /**
     * getNuLados: Método que retorna el numero de lados del grafo.
     *
     * @return int
     */
    public int getNumLados() {
        return l;
    }

     /**
     * getAdya: Método que retorna la matriz de adyacencia del grafo.
     * @return int
     */
    public int[][] getAdya() {
        return adya;
    }

    /**
     * getInci: Método que retorna la matriz de incidencia del grafo.
     * @return int
     */
    public int[][] getInci() {
        return inci;
    }

    /**
     * getVertices: Método que retorna el HashMaps donde se guardan las 
     * palabras.
     * que se representan en cada vertice del grafo.
     * @return HashMap<Integer, String>
     */
    public HashMap<Integer, String> getVertices() {
        return vertices;
    }

    /**
     * getVertices: Método que retorna la lista ligada de adyacencia que 
     * representa el grafo.
     * @return ListaLigadaAdya
     */
    public ListaLigadaAdya getLista() {
        return lista;
    }

}
