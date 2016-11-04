/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;

/**
 *
 * @author Apa
 */
public class Grafo {

    int n = 0;
    int l = 0;
    int[][] adya;
    int[][] inci;
    HashMap<Integer, String> vertices;
    ListaLigadaAdya lista;

    public Grafo(String Palabras) {
        this.Mapa(Palabras);
        n = vertices.size();
        inci = new int[n][n];
        construirAdya();
        inci = new int[l / 2][n];
        construirInci();
        lista = new ListaLigadaAdya(n);
    }

    private void Mapa(String Palabras) {
        char aux;
        String palabra = "";
        for (int i = 0; i < Palabras.length(); i++) {  //Guarda todas las palabras del .txt en un hashmap   

            aux = Palabras.charAt(i);
            if (!Character.isLetter(aux) || Character.toString(aux).equals("\n") || Character.toString(aux).equals("")) { //Valida que si sean palabras.
                if (!"".equals(palabra)) {
                    vertices.put(i, palabra);
                    palabra = "";
                }
            } else {
                palabra = palabra.concat(Character.toString(aux));
            }

        }
    }

    private boolean esAdyacente(int x, int y) {
        int diferencia = 0;
        String X = vertices.get(x);
        String Y = vertices.get(y);
        if (X.length() == Y.length()) {
            for (int i = 0; i < X.length(); i++) {
                if (X.charAt(i) != Y.charAt(i)) {
                    diferencia++;
                }
            }
        } else if (X.length() == Y.length() + 1) {
            for (int i = 0; i < Y.length(); i++) {
                if (X.charAt(i) != Y.charAt(i)) {
                    diferencia++;
                }
            }

        } else if (X.length() + 1 == Y.length()) {
            for (int i = 0; i < X.length(); i++) {
                if (X.charAt(i) != Y.charAt(i)) {
                    diferencia++;
                }
            }
        }

        return diferencia == 1;
    }

    private void construirAdya() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (esAdyacente(j, j)) {
                    adya[i][j] = 1;
                    l++;
                }
            }
        }
    }

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
    
    private void construirLista(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if(adya[i][j]==1){
                    NodoSimple x = new NodoSimple(j);
                    lista.conectar(x, n);
                }
            }
        }
        
    }

    public int getN() {
        return n;
    }

    public int getL() {
        return l;
    }

    public int[][] getAdya() {
        return adya;
    }

    public int[][] getInci() {
        return inci;
    }

    public HashMap<Integer, String> getVertices() {
        return vertices;
    }

    public ListaLigadaAdya getLista() {
        return lista;
    }
    
    
}
