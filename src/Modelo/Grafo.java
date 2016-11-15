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

    private void Mapa(String Palabras) {
        char aux;
        String palabra = "";
        int cont = 0;
        for (int i = 0; i < Palabras.length(); i++) {  //Guarda todas las palabras del .txt en un hashmap   

            aux = Palabras.charAt(i);
            if (!Character.isLetter(aux) || Character.toString(aux).equals("\n") || Character.toString(aux).equals("")) { //Valida que si sean palabras.
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
            for (int j = 0; j < n; j++) {
                if(adya[i][j]==1){
                    NodoSimple x = new NodoSimple(j);
                    lista.conectar(x, i);
                }
            }
        }
        
    }

    public int getNumVertices() {
        return n;
    }

    public int getNumLados() {
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
